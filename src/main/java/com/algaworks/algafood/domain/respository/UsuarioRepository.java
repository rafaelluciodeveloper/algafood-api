package com.algaworks.algafood.domain.respository;

import com.algaworks.algafood.domain.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends  CustomJpaRepository<Usuario , Long>{

    Optional<Usuario> findByEmail(String email);

}
