package org.perfumeria.ecommerce.model;

public class LoginData {
	
	private final String correo;
	private final String contrase�a;
	
	
	public LoginData(String correo, String contrase�a) {
		this.correo = correo;
		this.contrase�a = contrase�a;
	}//LoginData


	public LoginData() {
		this.correo="";
		this.contrase�a = "";
	}//LoginDataEmpty


	public String getcorreo() {
		return correo;
	}//getcorreo


	public String getcontrase�a() {
		return contrase�a;
	}//getcontrase�a
	

}//LoginData
