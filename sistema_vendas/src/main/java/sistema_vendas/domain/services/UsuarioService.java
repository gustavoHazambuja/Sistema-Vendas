package sistema_vendas.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import sistema_vendas.domain.contracts.UsuarioContract;
import sistema_vendas.domain.entities.Usuario;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioContract usuarioContract;

    public boolean validaUsuario(int id){
        return usuarioContract.validaUsuario(id);
    }

    public boolean cadastrarUsuario(Usuario usuario){
        if(usuarioContract.validaUsuario(usuario.getId())){
            return false;
        }

        return usuarioContract.cadastrarUsuario(usuario);
    }

    public Page<Usuario> listarUsuarios(Pageable pageable){
        return usuarioContract.listarUsuarios(pageable);
    }
}
