package org.perfumeria.ecommerce;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;


public class JwtFilter extends GenericFilterBean{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		
		String authHeader = httpServletRequest.getHeader("Authorization");
		
		 if ( 
	    		  (httpServletRequest.getMethod().equals("PUT"))||
	    		  (httpServletRequest.getMethod().equals("DELETE"))||
	    		  (httpServletRequest.getMethod().equals("GET")) ) {
	    	  	if  ( (authHeader== null ) || (!authHeader.startsWith("Bearer ")) ) {
	    	  		throw new ServletException("1. Invalid Token !");
	    	  	} // == null ! Bearer
	    	  	String token = authHeader.substring(7);
	    	  	try  {
	                Claims claims = Jwts.parser().setSigningKey("this-secret-is-not-very-secret-99")
	                        .parseClaimsJws(token).getBody();
	                request.setAttribute( "claims", claims );
	            }  catch ( MalformedJwtException e ) {
	                throw new ServletException( "2. Invalid Token!" );
	            }//catch
	    	  
	      }//POST - PUT - DELETE - GET
		 chain.doFilter(httpServletRequest, httpServletResponse);	
		
	}//doFilter
	
	

}//JwtFilter
