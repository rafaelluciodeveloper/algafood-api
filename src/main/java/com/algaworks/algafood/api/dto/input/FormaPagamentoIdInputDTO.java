package com.algaworks.algafood.api.dto.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class FormaPagamentoIdInputDTO {

    @NotNull
    private Long id;

}
