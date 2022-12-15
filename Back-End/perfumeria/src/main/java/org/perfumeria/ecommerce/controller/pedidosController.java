package org.perfumeria.ecommerce.controller;

import java.sql.Date;
import java.util.List;

import org.perfumeria.ecommerce.pedidosService;
import org.perfumeria.ecommerce.model.pedidos;
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
@RequestMapping("api/v1/pedido")
@CrossOrigin("*")
public class pedidosController {
	
	private final pedidosService pedidosService;

	@Autowired
	public pedidosController(pedidosService pedidosService) {
		this.pedidosService = pedidosService;
	}//pedidosController
	
	
	@GetMapping
	public List<pedidos> getAllorders(){
		return pedidosService.getAllorders();
	}//getAllorders
	
	@GetMapping(path = "{id_pedido}")
	public pedidos getOrder(@PathVariable("id_pedido") Long id_pedido) {
		return pedidosService.getOrder(id_pedido);
	}//getOrder
	
	
	@DeleteMapping(path = "{id_pedido}")
	public void deleteOrder(@PathVariable("id_pedido") Long id_pedido) {
		pedidosService.deleteOrder(id_pedido);
	}//deleteOrder
	
	
	@PostMapping
	public void addOrder (@RequestBody pedidos pedido) {
		pedidosService.addOrder(pedido);
	}//addOrder
	
	
	@PutMapping(path = "{id_pedido}")
	public void updateOrder(@PathVariable("id_pedido") Long id_pedido,
			@RequestParam(required = false) Long id_correoc,
			@RequestParam(required = false) Date fecha_y_hora) {
		
		pedidosService.updateOrder(id_pedido, id_correoc, fecha_y_hora);
	}//updateOrder
	
}//pedidosController
