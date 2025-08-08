package sistema_vendas.interfaceCont.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sistema_vendas.domain.dtos.ProdutoCadastroDTO;
import sistema_vendas.domain.dtos.UsuarioCadastroDTO;
import sistema_vendas.domain.dtos.VendaResumidoDTO;
import sistema_vendas.domain.usercase.VendaUC;

@RequestMapping
@RestController(value = "/vendas")
public class VendaController {
    
    @Autowired
    private VendaUC vendaUC;


    @GetMapping(value = "/validaVenda/{id}")
    public boolean validaVenda(@PathVariable int id){
        return vendaUC.validaVenda(id);
    }


    @GetMapping(value = "/listarVendas")
    public ResponseEntity<Page<VendaResumidoDTO>> listarVendas(Pageable pageable){

        Page<VendaResumidoDTO> result = vendaUC.listarVendas(pageable);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping(value = "/realizarVenda/{quantidadeDesejada}")
    public boolean realizarVenda(@RequestBody UsuarioCadastroDTO usuarioCadastroDTO, @RequestBody ProdutoCadastroDTO produtoCadastroDTO, @PathVariable int quantidadeDesejada){
        return vendaUC.realizarVenda(usuarioCadastroDTO, produtoCadastroDTO, quantidadeDesejada);
    }

    @GetMapping(value = "/valorFinal/{quantidadeDesejada}")
    public double calcularValorFinal(@RequestBody UsuarioCadastroDTO usuarioCadastroDTO, @RequestBody ProdutoCadastroDTO produtoCadastroDTO, int quantidadeDesejada){
        return vendaUC.calcularValorFinal(usuarioCadastroDTO, produtoCadastroDTO, quantidadeDesejada);
    }
}
