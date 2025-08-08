package sistema_vendas.domain.usercase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import sistema_vendas.domain.dtos.ProdutoCadastroDTO;
import sistema_vendas.domain.dtos.ProdutoResumidoDTO;
import sistema_vendas.domain.entities.Produto;
import sistema_vendas.domain.services.ProdutoService;

@Component
public class ProdutoUC {
    

    @Autowired
    private ProdutoService produtoService;

    
    public boolean validaProduto(int codigo){
        return produtoService.validaProduto(codigo);
    }

    public boolean cadastrarProduto(ProdutoCadastroDTO dto){
        Produto produto = toModel(dto);
        return produtoService.categoriaProduto(produto);
    }

    public Page<ProdutoResumidoDTO> listarProdutos(Pageable pageable){
        return produtoService.listarProdutos(pageable)
            .map(ProdutoResumidoDTO::fromModel);
    }




    private Produto toModel(ProdutoCadastroDTO dto){
        return new Produto(
            dto.getCodigo(),
            dto.getDescricao(),
            dto.getQuantidadeEstoque(),
            dto.getPrecoUnitario(),
            dto.getCategoriaProduto()
        );
    }
}
