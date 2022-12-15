package org.perfumeria.ecommerce;

import org.perfumeria.ecommerce.model.detallesPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface detallesPedidoRepository extends JpaRepository<detallesPedido,Long> {
	

}//DetallesPedidoRepository 
