package sistema_vendas.domain.usercase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import sistema_vendas.domain.dtos.UsuarioCadastroDTO;
import sistema_vendas.domain.dtos.UsuarioResumidoDTO;
import sistema_vendas.domain.entities.Usuario;
import sistema_vendas.domain.services.UsuarioService;

@Component
public class UsuarioUC {
    

    @Autowired
    private UsuarioService usuarioService;

    public boolean validaUsuario(int id){
        return usuarioService.validaUsuario(id);
    }

    public boolean cadastrarUsuario(UsuarioCadastroDTO dto){
        Usuario usuario = toModel(dto);
        return usuarioService.cadastrarUsuario(usuario);
    }

    public Page<UsuarioResumidoDTO> listarUsuarios(Pageable pageable){
        return usuarioService.listarUsuarios(pageable)
            .map(UsuarioResumidoDTO::fromModel);
    }




    private Usuario toModel(UsuarioCadastroDTO dto){
        return new Usuario(
            dto.getId(),
            dto.getNome(),
            dto.getDataNascimento(),
            dto.getNumDependentes()
        );
    }
}
