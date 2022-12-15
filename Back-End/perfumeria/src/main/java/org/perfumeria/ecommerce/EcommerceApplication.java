package org.perfumeria.ecommerce;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class EcommerceApplication {
	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}//main
	@Bean
	public FilterRegistrationBean<JwtFilter> jwtFilter(){
		FilterRegistrationBean<JwtFilter> registrationBean =
				new FilterRegistrationBean<JwtFilter>();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/api/v1/clientes");
		registrationBean.addUrlPatterns("/api/v1/clientes/*");
		return registrationBean;
	}
	

	
}//EcommerceApplication

//_src/main/resources/application.properties/spring.datasource.password={AQUIPONTUPASSWORDDETUMYSQL}