package org.perfumeria.ecommerce;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perfumeria.ecommerce.model.clientes;
import org.perfumeria.utils.SHAUtil;

@Service
public class clientesService {

	
	private final clientesRepository clientesRepository;

	
	@Autowired
	public clientesService(clientesRepository clientesRepository) {
		this.clientesRepository = clientesRepository;
	}//constructorUsuarios
	
	
	public List<clientes> getAllusers() {
		return clientesRepository.findAll();
	}//getAllusers
	
	
	public clientes  getUser(Long id_cliente) {
		return clientesRepository.findById(id_cliente)
				.orElseThrow(()-> new IllegalStateException
						("El Usuario con el id [" + id_cliente + "] no existe."));
	}//getUser
	
	
	public void deleteUser(Long id_cliente) {
		if(clientesRepository.existsById(id_cliente)) {
			clientesRepository.deleteById(id_cliente);
		}else {
			throw new IllegalStateException("El Usuario con el id [" + id_cliente + "] no existe. ");
		}//else
	}//deleteUser
	
	
	public void addUser (clientes usuario) {
		Optional<clientes> prodByEmail=clientesRepository.findByEmail(usuario.getCorreo());
		if( prodByEmail.isPresent()) {
			throw new IllegalStateException("El Usuario con el correo [" + usuario.getCorreo() + "] ya existe.");
		}//isPresent
		clientesRepository.save(usuario);
	}//addUser
	
	
	@Transactional
	public void updateUser(Long id_cliente, 
			String contraseña,
			String nuevaContraseña) 
	{
		
		clientes cliente = clientesRepository.findById(id_cliente).
				orElseThrow(
						()->new IllegalStateException("El Usuario con el id [" + id_cliente + "] no existe."));
		
		
		if(contraseña == null || nuevaContraseña ==null) {
			throw new IllegalStateException("El usuario con el id ["+id_cliente+"] no existe");
		}//ifPassword!=null
		
		if(! SHAUtil.verifyHash(contraseña, cliente.getContraseña())) {
			throw new IllegalStateException("La contraseña del usuario con el id ["+id_cliente+"] no coincide");
		}//ifVerifyHash
		//ValidamosElpasswordActualConElNuevo
		cliente.setContraseña(nuevaContraseña);
	}//updateUser
	
	}//updateUser
	
	

