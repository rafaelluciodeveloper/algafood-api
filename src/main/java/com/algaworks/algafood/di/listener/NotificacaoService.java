package com.algaworks.algafood.di.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.notiticacao.NivelUrgencia;
import com.algaworks.algafood.di.notiticacao.Notificador;
import com.algaworks.algafood.di.notiticacao.TipoNotificador;
import com.algaworks.algafood.di.service.ClienteAtivadorEvent;

@Component
public class NotificacaoService {

	@TipoNotificador(NivelUrgencia.SEM_URGENCIA)
	@Autowired
	private Notificador notificador;

	@EventListener
	public void clienteAtivadorListener(ClienteAtivadorEvent event) {
		notificador.notificar(event.getCliente(), "Seu cadastro no sistema esta ativo!");
	}

}
