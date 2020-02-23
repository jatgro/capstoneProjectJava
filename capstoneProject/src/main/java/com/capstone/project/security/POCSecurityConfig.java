package com.capstone.project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.capstone.project.filters.JwtRequestFilter;

@Configuration
@EnableWebSecurity
public class POCSecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String STUDENT = "STUDENT";

	@Autowired
	// @Qualifier(value = "studentDetailService")
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//		//.antMatchers("/getAddressByState").permitAll()
//	    //.anyRequest().authenticated()
//		.antMatchers("/**").hasRole(STUDENT)
//	    
//	    .and().formLogin();
//
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and()
		.csrf().disable().authorizeRequests()
		.antMatchers("/authenticate").permitAll()
		.antMatchers("/**").hasRole(STUDENT)
		.anyRequest().authenticated()
		.and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder paswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
