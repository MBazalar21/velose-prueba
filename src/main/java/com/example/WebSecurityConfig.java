package com.example;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {  
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
            .cors().and().csrf().disable()
            // .csrf().disable()
			.authorizeHttpRequests()
            .requestMatchers("/api/empresa/create").permitAll()
            .requestMatchers("/api/empresa/findLastThree").hasRole("USER")
            .and().httpBasic()
            .and().authenticationManager(authManager(http));

		return http.build();
	}

    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
         
         // authenticationManagerBuilder.inMemoryAuthentication()
         //                             .withUser("user").password("{noop}mypassword").roles("USER");

         authenticationManagerBuilder.authenticationProvider(authenticationProvider());
         return authenticationManagerBuilder.build();
 }

    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService());
        return provider;
        
    }

    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("hector")
                .password("{noop}1234")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
}

    public PasswordEncoder passwordEncoder() {
        Map<String,PasswordEncoder> encoders = new HashMap<>();
        //encoders.put("bcrypt", new BCryptPasswordEncoder());
        encoders.put("noop", NoOpPasswordEncoder.getInstance());
        return new DelegatingPasswordEncoder("noop", encoders); 
}
}
