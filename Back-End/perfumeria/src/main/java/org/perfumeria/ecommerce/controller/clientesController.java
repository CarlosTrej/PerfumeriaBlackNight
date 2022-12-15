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
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/clientes")
@CrossOrigin("*")
@Api(value = "Administracion del sistema de clientes.", description = "Operaciones relativas al cliente en el Sistema de Gestión de clientes")
public class clientesController {

	private final clientesService clientesService;

	@Autowired
	public clientesController(clientesService clientesService) {
		this.clientesService = clientesService;
	}//usuariosController
	
	@ApiOperation(value = "Ver la lista de clientes disponibles", response = List.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Lista recuperada con éxito"),
        @ApiResponse(code = 401, message = "No está autorizado a ver el recurso"),
        @ApiResponse(code = 403, message = "El acceso al recurso al que intentaba acceder está prohibido."),
        @ApiResponse(code = 404, message = "El recurso al que intentaba acceder no se encuentra")
    })
	@GetMapping
	public List<clientes> getAllusers(){
		return clientesService.getAllusers();
	}//getAllusers
	
	
	@ApiOperation(value = "Obtenemos al cliente por su Id")
	@GetMapping(path = "{id_cliente}")
	public clientes getUser(@PathVariable("id_cliente") Long id_cliente) {
		return clientesService.getUser(id_cliente);
	}//getUser
	
	
	@ApiOperation(value = "Eliminamos al cliente")
	@DeleteMapping(path = "{id_cliente}")
	public void deleteUser(@PathVariable("id_cliente") Long id_cliente) {
		clientesService.deleteUser(id_cliente);
	}//deleteUser
	
	
	@ApiOperation(value = "Agregamos un nuevo cliente")
	@PostMapping 
	public void addUser(@RequestBody clientes usuario) {
		clientesService.addUser(usuario);
	}//addUser
	
	
	@ApiOperation(value = "Actualizamos la contraseña del cliente")
	@PutMapping(path = "{id_cliente}")
	public void updateUser(@PathVariable("id_cliente") Long id_cliente,
			@RequestParam(required = true) String contraseña,
			@RequestParam(required = true) String nuevaContraseña) {
		clientesService.updateUser(id_cliente,contraseña, nuevaContraseña);
		
	}//updateUser
	
	
}//usuariosController
