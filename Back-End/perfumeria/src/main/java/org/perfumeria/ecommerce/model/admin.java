package org.perfumeria.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nombre_de_usuario", unique = true, nullable = false)
	private String nombre_de_usuario;
	private String contrase�a;
	private String nombre;
	private String apellidop;
	private String apellidom;
	private String correo;
	
	public admin(String nombre_de_usuario, String contrase�a, String nombre, String apellidop, String apellidom,
			String correo) {
		this.nombre_de_usuario = nombre_de_usuario;
		this.contrase�a = contrase�a;
		this.nombre = nombre;
		this.apellidop = apellidop;
		this.apellidom = apellidom;
		this.correo = correo;
	}
	public admin() {}
	public String getNombre_de_usuario() {
		return nombre_de_usuario;
	}
	public void setNombre_de_usuario(String nombre_de_usuario) {
		this.nombre_de_usuario = nombre_de_usuario;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidop() {
		return apellidop;
	}
	public void setApellidop(String apellidop) {
		this.apellidop = apellidop;
	}
	public String getApellidom() {
		return apellidom;
	}
	public void setApellidom(String apellidom) {
		this.apellidom = apellidom;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	

}//Admin
