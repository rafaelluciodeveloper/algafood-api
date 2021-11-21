package com.algaworks.algafood.api.dto.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class UsuarioComSenhaInputDTO extends UsuarioInputDTO{

    @NotBlank
    private String senha;

}
