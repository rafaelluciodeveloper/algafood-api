package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.api.assembler.UsuarioDTOAssembler;
import com.algaworks.algafood.api.disassembler.UsuarioInputDTODisassembler;
import com.algaworks.algafood.api.dto.UsuarioDTO;
import com.algaworks.algafood.api.dto.input.SenhaInputDTO;
import com.algaworks.algafood.api.dto.input.UsuarioComSenhaInputDTO;
import com.algaworks.algafood.api.dto.input.UsuarioInputDTO;
import com.algaworks.algafood.domain.model.Usuario;
import com.algaworks.algafood.domain.respository.UsuarioRepository;
import com.algaworks.algafood.domain.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioDTOAssembler usuarioDTOAssembler;

    @Autowired
    private UsuarioInputDTODisassembler usuarioInputDTODisassembler;

    @GetMapping
    public List<UsuarioDTO> listar() {
        List<Usuario> todasUsuarios = usuarioRepository.findAll();

        return usuarioDTOAssembler.toCollectionDTO(todasUsuarios);
    }

    @GetMapping("/{usuarioId}")
    public UsuarioDTO buscar(@PathVariable Long usuarioId) {
        Usuario usuario = usuarioService.buscarOuFalhar(usuarioId);

        return usuarioDTOAssembler.toDTO(usuario);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDTO adicionar(@RequestBody @Valid UsuarioComSenhaInputDTO usuarioComSenhaInputDTO) {
        Usuario usuario = usuarioInputDTODisassembler.toDomain(usuarioComSenhaInputDTO);
        usuario = usuarioService.salvar(usuario);

        return usuarioDTOAssembler.toDTO(usuario);
    }

    @PutMapping("/{usuarioId}")
    public UsuarioDTO atualizar(@PathVariable Long usuarioId,
                                @RequestBody @Valid UsuarioInputDTO usuarioInputDTO) {
        Usuario usuarioAtual = usuarioService.buscarOuFalhar(usuarioId);
        usuarioInputDTODisassembler.copyToDomain(usuarioInputDTO, usuarioAtual);
        usuarioAtual = usuarioService.salvar(usuarioAtual);

        return usuarioDTOAssembler.toDTO(usuarioAtual);
    }

    @PutMapping("/{usuarioId}/senha")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void alterarSenha(@PathVariable Long usuarioId, @RequestBody @Valid SenhaInputDTO senha) {
        usuarioService.alterarSenha(usuarioId, senha.getSenhaAtual(), senha.getNovaSenha());
    }

}
