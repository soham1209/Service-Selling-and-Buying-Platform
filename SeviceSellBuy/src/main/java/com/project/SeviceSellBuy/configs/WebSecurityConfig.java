package com.project.SeviceSellBuy.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.project.SeviceSellBuy.service.jwt.JwtRequestFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

	@Autowired
	private JwtRequestFilter requestFilter;
	
	@Autowired
	private SimpleCorsFilter simpleCorsFilter;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    return http
	            .csrf(csrf -> csrf.disable())
	            .cors(cors -> cors.configurationSource(simpleCorsFilter.corsConfigurationSource())) // Add CORS configuration
	            .authorizeHttpRequests(requests -> requests
	                    .requestMatchers("/authenticate", "/company/sign-up", "/client/sign-up", "/ads", "/search/{service}")
	                    .permitAll()
	                    .anyRequest().authenticated())
	            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	            .addFilterBefore(requestFilter, UsernamePasswordAuthenticationFilter.class)
	            .build();
	}
	
	//proper spring securty
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		return http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(requests -> requests
//				.requestMatchers("/authenticate", "/company/sign-up", "/client/sign-up", "/ads", "/search/{service}")
//				.permitAll().anyRequest().authenticated())
//				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//				.addFilterBefore(requestFilter, UsernamePasswordAuthenticationFilter.class).build();
//	}
	
	//for bypaisng spring seurty
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//	    // Temporarily disable security by allowing all requests
//	    return http.csrf(csrf -> csrf.disable())
//	            .authorizeHttpRequests(requests -> requests
//	                    .anyRequest().permitAll()) // Allow all requests
//	            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//	            .build();
//	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
