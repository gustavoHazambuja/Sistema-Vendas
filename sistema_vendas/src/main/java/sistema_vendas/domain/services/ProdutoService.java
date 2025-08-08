package sistema_vendas.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import sistema_vendas.domain.contracts.ProdutoContract;
import sistema_vendas.domain.entities.Produto;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoContract produtoContract;

    public boolean validaProduto(int codigo){
        return produtoContract.validaProduto(codigo);
    }

    public boolean categoriaProduto(Produto produto){
        if(produtoContract.validaProduto(produto.getCodigo())){
            return false;
        }

        return produtoContract.cadastrarProduto(produto);
    }

    public Page<Produto> listarProdutos(Pageable pageable){
        return produtoContract.listarProdutos(pageable);
    }
}
