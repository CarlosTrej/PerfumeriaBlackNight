package org.perfumeria.ecommerce.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import javax.servlet.ServletException;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.perfumeria.ecommerce.clientesRepository;
import org.perfumeria.ecommerce.model.LoginData;
import org.perfumeria.ecommerce.model.Token;
import org.perfumeria.ecommerce.model.clientes;
import org.perfumeria.utils.SHAUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/api/v1/login")
@CrossOrigin("*")
public class AuthController {
	
	private final clientesRepository ClientesRepository;

	
	
	
	public AuthController(clientesRepository clientesRepository) {
		ClientesRepository = clientesRepository;
	}

	@PostMapping
	public Token login(@RequestBody LoginData data) throws ServletException{
		Optional<clientes> userByEmail = ClientesRepository.findByEmail(data.getcorreo());
		if(userByEmail.isPresent()) {
			if(SHAUtil.verifyHash(data.getcontraseña(), userByEmail.get().getContraseña())) {
				return new Token(generateToken(data.getcorreo()));
			}//ifShautil
		}//userByEmail
	System.out.println("-------->"+userByEmail.isPresent());
		throw new ServletException("Login Invalido. por favor verifíca tus credenciales.");
	}//login
	
	private String generateToken(String correo) {
		Calendar calendar = Calendar.getInstance();
        calendar.add( Calendar.HOUR,  100);
        String secret = "this-secret-is-not-very-secret-99";
        
        return Jwts.builder().setSubject( correo ).claim( "role", "user" )
                .setIssuedAt( new Date() ).setExpiration( calendar.getTime())
                .signWith( SignatureAlgorithm.HS256, secret ).compact();
	}//generateToken
	
	
	

}//AuthController
