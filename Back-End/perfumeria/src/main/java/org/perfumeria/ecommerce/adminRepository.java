package org.perfumeria.ecommerce;

import java.util.Optional;

import org.perfumeria.ecommerce.model.admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface adminRepository extends JpaRepository<admin, String> {
	@Query("SELECT p FROM admin p WHERE p.nombre_de_usuario=?1")
	Optional<admin> findByName(String nombre_de_usuario);
}
