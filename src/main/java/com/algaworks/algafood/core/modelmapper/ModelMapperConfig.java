package com.algaworks.algafood.core.modelmapper;

import com.algaworks.algafood.api.dto.EnderecoDTO;
import com.algaworks.algafood.api.dto.input.ItemPedidoInputDTO;
import com.algaworks.algafood.domain.model.Endereco;
import com.algaworks.algafood.domain.model.ItemPedido;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {

        var modelMapper = new ModelMapper();

        var enderecoToEnderecoModelTypeMap = modelMapper.createTypeMap(
                Endereco.class, EnderecoDTO.class
        );

        enderecoToEnderecoModelTypeMap.<String>addMapping(
                src -> src.getCidade().getEstado().getNome(),
                (dest , value) -> dest.getCidade().setEstado(value));

        modelMapper.createTypeMap(ItemPedidoInputDTO.class, ItemPedido.class)
                .addMappings(mapper -> mapper.skip(ItemPedido::setId));

        return modelMapper;
    }

}
