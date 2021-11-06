package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.api.assembler.CidadeDTOAssembler;
import com.algaworks.algafood.api.disassembler.CidadeInputDTODisassembler;
import com.algaworks.algafood.api.dto.CidadeDTO;
import com.algaworks.algafood.api.dto.input.CidadeInputDTO;
import com.algaworks.algafood.domain.exception.EstadoNaoEncontradoException;
import com.algaworks.algafood.domain.exception.NegocioException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.respository.CidadeRepository;
import com.algaworks.algafood.domain.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private CidadeDTOAssembler cidadeDTOAssembler;

    @Autowired
    private CidadeInputDTODisassembler cidadeInputDTODisassembler;

    @GetMapping("/{cidadeId}")
    public CidadeDTO buscar(@PathVariable Long cidadeId) {
        Cidade cidade = cidadeService.buscarOuFalhar(cidadeId);

        return cidadeDTOAssembler.toDTO(cidade);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CidadeDTO adicionar(@RequestBody @Valid CidadeInputDTO cidadeInputDTO) {
        try {
            Cidade cidade = cidadeInputDTODisassembler.toDomain(cidadeInputDTO);

            cidade = cidadeService.salvar(cidade);

            return cidadeDTOAssembler.toDTO(cidade);
        } catch (EstadoNaoEncontradoException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @PutMapping("/{cidadeId}")
    public CidadeDTO atualizar(@PathVariable Long cidadeId, @RequestBody @Valid CidadeInputDTO cidadeInputDTO) {

        try {
            Cidade cidadeAtual = cidadeService.buscarOuFalhar(cidadeId);

            cidadeInputDTODisassembler.copyToDomain(cidadeInputDTO, cidadeAtual);

            cidadeAtual = cidadeService.salvar(cidadeAtual);

            return cidadeDTOAssembler.toDTO(cidadeAtual);
        } catch (EstadoNaoEncontradoException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @DeleteMapping("/{cidadeId}")
    public void remover(@PathVariable Long cidadeId) {
        cidadeService.excluir(cidadeId);
    }

    @GetMapping
    public List<Cidade> listar() {
        return cidadeRepository.findAll();
    }

}
