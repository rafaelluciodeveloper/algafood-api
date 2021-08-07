package com.algaworks.algafood.di.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.service.ClienteAtivadorEvent;

@Component
public class EmissaoNotaFiscalService {

	@EventListener
	public void clienteAtivadorListener(ClienteAtivadorEvent event) {

		System.out.println("Emitindo Nota Fiscal para cliente " + event.getCliente().getNome());

	}
}
