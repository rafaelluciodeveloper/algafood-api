package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.api.assembler.FormaPagamentoDTOAssembler;
import com.algaworks.algafood.api.disassembler.FormaPagamentoInputDTODisassembler;
import com.algaworks.algafood.api.dto.FormaPagamentoDTO;
import com.algaworks.algafood.api.dto.input.FormaPagamentoInputDTO;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.respository.FormaPagamentoRepository;
import com.algaworks.algafood.domain.service.FormaPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public class FormaPagamentoController {

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    @Autowired
    private FormaPagamentoService formaPagamentoService;

    @Autowired
    private FormaPagamentoDTOAssembler formaPagamentoDTOAssembler;

    @Autowired
    private FormaPagamentoInputDTODisassembler formaPagamentoInputDTODisassembler;

    @GetMapping
    public List<FormaPagamentoDTO> listar() {
        List<FormaPagamento> todasFormasPagamentos = formaPagamentoRepository.findAll();

        return formaPagamentoDTOAssembler.toCollectionDTO(todasFormasPagamentos);
    }

    @GetMapping("/{formaPagamentoId}")
    public FormaPagamentoDTO buscar(@PathVariable Long formaPagamentoId) {
        FormaPagamento formaPagamento = formaPagamentoService.buscarOuFalhar(formaPagamentoId);

        return formaPagamentoDTOAssembler.toDTO(formaPagamento);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FormaPagamentoDTO adicionar(@RequestBody @Valid FormaPagamentoInputDTO formaPagamentoInputDTO) {
        FormaPagamento formaPagamento = formaPagamentoInputDTODisassembler.toDomain(formaPagamentoInputDTO);

        formaPagamento = formaPagamentoService.salvar(formaPagamento);

        return formaPagamentoDTOAssembler.toDTO(formaPagamento);
    }

    @PutMapping("/{formaPagamentoId}")
    public FormaPagamentoDTO atualizar(@PathVariable Long formaPagamentoId,
                                       @RequestBody @Valid FormaPagamentoInputDTO formaPagamentoInputDTO) {
        FormaPagamento formaPagamentoAtual = formaPagamentoService.buscarOuFalhar(formaPagamentoId);

        formaPagamentoInputDTODisassembler.copyToDomain(formaPagamentoInputDTO, formaPagamentoAtual);

        formaPagamentoAtual = formaPagamentoService.salvar(formaPagamentoAtual);

        return formaPagamentoDTOAssembler.toDTO(formaPagamentoAtual);
    }

    @DeleteMapping("/{formaPagamentoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long formaPagamentoId) {
        formaPagamentoService.excluir(formaPagamentoId);
    }

}
