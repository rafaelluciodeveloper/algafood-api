package com.algaworks.algafood.di.notiticacao;

import com.algaworks.algafood.di.model.Cliente;

public interface Notificador {

	void notificar(Cliente cliente, String mensage);

}