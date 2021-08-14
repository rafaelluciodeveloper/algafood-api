package com.algaworks.algafood.domain.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Cozinha;

@Repository
public interface CozinhaRepository extends CustomJpaRepository<Cozinha, Long> {

	List<Cozinha> findByNomeContaining(String nome);

	Optional<Cozinha> findUnicoByNome(String nome);

	boolean existsByNome(String nome);

}
