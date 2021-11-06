package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.api.assembler.EstadoDTOAssembler;
import com.algaworks.algafood.api.disassembler.EstadoInputDTODisassembler;
import com.algaworks.algafood.api.dto.EstadoDTO;
import com.algaworks.algafood.api.dto.input.EstadoInputDTO;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.respository.EstadoRepository;
import com.algaworks.algafood.domain.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private EstadoDTOAssembler estadoDTOAssembler;

    @Autowired
    private EstadoInputDTODisassembler estadoInputDTODisassembler;

    @GetMapping("/{estadoId}")
    public EstadoDTO buscar(@PathVariable Long estadoId) {
        Estado estado = estadoService.buscarOuFalhar(estadoId);

        return estadoDTOAssembler.toDTO(estado);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EstadoDTO adicionar(@RequestBody @Valid EstadoInputDTO estadoInputDTO) {
        Estado estado = estadoInputDTODisassembler.toDomain(estadoInputDTO);

        estado = estadoService.salvar(estado);

        return estadoDTOAssembler.toDTO(estado);
    }

    @PutMapping("/{estadoId}")
    public EstadoDTO atualizar(@PathVariable Long estadoId, @RequestBody @Valid EstadoInputDTO estadoInputDTO) {
        Estado estadoAtual = estadoService.buscarOuFalhar(estadoId);

        estadoInputDTODisassembler.copyToDomain(estadoInputDTO, estadoAtual);

        estadoAtual = estadoService.salvar(estadoAtual);

        return estadoDTOAssembler.toDTO(estadoAtual);
    }

    @DeleteMapping("/{estadoId}")
    public void remover(@PathVariable Long estadoId) {
        estadoService.excluir(estadoId);
    }

    @GetMapping
    public List<EstadoDTO> listar() {
        List<Estado> estadoList = estadoRepository.findAll();

        return estadoDTOAssembler.toCollectionDTO(estadoList);
    }
}
