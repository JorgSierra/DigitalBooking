package com.dh.digital_booking_back.security;

import com.dh.digital_booking_back.security.jwt.JwtRequestFilter;
import com.dh.digital_booking_back.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    JwtRequestFilter jwtRequestFilter;

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(usuarioService);
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        return provider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable()
                .authorizeRequests()
                // Vistas
                .antMatchers("verificacion_exitosa.html", "verificacion_fallida.html").permitAll()
                // Swagger docs
                .antMatchers("/v3/api-docs/**", "/swagger-ui*", "/swagger-ui/**").permitAll()
                // Autenticación
                .antMatchers(HttpMethod.POST,"/auth").permitAll()
                // Característica
                .antMatchers(HttpMethod.DELETE,"/api/caracteristicas/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/api/caracteristicas").permitAll()
                .antMatchers(HttpMethod.GET,"/api/caracteristicas/{id}").permitAll()
                .antMatchers(HttpMethod.POST,"/api/caracteristicas").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/caracteristicas").hasRole("ADMIN")
                // Categoría
                .antMatchers(HttpMethod.DELETE,"/api/categorias/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/api/categorias").permitAll()
                .antMatchers(HttpMethod.GET,"/api/categorias/{id}").permitAll()
                .antMatchers(HttpMethod.POST,"/api/categorias").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/categorias").hasRole("ADMIN")
                // Imagen
                .antMatchers(HttpMethod.DELETE,"/api/imagenes/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/api/imagenes").permitAll()
                .antMatchers(HttpMethod.GET,"/api/imagenes/{id}").permitAll()
                .antMatchers(HttpMethod.POST,"/api/imagenes").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/imagenes").hasRole("ADMIN")
                // Like
                .antMatchers(HttpMethod.DELETE,"/api/likes/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/api/likes").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/api/likes/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/api/likes/usuario/{id}").hasAnyRole("ADMIN","USER")
                .antMatchers(HttpMethod.GET,"/api/likes/producto/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/api/likes").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/api/likes/toggle/{idProducto}").hasAnyRole("ADMIN","USER")
                // Política
                .antMatchers(HttpMethod.DELETE,"/api/politicas/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/api/politicas").permitAll()
                .antMatchers(HttpMethod.GET,"/api/politicas/{id}").permitAll()
                .antMatchers(HttpMethod.POST,"/api/politicas").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/politicas").hasRole("ADMIN")
                // Producto
                .antMatchers(HttpMethod.DELETE,"/api/productos/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/api/productos").permitAll()
                .antMatchers(HttpMethod.GET,"/api/productos/{id}").permitAll()
                .antMatchers(HttpMethod.GET,"/api/productos/ubicacion/{id}").permitAll()
                .antMatchers(HttpMethod.GET,"/api/productos/ubicacion/ciudad/{ciudad}").permitAll()
                .antMatchers(HttpMethod.GET,"/api/productos/rand").permitAll()
                .antMatchers(HttpMethod.GET,"/api/productos/categoria/{id}").permitAll()
                .antMatchers(HttpMethod.GET,"/api/productos/usuario/{id}").hasAnyRole("ADMIN","USER")
                .antMatchers(HttpMethod.POST,"/api/productos").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/api/productos/disponible").permitAll()
                .antMatchers(HttpMethod.POST,"/api/productos/disponibleYCiudad").permitAll()
                .antMatchers(HttpMethod.PUT,"/api/productos").hasRole("ADMIN")
                // Puntuación
                .antMatchers(HttpMethod.DELETE,"/api/puntuaciones/{id}").hasAnyRole("ADMIN","USER")
                .antMatchers(HttpMethod.GET,"/api/puntuaciones").permitAll()
                .antMatchers(HttpMethod.GET,"/api/puntuaciones/{id}").permitAll()
                .antMatchers(HttpMethod.GET,"/api/puntuaciones/producto/{id}").permitAll()
                .antMatchers(HttpMethod.GET,"/api/puntuaciones/usuario/{id}").hasAnyRole("ADMIN","USER")
                .antMatchers(HttpMethod.POST,"/api/puntuaciones").hasAnyRole("ADMIN","USER")
                // Reserva
                .antMatchers(HttpMethod.DELETE,"/api/reservas/{id}").hasAnyRole("ADMIN","USER")
                .antMatchers(HttpMethod.GET,"/api/reservas").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/api/reservas/{id}").hasAnyRole("ADMIN","USER")
                .antMatchers(HttpMethod.GET,"/api/reservas/usuario/{id}").hasAnyRole("ADMIN","USER")
                .antMatchers(HttpMethod.GET,"/api/reservas/producto/{id}").permitAll()
                .antMatchers(HttpMethod.POST,"/api/reservas").hasAnyRole("ADMIN","USER")
                .antMatchers(HttpMethod.PUT,"/api/reservas").hasAnyRole("ADMIN","USER")
                // Rol
                .antMatchers(HttpMethod.DELETE,"/api/roles/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/api/roles").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/api/roles/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/api/roles").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/roles").hasRole("ADMIN")
                // Tipo de política
                .antMatchers(HttpMethod.DELETE,"/api/tipoliticas/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/api/tipoliticas").permitAll()
                .antMatchers(HttpMethod.GET,"/api/tipoliticas/{id}").permitAll()
                .antMatchers(HttpMethod.POST,"/api/tipoliticas").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/tipoliticas").hasRole("ADMIN")
                // Ubicación
                .antMatchers(HttpMethod.DELETE,"/api/ubicaciones/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/api/ubicaciones").permitAll()
                .antMatchers(HttpMethod.GET,"/api/ubicaciones/{id}").permitAll()
                .antMatchers(HttpMethod.GET,"/api/ubicaciones/ciudad/{string}").permitAll()
                .antMatchers(HttpMethod.POST,"/api/ubicaciones").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/ubicaciones").hasRole("ADMIN")
                // Usuario
                .antMatchers(HttpMethod.DELETE,"/api/usuarios/{id}").hasAnyRole("ADMIN","USER")
                .antMatchers(HttpMethod.GET,"/api/usuarios/list").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/api/usuarios/{id}").hasAnyRole("ADMIN","USER")
                .antMatchers(HttpMethod.GET,"/api/usuarios/verificar/{codigo}").permitAll()
                .antMatchers(HttpMethod.POST,"/api/usuarios").permitAll()
                .antMatchers(HttpMethod.POST,"/api/usuarios/admin").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/usuarios").hasAnyRole("ADMIN","USER")
                .antMatchers(HttpMethod.PUT,"/api/usuarios/ciudad").hasAnyRole("ADMIN","USER")
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
