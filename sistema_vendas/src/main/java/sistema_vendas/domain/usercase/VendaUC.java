package sistema_vendas.domain.usercase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import sistema_vendas.domain.dtos.ProdutoCadastroDTO;
import sistema_vendas.domain.dtos.UsuarioCadastroDTO;
import sistema_vendas.domain.dtos.VendaResumidoDTO;
import sistema_vendas.domain.entities.Produto;
import sistema_vendas.domain.entities.Usuario;
import sistema_vendas.domain.services.VendaService;

@Component
public class VendaUC {
    
    @Autowired
    private VendaService vendaService;


    public boolean validaVenda(int id){
        return vendaService.validaVenda(id);
    }

    public Page<VendaResumidoDTO> listarVendas(Pageable pageable){
        return vendaService.listarVendas(pageable)
            .map(VendaResumidoDTO::fromModel);
    }

    public boolean realizarVenda(UsuarioCadastroDTO usuarioCadastroDTO, ProdutoCadastroDTO produtoCadastroDTO, int quantidadeDesejada){
        Usuario usuario = toModel(usuarioCadastroDTO);
        Produto produto = toModel(produtoCadastroDTO);

        return vendaService.realizarVenda(usuario, produto, quantidadeDesejada);
    }

    public double calcularValorFinal(UsuarioCadastroDTO usuarioCadastroDTO, ProdutoCadastroDTO produtoCadastroDTO, int quantidadeDesejada){
        Usuario usuario = toModel(usuarioCadastroDTO);
        Produto produto = toModel(produtoCadastroDTO);

        return vendaService.calcularValorFinal(usuario, produto, quantidadeDesejada);
    }





     private Usuario toModel(UsuarioCadastroDTO dto){
        return new Usuario(
            dto.getId(),
            dto.getNome(),
            dto.getDataNascimento(),
            dto.getNumDependentes()
        );
    }

      private Produto toModel(ProdutoCadastroDTO dto){
        return new Produto(
            dto.getCodigo(),
            dto.getDescricao(),
            dto.getQuantidadeEstoque(),
            dto.getPrecoUnitario(),
            dto.getCategoriaProduto()
        );
    }
}
