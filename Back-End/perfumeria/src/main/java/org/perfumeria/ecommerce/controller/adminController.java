package org.perfumeria.ecommerce.controller;

import java.util.List;

import org.perfumeria.ecommerce.adminService;
import org.perfumeria.ecommerce.model.admin;
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
@RequestMapping("/api/v1/admin")
@CrossOrigin("*")
public class adminController {
	
	private final adminService adminService;

	@Autowired
	public adminController(adminService adminService) {
		this.adminService = adminService;
	} //AdminController
	
	@GetMapping
	public List<admin>getAllAdmins(){
		return adminService.getAllAdmins();
	}//getAllAdmins
	
	@GetMapping(path = "{nombre_de_usuario}")
	public admin getAdmin(@PathVariable("nombre_de_usuario") String nombre_de_usuario) {
		return adminService.getAdmin(nombre_de_usuario);
	}//getAdmin
	
	
	@DeleteMapping(path = "{nombre_de_usuario}")
	public void deleteAdmin(@PathVariable("nombre_de_usuario") String nombre_de_usuario) {
		adminService.deleteAdmin(nombre_de_usuario);
	}//deleteAdmin
	
	
	@PostMapping 
	public void addAdmin(@RequestBody admin admin) {
		adminService.addAdmin(admin);
	}//addAdmin
	
	
	@PutMapping(path = "{nombre_de_usuario}")
	public void updateAdmin(@PathVariable("nombre_de_usuario") String nombre_de_usuario,
			@RequestParam(required = true) String contraseña,
			@RequestParam(required = true) String nombre,
			@RequestParam(required = true) String apellidop,
			@RequestParam(required = true) String apellidom,
			@RequestParam(required = true) String correo) {
		adminService.updateAdmin(nombre_de_usuario, contraseña, nombre, apellidop, apellidom, correo);
		
	}//updateAdmin
	
	
	

}//class AdminController
