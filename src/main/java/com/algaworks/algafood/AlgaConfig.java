package com.algaworks.algafood;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.algaworks.algafood.di.notiticacao.NotificadorEmail;

@Configuration
public class AlgaConfig {

	@Bean
	public NotificadorEmail notificadorEmail() {
		NotificadorEmail notificador = new NotificadorEmail("smtp.host.com.br");

		notificador.setCaixaAlta(true);

		return notificador;
	}

}
