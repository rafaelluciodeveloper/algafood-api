package com.algaworks.algafood.api.disassembler;

import com.algaworks.algafood.api.dto.input.CidadeInputDTO;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Estado;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CidadeInputDTODisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Cidade toDomain(CidadeInputDTO cidadeInputDTO) {
        return modelMapper.map(cidadeInputDTO, Cidade.class);
    }

    public void copyToDomain(CidadeInputDTO cidadeInputDTO, Cidade cidade) {
        // Para evitar org.hibernate.HibernateException: identifier of an instance of
        // com.algaworks.algafood.domain.model.Estado was altered from 1 to 2
        cidade.setEstado(new Estado());

        modelMapper.map(cidadeInputDTO, cidade);
    }

}
