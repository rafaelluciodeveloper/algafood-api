package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.api.assembler.GrupoDTOAssembler;
import com.algaworks.algafood.api.disassembler.GrupoInputDTODisassembler;
import com.algaworks.algafood.api.dto.GrupoDTO;
import com.algaworks.algafood.api.dto.input.GrupoInputDTO;
import com.algaworks.algafood.domain.model.Grupo;
import com.algaworks.algafood.domain.respository.GrupoRepository;
import com.algaworks.algafood.domain.service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/grupos")
public class GrupoController {

    @Autowired
    private GrupoRepository grupoRepository;

    @Autowired
    private GrupoService grupoService;

    @Autowired
    private GrupoDTOAssembler grupoDTOAssembler;

    @Autowired
    private GrupoInputDTODisassembler grupoInputDTODisassembler;

    @GetMapping
    public List<GrupoDTO> listar() {
        List<Grupo> todosGrupos = grupoRepository.findAll();

        return grupoDTOAssembler.toCollectionDTO(todosGrupos);
    }

    @GetMapping("/{grupoId}")
    public GrupoDTO buscar(@PathVariable Long grupoId) {
        Grupo grupo = grupoService.buscarOuFalhar(grupoId);

        return grupoDTOAssembler.toDTO(grupo);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GrupoDTO adicionar(@RequestBody @Valid GrupoInputDTO grupoInputDTO) {
        Grupo grupo = grupoInputDTODisassembler.toDomain(grupoInputDTO);

        grupo = grupoService.salvar(grupo);

        return grupoDTOAssembler.toDTO(grupo);
    }

    @PutMapping("/{grupoId}")
    public GrupoDTO atualizar(@PathVariable Long grupoId,
                              @RequestBody @Valid GrupoInputDTO grupoInputDTO) {
        Grupo grupoAtual = grupoService.buscarOuFalhar(grupoId);

        grupoInputDTODisassembler.copyToDomain(grupoInputDTO, grupoAtual);

        grupoAtual = grupoService.salvar(grupoAtual);

        return grupoDTOAssembler.toDTO(grupoAtual);
    }

    @DeleteMapping("/{grupoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long grupoId) {
        grupoService.excluir(grupoId);
    }

}
