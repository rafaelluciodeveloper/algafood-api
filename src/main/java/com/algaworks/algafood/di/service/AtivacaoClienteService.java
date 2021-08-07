package com.algaworks.algafood.di.service;

import com.algaworks.algafood.di.model.Cliente;
import com.algaworks.algafood.di.notiticacao.Notificador;

public class AtivacaoClienteService {

	private Notificador notificador;

	public AtivacaoClienteService(Notificador notificador) {
		super();
		this.notificador = notificador;
	}

	public void ativar(Cliente cliente) {
		cliente.ativar();

		notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
	}

}
