package com.algaworks.algafood.domain.respository;

import com.algaworks.algafood.domain.model.Pedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends CustomJpaRepository<Pedido, Long>{

    @Query("from Pedido p where p.codigo = :codigo")
    Optional<Pedido> findByCodigo(String codigo);

    @Query("from Pedido p join fetch p.cliente join fetch p.restaurante r join fetch r.cozinha")
    List<Pedido> findAll();

}
