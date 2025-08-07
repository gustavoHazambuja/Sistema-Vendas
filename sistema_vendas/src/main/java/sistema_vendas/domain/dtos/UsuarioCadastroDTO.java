package sistema_vendas.domain.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioCadastroDTO {
    
    private int id;
    private String nome;
    private LocalDate dataNascimento;
    private int numDependentes;
}
