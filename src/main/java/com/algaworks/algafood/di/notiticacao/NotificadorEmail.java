package com.algaworks.algafood.di.notiticacao;

import com.algaworks.algafood.di.model.Cliente;

public class NotificadorEmail implements Notificador {

	private String smtpHost;
	private boolean caixaAlta;

	public NotificadorEmail(String smtpHost) {
		this.smtpHost = smtpHost;
	}

	@Override
	public void notificar(Cliente cliente, String mensage) {
		if (this.caixaAlta) {
			mensage = mensage.toUpperCase();
		}
		System.out.printf("Notificando %s através do e-mail %s usando SMTP %s: %s\n", cliente.getNome(),
				cliente.getEmail(), this.smtpHost, mensage);
	}

	public void setCaixaAlta(boolean caixaAlta) {
		this.caixaAlta = caixaAlta;
	}

}
