package org.perfumeria.ecommerce.controller;

import java.util.List;

import org.perfumeria.ecommerce.clientesService;
import org.perfumeria.ecommerce.model.clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/clientes")
@CrossOrigin("*")
public class clientesController {

	private final clientesService clientesService;

	@Autowired
	public clientesController(clientesService clientesService) {
		this.clientesService = clientesService;
	}//usuariosController
	
	
	@GetMapping
	public List<clientes> getAllusers(){
		return clientesService.getAllusers();
	}//getAllusers
	
	
	@GetMapping(path = "{id_cliente}")
	public clientes getUser(@PathVariable("id_cliente") Long id_cliente) {
		return clientesService.getUser(id_cliente);
	}//getUser
	
	
	@DeleteMapping(path = "{id_cliente}")
	public void deleteUser(@PathVariable("id_cliente") Long id_cliente) {
		clientesService.deleteUser(id_cliente);
	}//deleteUser
	
	
	@PostMapping 
	public void addUser(@RequestBody clientes usuario) {
		clientesService.addUser(usuario);
	}//addUser
	
	
	@PutMapping(path = "{id_cliente}")
	public void updateUser(@PathVariable("id_cliente") Long id_cliente,
			@RequestParam(required = true) String contraseña,
			@RequestParam(required = true) String nuevaContraseña) {
		clientesService.updateUser(id_cliente,contraseña, nuevaContraseña);
		
	}//updateUser
	
	
}//usuariosController
