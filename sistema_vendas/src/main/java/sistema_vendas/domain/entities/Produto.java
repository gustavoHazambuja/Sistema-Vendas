package sistema_vendas.domain.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    
    @Id
    private int codigo;
    private String descricao;
    private int quantidadeEstoque;
    private double precoUnitario;

    @Enumerated(EnumType.STRING)
    private CategoriaProduto categoria;

    @OneToMany(mappedBy = "produto")
    private List<Venda> vendas = new ArrayList<>();
}
