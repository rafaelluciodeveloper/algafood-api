package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FluxoPedidoService {

    @Autowired
    EmissaoPedidoService emissaoPedidoService;

    @Transactional
    public void confirmar(String codigo){

        Pedido pedido = emissaoPedidoService.buscarOuFalhar(codigo);
        pedido.confirmar();

    }

    @Transactional
    public void cancelar(String codigo) {

        Pedido pedido = emissaoPedidoService.buscarOuFalhar(codigo);
        pedido.cancelar();

    }

    @Transactional
    public void entregar(String codigo) {

        Pedido pedido = emissaoPedidoService.buscarOuFalhar(codigo);
        pedido.entregar();

    }
}
