package sistema_vendas.data;

import sistema_vendas.domain.entities.Usuario;

public interface UsuarioRepository {
    Usuario findById(int id);
}
