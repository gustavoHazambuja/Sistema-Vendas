package sistema_vendas.infrastructure.adapters;

import org.springframework.data.jpa.repository.JpaRepository;

import sistema_vendas.domain.entities.Usuario;

public interface UsuarioJPARep extends JpaRepository<Usuario, Integer> {
    
    boolean existsById(int id);
}
