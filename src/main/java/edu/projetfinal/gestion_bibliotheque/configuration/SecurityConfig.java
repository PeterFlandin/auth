package edu.projetfinal.gestion_bibliotheque.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {
	

	@Bean
    public SecurityFilterChain apiSecurity(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((auth) -> auth
                .requestMatchers("/login/librarian").hasRole("LIBRARIAN")
                .requestMatchers("/login/subscriber").hasRole("SUBSCRIBER")
                .anyRequest()
                .authenticated())
        .formLogin(formLogin -> formLogin
                .loginPage("/login")
                .permitAll()
                
        		)
        .rememberMe(Customizer.withDefaults());
      
        return http.build();
    }



	@Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails subscriber = User.builder()
                .username("subscriber")
                .password(passwordEncoder().encode("user"))
                .roles("SUBSCRIBER")
                .build();
        UserDetails librarian = User.builder()
                .username("librarian")
                .password(passwordEncoder().encode("admin"))
                .roles("LIBRARIAN")
                .build();

        return new InMemoryUserDetailsManager(librarian, subscriber);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}