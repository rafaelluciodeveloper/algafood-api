package com.algaworks.algafood.di.notiticacao;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.model.Cliente;

@TipoNotificador(NivelUrgencia.URGENTE)
@Component
public class NotificadorSMS implements Notificador {

	@Override
	public void notificar(Cliente cliente, String mensage) {

		System.out.printf("Notificando %s por SMS atraves do telefone %s: %s\n", cliente.getNome(),
				cliente.getTelefone(), mensage);
	}

}
