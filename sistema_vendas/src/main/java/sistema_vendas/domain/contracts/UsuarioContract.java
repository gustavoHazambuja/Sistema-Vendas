package sistema_vendas.domain.contracts;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sistema_vendas.domain.entities.Usuario;

public interface UsuarioContract {
    
    boolean validaUsuario(int id);
    boolean cadastrarUsuario(Usuario usuario);
    Page<Usuario> listarUsuarios(Pageable pageable);
}
