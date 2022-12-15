package org.perfumeria.ecommerce.model;

public class LoginData {
	
	private final String correo;
	private final String contraseña;
	
	
	public LoginData(String correo, String contraseña) {
		this.correo = correo;
		this.contraseña = contraseña;
	}//LoginData


	public LoginData() {
		this.correo="";
		this.contraseña = "";
	}//LoginDataEmpty


	public String getcorreo() {
		return correo;
	}//getcorreo


	public String getcontraseña() {
		return contraseña;
	}//getcontraseña
	

}//LoginData
