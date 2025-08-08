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

import sistema_vendas.domain.dtos.UsuarioCadastroDTO;
import sistema_vendas.domain.dtos.UsuarioResumidoDTO;
import sistema_vendas.domain.usercase.UsuarioUC;

@RequestMapping
@RestController(value = "/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioUC usuarioUC;


    @GetMapping(value = "/validaUsuario{id}")
    public boolean validaUsuario(@PathVariable int id){
        return usuarioUC.validaUsuario(id);
    }

    @PostMapping(value = "/cadastroUsuario")
    public ResponseEntity<?> cadastrarUsuario(@RequestBody UsuarioCadastroDTO usuarioCadastroDTO){
        boolean resposta = usuarioUC.cadastrarUsuario(usuarioCadastroDTO);

        if(resposta){
            return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("resposta: ", resposta, "mensagem:", "Usuário cadastrato com sucesso."));
        }
        else{
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of("resposta: ", resposta, "mensagem: ", "Falha no cadastro, id do usuário já registrado."));
        }
    }

    @GetMapping(value = "/listarUsuarios")
    public ResponseEntity<Page<UsuarioResumidoDTO>> listarUsuarios(Pageable pageable){
        
        Page<UsuarioResumidoDTO> result = usuarioUC.listarUsuarios(pageable);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
