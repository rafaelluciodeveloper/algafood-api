package com.algaworks.algafood.di.service;

import com.algaworks.algafood.di.model.Cliente;

public class ClienteAtivadorEvent {

	private Cliente cliente;

	public ClienteAtivadorEvent(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

}
