package org.perfumeria.ecommerce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.perfumeria.ecommerce.model.admin;


@Service
public class adminService {
	
	private final adminRepository adminRepository;

	@Autowired
	public adminService(adminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}
	
	public List<admin> getAllAdmins(){
		return adminRepository.findAll();
	}//getAllAdminds
	
	public admin getAdmin(String nombre_de_usuario) {
		return adminRepository.findById(nombre_de_usuario).
				orElseThrow(()->
				new IllegalStateException("El Administrador con el nombre [ " + nombre_de_usuario + " ] no existe!!"));
	}//getAdmin
	
	public void addAdmin( admin admin) {
		Optional<admin> prodByAdminName = adminRepository.findById(admin.getNombre_de_usuario());
		if(prodByAdminName.isPresent()) {
			throw new IllegalStateException("El Administrador con el nombre [" + admin.getNombre_de_usuario() + "] ya existe");
		}
		adminRepository.save(admin);
	}//addAdmin
	
	public void deleteAdmin( String nombre_de_usuario) {
		if(adminRepository.existsById(nombre_de_usuario)) {
			adminRepository.deleteById(nombre_de_usuario);
		}else {
			throw new IllegalStateException("El Administrador con el nombre [" + nombre_de_usuario + "] no existe");
		}//else
	}//deleteAdmin
	
	@Transactional
	public void updateAdmin(String nombre_de_usuario, 
			String contraseña, 
			String nombre, 
			String apellidop, 
			String apellidom,
			String correo) {
		admin admin = adminRepository.findById(nombre_de_usuario).
				orElseThrow(
						()-> new IllegalStateException("El Administrador con el nombre [" + nombre_de_usuario + "] no existe."));
		if(contraseña != null)
			if((!contraseña.isEmpty()) && (!contraseña.equals(admin.getContraseña()))) {
				admin.setContraseña(contraseña);
		}//ifContraseña
		
		if(nombre != null)
			if((!nombre.isEmpty()) && (!nombre.equals(admin.getNombre()))) {
				admin.setNombre(nombre);
		}//ifNombre
		
		if(apellidop != null)
			if((!apellidop.isEmpty()) && (!apellidop.equals(admin.getApellidop()))) {
				admin.setApellidop(apellidop);
		}//apellidop
		
		if(apellidom != null)
			if((!apellidom.isEmpty()) && (!apellidom.equals(admin.getApellidom()))) {
				admin.setApellidom(apellidom);
		}//apellidom
		

		if(correo != null)
			if((!correo.isEmpty()) && (!correo.equals(admin.getCorreo()))) {
				admin.setCorreo(correo);
		}//correo
		
	}//updateOrder

}//class AdminService
