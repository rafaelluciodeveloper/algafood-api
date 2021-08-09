package com.algaworks.algafood.domain.respository;

import java.util.List;

import com.algaworks.algafood.domain.model.Estado;

public interface EstadoRespository {

	List<Estado> listar();

	Estado buscar(Long id);

	Estado salvar(Estado estado);

	void remover(Estado estado);

}
