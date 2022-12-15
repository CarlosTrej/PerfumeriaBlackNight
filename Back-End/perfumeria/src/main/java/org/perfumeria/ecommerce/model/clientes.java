package org.perfumeria.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.perfumeria.utils.SHAUtil;

/**
 * @author CarlosTrejo
 *
 */
@Entity
@Table(name = "clientes")
public class clientes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente", unique = true, nullable = false)
	private Long id_cliente;
	private String correo;
	private String nombre;
	private String apellidop;
	private String apellidom;
	private Long edad;
	private String contraseña;
	
	public clientes(Long id_cliente, String correo, String nombre, String apellidop, String apellidom, Long edad,
			String contraseña) {
		this.id_cliente = id_cliente;
		this.correo = correo;
		this.nombre = nombre;
		this.apellidop = apellidop;
		this.apellidom = apellidom;
		this.edad = edad;
		this.setContraseña(contraseña);
	}
	public clientes() {}
	
	public Long getId_cliente() {
		return id_cliente;
	}
	
	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
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
	
	public Long getEdad() {
		return edad;
	}
	
	public void setEdad(Long edad) {
		this.edad = edad;
	}
	
	public String getContraseña() {
		return contraseña;
	}
	
	public void setContraseña(String contraseña) {
		this.contraseña = SHAUtil.createHash(contraseña);	
	}
	
	 public void setClearPassword(String contraseña) {
		  this.contraseña=contraseña;
	  }//setClearPassword
	
	/*this.setPassword(password);
	
	public void setPassword(String password) {
		this.password = SHAUtil.createHash(password);
	}
	public void setClearPassword(String password) {
		  this.password=password;
	}*/

}//usuarios
