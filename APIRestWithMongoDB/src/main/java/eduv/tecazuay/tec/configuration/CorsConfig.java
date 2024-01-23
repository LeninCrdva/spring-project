package eduv.tecazuay.tec.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

 @Bean
 public CorsFilter corsFilter() {
     UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
     CorsConfiguration config = new CorsConfiguration();

     config.addAllowedOrigin("*");

     // Permitir solicitudes con los métodos GET, POST, PUT, DELETE, etc.
     config.addAllowedMethod("*");

     // Permitir solicitudes con los encabezados específicos (ajusta según tus necesidades)
     config.addAllowedHeader("*");

     source.registerCorsConfiguration("/**", config);
     return new CorsFilter(source);
 }
}
