package sistema_vendas.domain.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sistema_vendas.domain.contracts.ProdutoContract;
import sistema_vendas.domain.contracts.UsuarioContract;
import sistema_vendas.domain.contracts.VendaContract;
import sistema_vendas.domain.entities.CategoriaProduto;
import sistema_vendas.domain.entities.Produto;
import sistema_vendas.domain.entities.Usuario;
import sistema_vendas.domain.entities.Venda;

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

    public boolean realizarVenda(Usuario usuario, Produto produto, int quantidadeDesejada){
        if(!usuarioContract.validaUsuario(usuario.getId()) || !produtoContract.validaProduto(produto.getCodigo())){
            return false;
        }


        if(quantidadeDesejada > produto.getQuantidadeEstoque()){
            return false;
        }

        int estoqueAtualizado = produto.getQuantidadeEstoque() - quantidadeDesejada;
        produto.setQuantidadeEstoque(estoqueAtualizado);

        return vendaContract.realizarVenda(usuario, produto, quantidadeDesejada);
    }

    public static double calcularValorFinal(Usuario usuario,Produto produto, int quantidadeDesejada){

        double valorBase = produto.getPrecoUnitario();
        CategoriaProduto categoria = produto.getCategoria();
        int idadeAtual = usuario.getIdade();

        double valorComImposto = switch(categoria){
            case ALIMENTICIO -> valorBase * 1.05; // 5%
            case AUTOMOTIVO -> valorBase * 1.30; // 30%
            case BEBIDAS_ALCOOLICAS -> valorBase * 2.00; // 100%
            case OUTRAS_CATEGORIAS -> valorBase * 1.17; // 17%
        };

        if(idadeAtual > 60 && categoria != CategoriaProduto.BEBIDAS_ALCOOLICAS){
            return valorBase * quantidadeDesejada; // Não paga imposto
        }

        if(usuario.getNumDependentes() > 3 && categoria != CategoriaProduto.BEBIDAS_ALCOOLICAS){
            return valorComImposto - 1.50; // Desconto de 50% sobre o valor com imposto
        }

        return valorComImposto * quantidadeDesejada;
    }
}
