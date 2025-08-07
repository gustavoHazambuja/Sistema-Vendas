package sistema_vendas.data;

import sistema_vendas.domain.entities.Venda;

public interface VendaRepository {
    void salvar(Venda venda);
}
