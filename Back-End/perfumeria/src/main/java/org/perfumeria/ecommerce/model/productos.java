package org.perfumeria.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "productos")
public class productos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_perfume", unique = true, nullable = false)
	private Long id_perfume;
	private String nombre;
	private Long costo;
	private Long cantidad;
	private String img;
	
	public productos(Long id_perfume, String nombre, Long costo, Long cantidad, String img) {
		this.id_perfume = id_perfume;
		this.nombre = nombre;
		this.costo = costo;
		this.cantidad = cantidad;
		this.img = img;
	}//productos
	
	public productos() {}

	public Long getId_perfume() {
		return id_perfume;
	}

	public void setId_perfume(Long id_perfume) {
		this.id_perfume = id_perfume;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getCosto() {
		return costo;
	}

	public void setCosto(Long costo) {
		this.costo = costo;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	

}//class productos
