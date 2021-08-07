package com.algaworks.algafood.di.notiticacao;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.model.Cliente;

@Component
public class NotificadorEmail implements Notificador {

	@Override
	public void notificar(Cliente cliente, String mensage) {

		System.out.printf("Notificando %s através do e-mail %s: %s\n", cliente.getNome(), cliente.getEmail(), mensage);
	}

}
