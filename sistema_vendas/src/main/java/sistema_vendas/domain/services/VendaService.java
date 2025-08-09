package sistema_vendas.domain.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import sistema_vendas.domain.contracts.ProdutoContract;
import sistema_vendas.domain.contracts.UsuarioContract;
import sistema_vendas.domain.contracts.VendaContract;
import sistema_vendas.domain.entities.CategoriaProduto;
import sistema_vendas.domain.entities.Venda;

@Service
public class VendaService {
    
    @Autowired
    private VendaContract vendaContract;

    @Autowired
    private UsuarioContract usuarioContract;

    @Autowired
    private ProdutoContract produtoContract;

    public boolean validaVenda(int id){
        return vendaContract.validaVenda(id);
    }

   
    public Page<Venda> listarVendas(Pageable pageable){
        return vendaContract.listarVendas(pageable);
    }

    public boolean realizarVenda(Venda venda, int quantidadeDesejada){
        if(!usuarioContract.validaUsuario(venda.getUsuario().getId()) || !produtoContract.validaProduto(venda.getProduto().getCodigo())){
            return false;
        }


        if(quantidadeDesejada > venda.getProduto().getQuantidadeEstoque()){
            return false;
        }

        int estoqueAtualizado = venda.getProduto().getQuantidadeEstoque() - quantidadeDesejada;
        venda.getProduto().setQuantidadeEstoque(estoqueAtualizado);

        return vendaContract.realizarVenda(venda, quantidadeDesejada);
    }

    public double calcularValorFinal(Venda venda, int quantidadeDesejada){

        double valorBase = venda.getProduto().getPrecoUnitario();
        CategoriaProduto categoria = venda.getProduto().getCategoria();

        int idadeAtual = venda.getUsuario().getIdade();

        double valorComImposto = switch(categoria){
            case ALIMENTICIO -> valorBase * 1.05; // 5%
            case AUTOMOTIVO -> valorBase * 1.30; // 30%
            case BEBIDAS_ALCOOLICAS -> valorBase * 2.00; // 100%
            case OUTRAS_CATEGORIAS -> valorBase * 1.17; // 17%
        };

        if(idadeAtual > 60 && categoria != CategoriaProduto.BEBIDAS_ALCOOLICAS){
            return valorBase * quantidadeDesejada; // Não paga imposto
        }

        if(venda.getUsuario().getNumDependentes() > 3 && categoria != CategoriaProduto.BEBIDAS_ALCOOLICAS){
            return valorComImposto * quantidadeDesejada * 0.5; // Desconto de 50% sobre o valor com imposto
        }

        return valorComImposto * quantidadeDesejada;
    }
}
