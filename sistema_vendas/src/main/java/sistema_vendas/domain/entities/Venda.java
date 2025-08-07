package sistema_vendas.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "tb_venda")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Venda {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    private int quantidade;

    private double valorFinal;
}
