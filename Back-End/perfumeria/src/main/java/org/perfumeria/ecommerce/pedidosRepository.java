package org.perfumeria.ecommerce;

import java.util.Optional;

import org.perfumeria.ecommerce.model.pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface pedidosRepository extends JpaRepository<pedidos, Long>{
	@Query("SELECT p FROM pedidos p WHERE p.id_pedido=?1")
	Optional<pedidos> findById(String id_pedido);

}//pedidosRepository
