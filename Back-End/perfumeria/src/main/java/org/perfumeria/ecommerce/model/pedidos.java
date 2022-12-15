package org.perfumeria.ecommerce.model;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class pedidos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido", unique = true, nullable = false)
	private Long id_pedido;
	private Long id_correoc;
	private Date fecha_y_hora;
	
	public pedidos(Long id_pedido, Long id_correoc, Date fecha_y_hora) {
		this.id_pedido = id_pedido;
		this.id_correoc = id_correoc;
		this.fecha_y_hora = fecha_y_hora;
	}
	public pedidos() {}
	public Long getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(Long id_pedido) {
		this.id_pedido = id_pedido;
	}
	public Long getId_correoc() {
		return id_correoc;
	}
	public void setId_correoc(Long id_correoc) {
		this.id_correoc = id_correoc;
	}
	public Date getFecha_y_hora() {
		return fecha_y_hora;
	}
	public void setFecha_y_hora(Date fecha_y_hora) {
		this.fecha_y_hora = fecha_y_hora;
	}

}//pedidos
