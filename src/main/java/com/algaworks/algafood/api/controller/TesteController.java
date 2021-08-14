package com.algaworks.algafood.api.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.respository.CozinhaRepository;
import com.algaworks.algafood.domain.respository.RestauranteRepository;

@RestController
@RequestMapping("/teste")
public class TesteController {
	@Autowired
	private CozinhaRepository cozinhaRepository;

	@Autowired
	private RestauranteRepository restauranteRepository;

	@GetMapping("/cozinhas/por-nome")
	public List<Cozinha> cozinhaPorNome(String nome) {
		return cozinhaRepository.findByNomeContaining(nome);
	}

	@GetMapping("/cozinhas/unico-por-nome")
	public Optional<Cozinha> cozinhaUnicoPorNome(String nome) {
		return cozinhaRepository.findUnicoByNome(nome);
	}

	@GetMapping("/cozinhas/exists")
	public boolean cozinhaExists(String nome) {
		return cozinhaRepository.existsByNome(nome);
	}

	@GetMapping("/cozinhas/primeira")
	public Optional<Cozinha> cozinhaPrimeira() {
		return cozinhaRepository.buscarPrimeiro();
	}

	@GetMapping("/cozinhas/por-taxa-frete")
	public List<Restaurante> restaurantePorTaxaFrete(BigDecimal taxaInicial, BigDecimal taxaFinal) {
		return restauranteRepository.findByTaxaFreteBetween(taxaInicial, taxaFinal);
	}

	@GetMapping("/restaurantes/por-nome")
	public List<Restaurante> restaurantePorNome(String nome, Long cozinha) {
		return restauranteRepository.findByNomeContainingAndCozinhaId(nome, cozinha);
	}

	@GetMapping("/restaurantes/por-nome-query")
	public List<Restaurante> restaurantePorNomeQuery(String nome, Long cozinha) {
		return restauranteRepository.consultaPorNome(nome, cozinha);
	}

	@GetMapping("/restaurantes/primeiro-por-nome")
	public Optional<Restaurante> restaurantePrimeiroPorNome(String nome, Long cozinha) {
		return restauranteRepository.findFirstRestauranteByNomeContaining(nome);
	}

	@GetMapping("/restaurantes/top2-por-nome")
	public List<Restaurante> restauranteTopPorNome(String nome, Long cozinha) {
		return restauranteRepository.findTop2ByNomeContaining(nome);
	}

	@GetMapping("/restaurantes/por-nomer-frete")
	public List<Restaurante> restauranteTopPorNome(String nome, BigDecimal taxaInicial, BigDecimal taxaFinal) {
		return restauranteRepository.find(nome, taxaInicial, taxaFinal);
	}

	@GetMapping("/restaurantes/count-por-cozinha")
	public int restauranteCountPorCozinha(Long cozinha) {
		return restauranteRepository.countByCozinhaId(cozinha);
	}

	@GetMapping("/restaurantes/com-criteria")
	public List<Restaurante> restaurantesWithCriteria(String nome, BigDecimal taxaFreteInicial,
			BigDecimal taxaFreteFinal) {
		return restauranteRepository.findWithCriteria(nome, taxaFreteInicial, taxaFreteFinal);
	}

	@GetMapping("/restaurantes/com-frete-gratis")
	public List<Restaurante> restaurantesWithCriteria(String nome) {

		return restauranteRepository.findComFreteGratis(nome);
	}

	@GetMapping("/restaurantes/primeiro")
	public Optional<Restaurante> restaurantePrimeiro() {

		return restauranteRepository.buscarPrimeiro();
	}

}
