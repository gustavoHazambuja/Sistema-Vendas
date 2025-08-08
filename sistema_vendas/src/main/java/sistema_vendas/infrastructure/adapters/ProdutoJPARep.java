package sistema_vendas.infrastructure.adapters;

import org.springframework.data.jpa.repository.JpaRepository;

import sistema_vendas.domain.entities.Produto;

public interface ProdutoJPARep extends JpaRepository<Produto,Integer> {
    
    boolean existsByCodigo(int codigo);
}
