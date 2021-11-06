package com.algaworks.algafood.core.jackson;

import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.model.mixin.CidadeMixin;
import com.algaworks.algafood.domain.model.mixin.CozinhaMixin;
import com.algaworks.algafood.domain.model.mixin.RestauranteMixin;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.stereotype.Component;

@Component
public class JacksonMixinModule extends SimpleModule {

    private  static final long serialVersionUID =  1L;

    public JacksonMixinModule(){
        setMixInAnnotation(Restaurante.class , RestauranteMixin.class);
        setMixInAnnotation(Cidade.class , CidadeMixin.class);
        setMixInAnnotation(Cozinha.class , CozinhaMixin.class);
    }

}
