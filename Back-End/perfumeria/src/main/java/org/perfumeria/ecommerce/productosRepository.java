package org.perfumeria.ecommerce;

import java.util.Optional;

import org.perfumeria.ecommerce.model.productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface productosRepository extends JpaRepository<productos, Long> {
	@Query("SELECT p FROM productos p WHERE p.nombre=?1")
	Optional<productos> findByName(String nombre);
}//interface productosRepository
