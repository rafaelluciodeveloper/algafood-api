package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.api.assembler.CozinhaDTOAssembler;
import com.algaworks.algafood.api.disassembler.CozinhaInputDTODisassembler;
import com.algaworks.algafood.api.dto.CozinhaDTO;
import com.algaworks.algafood.api.dto.input.CozinhaInputDTO;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.respository.CozinhaRepository;
import com.algaworks.algafood.domain.service.CozinhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/cozinhas")
public class CozinhaController {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	@Autowired
	private CozinhaService cozinhaService;

	@Autowired
	private CozinhaDTOAssembler cozinhaDTOAssembler;

	@Autowired
	private CozinhaInputDTODisassembler cozinhaInputDTODisassembler;

	@GetMapping
	public List<CozinhaDTO> listar() {
		List<Cozinha> cozinhaList =  cozinhaRepository.findAll();

		return cozinhaDTOAssembler.toCollectionDTO(cozinhaList);
	}

	@GetMapping("/{cozinhaId}")
	public CozinhaDTO buscar(@PathVariable Long cozinhaId) {
		Cozinha cozinha = cozinhaService.buscarOuFalhar(cozinhaId);

		return cozinhaDTOAssembler.toDTO(cozinha);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CozinhaDTO adicionar(@RequestBody @Valid CozinhaInputDTO cozinhaInputDTO) {
		Cozinha cozinha = cozinhaInputDTODisassembler.toDomain(cozinhaInputDTO);
		cozinha = cozinhaService.salvar(cozinha);

		return cozinhaDTOAssembler.toDTO(cozinha);	}

	@PutMapping("/{cozinhaId}")
	public CozinhaDTO atualizar(@PathVariable Long cozinhaId, @RequestBody @Valid CozinhaInputDTO cozinhaInputDTO) {
		Cozinha cozinhaAtual = cozinhaService.buscarOuFalhar(cozinhaId);
		cozinhaInputDTODisassembler.copyToDomain(cozinhaInputDTO, cozinhaAtual);
		cozinhaAtual = cozinhaService.salvar(cozinhaAtual);

		return cozinhaDTOAssembler.toDTO(cozinhaAtual);

	}

	@DeleteMapping("/{cozinhaId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long cozinhaId) {
		cozinhaService.excluir(cozinhaId);
	}

}
