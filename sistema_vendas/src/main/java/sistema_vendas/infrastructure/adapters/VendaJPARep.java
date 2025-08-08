package sistema_vendas.infrastructure.adapters;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import sistema_vendas.domain.entities.Venda;

public interface VendaJPARep extends JpaRepository<Venda, Integer> {
    
    boolean existsById(int id);
}
