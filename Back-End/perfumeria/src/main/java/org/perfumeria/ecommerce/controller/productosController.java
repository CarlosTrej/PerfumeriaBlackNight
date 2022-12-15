package org.perfumeria.ecommerce.controller;

import java.util.List;

import org.perfumeria.ecommerce.productosService;
import org.perfumeria.ecommerce.model.productos;
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
@RequestMapping("api/v1/productos")
@CrossOrigin("*")
public class productosController {
	
	private final productosService productosService;
	
	@Autowired
	public productosController(productosService productosService) {
		this.productosService = productosService;
	}//Constructor
	
	
	@GetMapping
	public List<productos> getAllProductos(){
		return productosService.getAllProductos();
	}//getAllproducts
	
	@GetMapping(path = "{id_perfume}")
	public productos getProductos(@PathVariable("id_perfume") Long id_perfume) {
		return productosService.getProductos(id_perfume);
	}//getProducts
	
	@DeleteMapping(path = "{id_perfume}")
	public void deleteProductos(@PathVariable("id_perfume") Long id_perfume) {
		productosService.deleteProductos(id_perfume);
	}//deleteProducts
	
	
	@PostMapping
	public void addProductos(@RequestBody productos producto) {
		productosService.addProductos(producto);
	}//addProducts
	
	
	@PutMapping(path = "{id_perfume}")
	public void updateProductos(@PathVariable("id_perfume") Long id_perfume,
			@RequestParam(required = false) String nombre,
			@RequestParam(required = false) Long costo,
			@RequestParam(required = false) Long cantidad,
			@RequestParam(required = false) String img)
			{
		productosService.updateProductos(id_perfume,nombre,costo,cantidad,img);
	}//updateProducts
	

}//productosController
