package com.algaworks.algafood.api.disassembler;

import com.algaworks.algafood.api.dto.input.PedidoInputDTO;
import com.algaworks.algafood.domain.model.Pedido;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoInputDTODisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Pedido toDomain(PedidoInputDTO pedidoInput) {
        return modelMapper.map(pedidoInput, Pedido.class);
    }

    public void copyToDomain(PedidoInputDTO pedidoInput, Pedido pedido) {
        modelMapper.map(pedidoInput, pedido);
    }

}
