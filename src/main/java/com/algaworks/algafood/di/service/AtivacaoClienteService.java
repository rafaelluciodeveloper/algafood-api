package com.algaworks.algafood.di.service;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.model.Cliente;
import com.algaworks.algafood.di.notiticacao.Notificador;

@Component
public class AtivacaoClienteService {

	private Notificador notificador;

	public AtivacaoClienteService(Notificador notificador) {
		this.notificador = notificador;
	}

	public void ativar(Cliente cliente) {
		cliente.ativar();

		notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
	}

}
