package com.algaworks.algafood.di.notiticacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.model.Cliente;

@Profile("production")
@TipoNotificador(NivelUrgencia.SEM_URGENCIA)
@Component
public class NotificadorEmail implements Notificador {

	@Autowired
	private NotificadorProperties properties;

	@Override
	public void notificar(Cliente cliente, String mensage) {
		System.out.println("Host: " + properties.getHostServidor());
		System.out.println("Porta: " + properties.getPortaServidor());

		System.out.printf("Notificando %s através do e-mail %s: %s\n", cliente.getNome(), cliente.getEmail(), mensage);
	}

}
