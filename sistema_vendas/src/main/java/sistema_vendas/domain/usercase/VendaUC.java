package sistema_vendas.domain.usercase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import sistema_vendas.domain.dtos.VendaResumidoDTO;
import sistema_vendas.domain.entities.Produto;
import sistema_vendas.domain.entities.Usuario;
import sistema_vendas.domain.entities.Venda;
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

    public boolean realizarVenda(VendaResumidoDTO vendaResumidoDTO, int quantidadeDesejada){
        Venda venda = toModel(vendaResumidoDTO);

        return vendaService.realizarVenda(venda,quantidadeDesejada);
    }

    public double calcularValorFinal(VendaResumidoDTO vendaResumidoDTO, int quantidadeDesejada){
        Venda venda = toModel(vendaResumidoDTO);

        return vendaService.calcularValorFinal(venda, quantidadeDesejada);
    }


    private Venda toModel(VendaResumidoDTO dto){
       Usuario usuario = new Usuario(
            dto.getUsuarioResumidoDTO().getId(),
            dto.getUsuarioResumidoDTO().getNome(),
            dto.getUsuarioResumidoDTO().getDataNascimento(),
            dto.getUsuarioResumidoDTO().getNumDependentes()
        );

      Produto produto = new Produto(
            dto.getProdutoResumidoDTO().getCodigo(),
            dto.getProdutoResumidoDTO().getDescricao(),
            dto.getProdutoResumidoDTO().getQuantidadeEstoque(),
            dto.getProdutoResumidoDTO().getPrecoUnitario(),
            dto.getProdutoResumidoDTO().getCategoria()
      );

      return new Venda(dto.getId(), usuario, produto);
    }

     
}
