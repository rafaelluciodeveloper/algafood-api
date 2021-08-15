package com.algaworks.algafood.domain.respository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.infrastructure.repository.RestauranteRepositoryQueries;

@Repository
public interface RestauranteRepository extends CustomJpaRepository<Restaurante, Long>, RestauranteRepositoryQueries,
		JpaSpecificationExecutor<Restaurante> {

	@Query("from Restaurante r join fetch  r.cozinha join fetch r.formasPagamento")
	List<Restaurante> findAll();

	List<Restaurante> findByTaxaFreteBetween(BigDecimal dataInicial, BigDecimal dataFinal);

	List<Restaurante> findByNomeContainingAndCozinhaId(String nome, Long cozinha);

	// @Query("from Restaurante where nome like %:nome% and cozinha.id = :id")
	List<Restaurante> consultaPorNome(String nome, @Param("id") Long cozinha);

	Optional<Restaurante> findFirstRestauranteByNomeContaining(String nome);

	List<Restaurante> findTop2ByNomeContaining(String nome);

	int countByCozinhaId(Long cozinha);

	List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);

}
