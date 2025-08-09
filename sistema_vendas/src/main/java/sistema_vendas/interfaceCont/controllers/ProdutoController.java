package sistema_vendas.interfaceCont.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sistema_vendas.domain.dtos.ProdutoCadastroDTO;
import sistema_vendas.domain.dtos.ProdutoResumidoDTO;
import sistema_vendas.domain.usercase.ProdutoUC;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoUC produtoUC;


    @GetMapping(value = "/validaProduto/{codigo}")
    public boolean validaProduto(@PathVariable int codigo){
        return produtoUC.validaProduto(codigo);
    }

    @PostMapping(value = "/cadastroProduto")
    public ResponseEntity<?> cadastrarProduto(@RequestBody ProdutoCadastroDTO produtoCadastroDTO){
        boolean resposta = produtoUC.cadastrarProduto(produtoCadastroDTO);

        if(resposta){
            return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("resposta: ", resposta, "mensagem: ", "Produto cadastrato com sucesso."));
        }
        else{
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of("resposta: ", resposta, "mensagem: ", "Falha no cadastro, código do produto já existente"));
        }
    }

    @GetMapping(value = "/listarProdutos")
    public ResponseEntity<Page<ProdutoResumidoDTO>> listarProdutos(Pageable pageable){

        Page<ProdutoResumidoDTO> result = produtoUC.listarProdutos(pageable);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
