package sistema_vendas.infrastructure.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import sistema_vendas.domain.contracts.VendaContract;
import sistema_vendas.domain.entities.Produto;
import sistema_vendas.domain.entities.Usuario;
import sistema_vendas.domain.entities.Venda;
import sistema_vendas.infrastructure.adapters.VendaJPARep;

@Repository
public class VendaRepository implements VendaContract {
    

    @Autowired
    private VendaJPARep vendaJPARep;


    @Override
    public boolean validaVenda(int id){
        return vendaJPARep.existsById(id);
    }

    @Override
    public Page<Venda> listarVendas(Pageable pageable){
        return vendaJPARep.findAll(pageable);
    }

    @Override
    public boolean realizarVenda(Venda venda, int quantidadeDesejada){
           if(venda == null){
            return false;
           }

           return vendaJPARep.save(venda) != null;
    }

}
