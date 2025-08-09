package sistema_vendas.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema_vendas.domain.entities.CategoriaProduto;
import sistema_vendas.domain.entities.Produto;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoResumidoDTO {
    
    private int codigo;
    private String descricao;
    private int quantidadeEstoque;
    private double precoUnitario;
    private CategoriaProduto categoria;



    public static ProdutoResumidoDTO fromModel(Produto produto){
        return new ProdutoResumidoDTO(
            produto.getCodigo(),
            produto.getDescricao(),
            produto.getQuantidadeEstoque(),
            produto.getPrecoUnitario(),
            produto.getCategoria()
        );
    }
}
