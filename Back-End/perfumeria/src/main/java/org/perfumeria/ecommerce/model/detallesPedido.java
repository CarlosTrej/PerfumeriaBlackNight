package org.perfumeria.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "detalles_pedido")
public class detallesPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_detalles", unique = true, nullable = false)
	private Long id_detalles;
	private Long id_pedidos;
	private Long id_perfumes;
	private String nombre_producto;
	private Long costo;
	private Long cantidad_productos;
	
	
	public detallesPedido(Long id_detalles, Long id_pedidos, Long id_perfumes, String nombre_producto, Long costo,
			Long cantidad_productos) {
		this.id_detalles = id_detalles;
		this.id_pedidos = id_pedidos;
		this.id_perfumes = id_perfumes;
		this.nombre_producto = nombre_producto;
		this.costo = costo;
		this.cantidad_productos = cantidad_productos;
	}//DetallesPedido


	public detallesPedido() {}


	public Long getId_detalles() {
		return id_detalles;
	}


	public void setId_detalles(Long id_detalles) {
		this.id_detalles = id_detalles;
	}


	public Long getId_pedidos() {
		return id_pedidos;
	}


	public void setId_pedidos(Long id_pedidos) {
		this.id_pedidos = id_pedidos;
	}


	public Long getId_perfumes() {
		return id_perfumes;
	}


	public void setId_perfumes(Long id_perfumes) {
		this.id_perfumes = id_perfumes;
	}


	public String getNombre_producto() {
		return nombre_producto;
	}


	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}


	public Long getCosto() {
		return costo;
	}


	public void setCosto(Long costo) {
		this.costo = costo;
	}


	public Long getCantidad_productos() {
		return cantidad_productos;
	}


	public void setCantidad_productos(Long cantidad_productos) {
		this.cantidad_productos = cantidad_productos;
	}
	
}//class DetallesPedido
