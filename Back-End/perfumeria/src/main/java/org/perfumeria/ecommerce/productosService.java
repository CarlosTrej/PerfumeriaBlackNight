package org.perfumeria.ecommerce;


import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import org.perfumeria.ecommerce.model.productos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class productosService {
	
	//Object constant productosRepository
	private final productosRepository productosRepository;
	
	@Autowired
	public productosService(productosRepository productosRepository) {
		this.productosRepository = productosRepository;
	}//constructor
	
	
	public List<productos> getAllProductos(){
		return productosRepository.findAll();
	}//getAllProductos
	
	
	
	
	public productos getProductos(Long id){
		return productosRepository.findById(id)
				.orElseThrow(()-> 
					new IllegalStateException
						("El producto con el id [" + id + "] no existe."));
	}//getProductos
	
	public void deleteProductos(Long id) {
		if(productosRepository.existsById(id)) {
			productosRepository.deleteById(id);
		}else {
			throw new IllegalStateException("El producto con el id [" + id + "] no existe. ");
		}//else
	}//deleteProductos
	
	public void addProductos (productos producto) {
		Optional<productos> prodByName=productosRepository.findByName(producto.getNombre());
		if( prodByName.isPresent()) {
			throw new IllegalStateException("El Producto con el nombre [" + producto.getNombre() + "] ya existe.");
		}//isPresent
		productosRepository.save(producto);
	}//addProducts
	
	
	@Transactional
	public void updateProductos(Long id_perfume,
			String nombre, 
			Long costo, 
			Long cantidad,
			String img) 
	{
		
		productos producto = productosRepository.findById(id_perfume).
				orElseThrow(
						()-> new IllegalStateException("El producto con el id [" + id_perfume + "] no existe."));
		
		//validamos_nombre
		if(nombre != null)
			if((!nombre.isEmpty()) && (!nombre.equals(producto.getNombre()))) {
				producto.setNombre(nombre);
			}//ifNombre
		
		//validamos_costo
		if((costo >0) && (costo!= producto.getCosto())) {
			producto.setCosto(costo);
		}//ifCosto
		
		//validamos_cantidad
		if((cantidad >0) && (cantidad!= producto.getCantidad())) {
			producto.setCantidad(cantidad);
		}//ifCantidad
		
		//validamos_img
		if(img != null)
			if((!img.isEmpty()) && (!img.equals(producto.getImg()))) {
				producto.setImg(img);
		}//ifImg
		
	}//updateProductos

}//roductossService
