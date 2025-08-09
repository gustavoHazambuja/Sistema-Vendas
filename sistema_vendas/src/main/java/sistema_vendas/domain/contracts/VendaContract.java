package sistema_vendas.domain.contracts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sistema_vendas.domain.entities.Venda;

public interface VendaContract {
    
    boolean validaVenda(int id);
    Page<Venda> listarVendas(Pageable pageable);

    boolean realizarVenda(Venda venda, int quantidadeDesejada);
}
