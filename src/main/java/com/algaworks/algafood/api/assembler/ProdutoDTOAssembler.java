package com.algaworks.algafood.api.assembler;

import com.algaworks.algafood.api.dto.ProdutoDTO;
import com.algaworks.algafood.domain.model.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProdutoDTOAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public ProdutoDTO toDTO(Produto produto) {
        return modelMapper.map(produto, ProdutoDTO.class);
    }

    public List<ProdutoDTO> toCollectionDTO(List<Produto> produtos) {
        return produtos.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

}
