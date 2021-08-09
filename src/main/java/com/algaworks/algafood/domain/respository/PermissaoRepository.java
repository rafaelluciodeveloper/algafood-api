package com.algaworks.algafood.domain.respository;

import java.util.List;

import com.algaworks.algafood.domain.model.Permissao;

public interface PermissaoRepository {

	List<Permissao> listar();

	Permissao buscar(Long id);

	Permissao salvar(Permissao permissao);

	void remover(Permissao permissao);

}
