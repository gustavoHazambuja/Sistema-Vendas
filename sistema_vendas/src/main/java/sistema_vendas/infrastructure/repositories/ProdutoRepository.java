package sistema_vendas.infrastructure.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import sistema_vendas.domain.contracts.ProdutoContract;
import sistema_vendas.domain.entities.Produto;
import sistema_vendas.infrastructure.adapters.ProdutoJPARep;

@Repository
public class ProdutoRepository implements ProdutoContract{
    
    @Autowired
    private ProdutoJPARep produtoJPARep;

    @Override
    public boolean validaProduto(int codigo){
        return produtoJPARep.existsByCodigo(codigo);
    }


    @Override
    public boolean cadastrarProduto(Produto produto){
        if(produto == null){
            return false;
        }

        return produtoJPARep.save(produto) != null;
    }
    

    @Override
    public Page<Produto> listarProdutos(Pageable pageable){
        return produtoJPARep.findAll(pageable);
    }

}
