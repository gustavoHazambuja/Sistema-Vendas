package sistema_vendas.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema_vendas.domain.entities.Usuario;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResumidoDTO {
    
    private int id;
    private String nome;
    private int numDependentes;


    public static UsuarioResumidoDTO fromModel(Usuario usuario){
        return new UsuarioResumidoDTO(
            usuario.getId(),
            usuario.getNome(),
            usuario.getNumDependentes()
        );
    } 
}
