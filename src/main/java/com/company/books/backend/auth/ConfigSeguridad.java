package com.company.books.backend.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class ConfigSeguridad  extends WebSecurityConfigurerAdapter {
 /**
  * configuracion para
  */
    @Autowired
    private UserDetailsService usuarioService;

    /**
     * Para versiones superiores 2.6.0
     * public static BCryptPasswordEncoder passwordEncoder() {
     */

    /*Se coloca static por la versión 2.6.2..*/
    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.usuarioService).passwordEncoder(passwordEncoder()); // para incriptear las contraseñas
    }

    /**
     * El siguiente metodo nace tras la creación de la clase ServidorAutorizacion

     */
    @Bean("authenticationManager")
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {

        return super.authenticationManager();
    }


    /**
     *  linea 61 al 63, escritas tras implementar ConfiguraciónRecursos, explicación:
     * Vamos a escribir algunas reglas para deshabilitar configuraciones que no son necesarias,
     * que utiliza la configuración de spring,
     * csrf().disable() _> que deshabilite la comprobación de la regla de origen cruzados, ya que  que front y back no será una
     * misma aplicación , caso contrario de que si lo fuesen tendría que estar.
     * sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)_> deshabilitar el manejo de sesiones
     * porr parte de srping
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers(HttpMethod.GET, "/v1/categorias").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }



}
