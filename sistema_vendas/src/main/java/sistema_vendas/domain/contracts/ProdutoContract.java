package sistema_vendas.domain.contracts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sistema_vendas.domain.entities.Produto;

public interface ProdutoContract {
    
    boolean validaProduto(int codigo);
    boolean cadastrarProduto(Produto produto);
    Page<Produto> listarProdutos(Pageable pageable);
}
