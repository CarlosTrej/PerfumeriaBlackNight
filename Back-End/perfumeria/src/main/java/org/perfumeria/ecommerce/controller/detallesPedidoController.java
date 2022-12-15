package org.perfumeria.ecommerce.controller;

import java.util.List;

import org.perfumeria.ecommerce.detallesPedidoService;
import org.perfumeria.ecommerce.model.detallesPedido;
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
@RequestMapping("/api/v1/detallesPedido")
@CrossOrigin("*")
public class detallesPedidoController {
	
	private final detallesPedidoService detallesPedidoService;

	@Autowired
	public detallesPedidoController(detallesPedidoService detallesPedidoService) {
		this.detallesPedidoService = detallesPedidoService;
	}//DetallesPedidoController
	
	@GetMapping
	public List<detallesPedido> getAllDetails(){
		return detallesPedidoService.getAllDetails();
	}//getAllusers
	
	
	@GetMapping(path = "{id_detalles}")
	public detallesPedido getDetail(@PathVariable("id_detalles") Long id_detalles) {
		return detallesPedidoService.getDetail(id_detalles);
	}//getUser
	
	
	@DeleteMapping(path = "{id_detalles}")
	public void deleteDetailr(@PathVariable("id_detalles") Long id_detalles) {
		detallesPedidoService.deleteDetail(id_detalles);
	}//deleteUser
	
	
	@PostMapping 
	public void addDetail(@RequestBody detallesPedido detallePedido) {
		detallesPedidoService.addDetail(detallePedido);
	}//addUser
	
	
	@PutMapping(path = "{id_detalles}")
	public void updateDetail(@PathVariable("id_detalles") Long id_detalles,
			@RequestParam(required = true) Long id_pedidos,
			@RequestParam(required = true) Long id_perfumes,
			@RequestParam(required = true) String nombre_producto,
			@RequestParam(required = true) Long costo,
			@RequestParam(required = true) Long cantidad_productos){
		detallesPedidoService.updateDetail(id_detalles, id_pedidos, id_perfumes, nombre_producto, costo, cantidad_productos);		
	}//updateDetail
	

	
	
	
	

}//DetallesPedidoController
