package sistema_vendas.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema_vendas.domain.entities.CategoriaProduto;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoCadastroDTO {
    
    private int codigo;
    private String descricao;
    private int quantidadeEstoque;
    private double precoUnitario;
    private CategoriaProduto categoria;
}
