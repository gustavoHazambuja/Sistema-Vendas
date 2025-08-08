package sistema_vendas.infrastructure.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import sistema_vendas.domain.contracts.UsuarioContract;
import sistema_vendas.domain.entities.Usuario;
import sistema_vendas.infrastructure.adapters.UsuarioJPARep;

@Repository
public class UsuarioRepository implements UsuarioContract {
    

    @Autowired
    private UsuarioJPARep usuarioJPARep;


    @Override
    public boolean validaUsuario(int id){
        return usuarioJPARep.existsById(id);
    }

    @Override
    public boolean cadastrarUsuario(Usuario usuario){
        if(usuario == null){
            return false;
        }

        return usuarioJPARep.save(usuario) != null;
    }

    @Override
    public Page<Usuario> listarUsuarios(Pageable pageable){
        return usuarioJPARep.findAll(pageable);
    }
}
