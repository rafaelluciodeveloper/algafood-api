package com.algaworks.algafood.api.disassembler;

import com.algaworks.algafood.api.dto.RestauranteDTO;
import com.algaworks.algafood.api.dto.input.RestauranteInputDTO;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestauranteInputDTODisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Restaurante toDomain(RestauranteInputDTO restauranteInputDTO) {
        return modelMapper.map(restauranteInputDTO, Restaurante.class);
    }

    public void copyToDomain(RestauranteInputDTO restauranteInputDTO, Restaurante restaurante) {
        restaurante.setCozinha(new Cozinha());

        if(restaurante.getEndereco() != null){
            restaurante.getEndereco().setCidade(new Cidade());
        }
        modelMapper.map(restauranteInputDTO, restaurante);
    }

}
