package org.perfumeria.ecommerce;

import java.util.Optional;

import org.perfumeria.ecommerce.model.clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface clientesRepository extends JpaRepository<clientes, Long>{
	
	@Query("SELECT u FROM clientes u WHERE u.correo=?1")
	Optional<clientes> findByEmail(String correo);
	
}//interface usuariosRepository


