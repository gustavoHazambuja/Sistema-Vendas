package sistema_vendas.domain.entities;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    
    @Id
    private int id;
    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "num_dependentes")
    private int numDependentes;

    public Usuario(int id, String nome, LocalDate dataNascimento, int numDependentes){
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.numDependentes = numDependentes;
    }

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Venda> vendas = new ArrayList<>();


    public int getIdade(){
        if(dataNascimento == null) return 0;
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

}
