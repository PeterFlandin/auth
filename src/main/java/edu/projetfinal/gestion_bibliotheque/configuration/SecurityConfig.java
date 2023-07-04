package edu.projetfinal.gestion_bibliotheque.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import edu.projetfinal.gestion_bibliotheque.entity.Librarian;
import edu.projetfinal.gestion_bibliotheque.entity.Subscriber;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	  public SecurityConfig(Librarian librarian, Subscriber subscriber) {
	        this.librarian = librarian;
	        this.subscriber = subscriber;
	    }
	@Autowired
	private Librarian librarian;
	@Autowired
	private Subscriber subscriber;
	
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		 auth
            .inMemoryAuthentication()
                .withUser(librarian.getLogin())
                .password(librarian.getPassword())
                .roles("LIBRARIAN", "SUBSCRIBER")
            .and()
                .withUser(subscriber.getLogin())
                .password(subscriber.getPassword())
                .roles("SUBSCRIBER");
    }
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/admin/**").hasRole("LIBRARIAN")
                .requestMatchers("/user/**").hasRole("SUBSCRIBER")
                .anyRequest().authenticated()
            )
            .formLogin(formLogin -> formLogin
                .loginPage("/login")
                .permitAll()
            )
            .rememberMe(Customizer.withDefaults());
        
        return http.build();
    }
   
    
}