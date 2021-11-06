package com.algaworks.algafood.api.disassembler;

import com.algaworks.algafood.api.dto.input.CozinhaInputDTO;
import com.algaworks.algafood.domain.model.Cozinha;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CozinhaInputDTODisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Cozinha toDomain(CozinhaInputDTO cozinhaInputDTO) {
        return modelMapper.map(cozinhaInputDTO, Cozinha.class);
    }

    public void copyToDomain(CozinhaInputDTO cozinhaInputDTO, Cozinha cozinha) {
        modelMapper.map(cozinhaInputDTO, cozinha);
    }

}
