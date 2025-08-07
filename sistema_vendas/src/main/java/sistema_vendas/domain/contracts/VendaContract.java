package sistema_vendas.domain.contracts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sistema_vendas.domain.entities.Produto;
import sistema_vendas.domain.entities.Usuario;
import sistema_vendas.domain.entities.Venda;

public interface VendaContract {
    
    boolean validaVenda(int id);
    Page<Venda> listarVendas(Pageable pageable);

    boolean realizarVenda(Usuario usuario, Produto produto, int quantidadeDesejada);
}
