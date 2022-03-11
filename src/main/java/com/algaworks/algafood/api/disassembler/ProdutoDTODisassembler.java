package com.algaworks.algafood.api.disassembler;

import com.algaworks.algafood.api.dto.input.ProdutoInputDTO;
import com.algaworks.algafood.domain.model.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoDTODisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Produto toDomain(ProdutoInputDTO produtoInputDTO) {
        return modelMapper.map(produtoInputDTO, Produto.class);
    }

    public void copyToDomain(ProdutoInputDTO produtoInputDTO, Produto produto) {
        modelMapper.map(produtoInputDTO, produto);
    }

}
