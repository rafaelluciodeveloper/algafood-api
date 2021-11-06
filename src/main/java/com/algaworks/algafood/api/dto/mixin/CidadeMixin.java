package com.algaworks.algafood.api.dto.mixin;

import com.algaworks.algafood.domain.model.Estado;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class CidadeMixin {

    @JsonIgnoreProperties(value = "nome" , allowGetters = true)
    private Estado estado;

}
