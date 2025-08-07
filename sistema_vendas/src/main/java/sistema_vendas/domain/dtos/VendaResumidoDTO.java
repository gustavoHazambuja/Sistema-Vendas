package sistema_vendas.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema_vendas.domain.entities.Venda;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VendaResumidoDTO {
    
    private int id;

    private UsuarioResumidoDTO usuarioResumidoDTO;
    private ProdutoResumidoDTO produtoResumidoDTO;



    public static VendaResumidoDTO fromModel(Venda venda){
        return new VendaResumidoDTO(
            venda.getId(),
            UsuarioResumidoDTO.fromModel(venda.getUsuario()),
            ProdutoResumidoDTO.fromModel(venda.getProduto())
        );
    }
}
