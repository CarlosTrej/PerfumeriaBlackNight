package org.perfumeria.ecommerce;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.perfumeria.ecommerce.model.detallesPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class detallesPedidoService {
	
	private final detallesPedidoRepository detallesPedidoRepository;

	@Autowired
	public detallesPedidoService(detallesPedidoRepository detallesPedidoRepository) {
		this.detallesPedidoRepository = detallesPedidoRepository;
	}//DetallesPedidoService
	
	public List<detallesPedido> getAllDetails(){
		return detallesPedidoRepository.findAll();
	}//getAllAdminds
	
	public detallesPedido getDetail(Long id_detalles) {
		return detallesPedidoRepository.findById(id_detalles).
				orElseThrow(()->
				new IllegalStateException("El Pedido con el id [ " + id_detalles + " ] no existe!!"));
	}//getAdmin
	
	public void addDetail( detallesPedido detallesPedido) {
		Optional<detallesPedido> prodByDetail = detallesPedidoRepository.findById(detallesPedido.getId_pedidos());
		if(prodByDetail.isPresent()) {
			throw new IllegalStateException("El id del  pedido [" + detallesPedido.getId_pedidos() + "] ya existe");
		}
		detallesPedidoRepository.save(detallesPedido);
	}//addAdmin
	
	public void deleteDetail( Long id_detalles) {
		if(detallesPedidoRepository.existsById(id_detalles)) {
			detallesPedidoRepository.deleteById(id_detalles);
		}else {
			throw new IllegalStateException("El id del  pedido [" + id_detalles + "] no existe");
		}//else
	}//deleteAdmin
	
	@Transactional
	public void updateDetail(Long id_detalles, 
			Long id_pedidos, 
			Long id_perfumes, 
			String nombre_producto, 
			Long costo,
			Long cantidad_productos) {
		
		detallesPedido detallesPedido = detallesPedidoRepository.findById(id_detalles).
				orElseThrow(
						()-> new IllegalStateException("El id del  pedido [" + id_detalles + "] no existe."));
		
		if(nombre_producto != null)
			if((!nombre_producto.isEmpty()) && (!nombre_producto.equals(detallesPedido.getNombre_producto()))) {
				detallesPedido.setNombre_producto(nombre_producto);;
		}//nombre_producto
		
		if((id_pedidos >0) && (id_pedidos!= detallesPedido.getId_pedidos())) {
			detallesPedido.setId_pedidos(costo);
		}//idPedidos
		
		if((id_perfumes >0) && (id_perfumes!= detallesPedido.getId_perfumes())) {
			detallesPedido.setId_perfumes(costo);
		}//idPerfumes
		
		if((costo >0) && (costo!= detallesPedido.getCosto())) {
			detallesPedido.setCosto(costo);
		}//ifCosto
		
		if((cantidad_productos >0) && (cantidad_productos!= detallesPedido.getCantidad_productos())) {
			detallesPedido.setCantidad_productos(cantidad_productos);
		}//cantidad_producto
		
	}//updateDetail

	
	

}//DetallesPedidoService
