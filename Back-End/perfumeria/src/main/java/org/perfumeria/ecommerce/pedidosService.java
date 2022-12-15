package org.perfumeria.ecommerce;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.perfumeria.ecommerce.model.pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class pedidosService {

	private final pedidosRepository pedidosRepository;

	@Autowired
	public pedidosService(pedidosRepository pedidosRepository) {
		this.pedidosRepository = pedidosRepository;
	}//pedidosService
	
	public List<pedidos> getAllorders(){
		return pedidosRepository.findAll();
	}//getAllorders
	
	public pedidos getOrder( Long id_pedido) {
		return pedidosRepository.findById(id_pedido).
				orElseThrow(
						()->new IllegalStateException("El Pedido con el id [" + id_pedido + "] no existe."));
	}//getOrder
	
	public void addOrder( pedidos pedido) {
		Optional<pedidos> prodById = pedidosRepository.findById(pedido.getId_pedido());
		if(prodById.isPresent()) {
			throw new IllegalStateException("El pedido con el id [" + pedido.getId_pedido() + "] ya existe");
		}
		pedidosRepository.save(pedido);
	}//addOrder
	
	public void deleteOrder( Long id_pedido) {
		if(pedidosRepository.existsById(id_pedido)) {
			pedidosRepository.deleteById(id_pedido);
		}else {
			throw new IllegalStateException("El pedido con el id [" + id_pedido + "] no existe");
		}//else
	}//deleteOrder
	
	@Transactional
	public void updateOrder(Long id_pedido, Long id_correoc, Date fecha_y_hora) {
		pedidos pedido = pedidosRepository.findById(id_pedido).
				orElseThrow(
						()-> new IllegalStateException("El Pedido con el id [" + id_pedido + "] no existe."));
		
		
		if(fecha_y_hora != null)
			if((!fecha_y_hora.equals(pedido.getFecha_y_hora()))) {
				pedido.setFecha_y_hora(fecha_y_hora);
			}
		
	}//updateOrder
	
	
}//pedidosService
