package com.project.manager;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

public class TokenValidationFilter extends OncePerRequestFilter {

	@Autowired
	UserDetailsService customUserDetailsService;
	
	
	@SuppressWarnings("unused")
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		
		Authentication auth2= SecurityContextHolder.getContext().getAuthentication();
		doFilter(request, response, filterChain);
	/*String token = request.getHeader("AccessToken");
	String authorization = request.getHeader("Authorization");

	String username = request.getParameter("username");
	String password = request.getParameter("password");	
	
	if(token.equals(username)){
	
	Authentication auth= SecurityContextHolder.getContext().getAuthentication();
		if(token !=null || auth !=null){
			
		UserDetails user = customUserDetailsService.loadUserByUsername(token);	
		 
			System.out.println("user name : " +user.getUsername());
			
			Authentication authentication = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			
				
			doFilter(request, response, filterChain);
		
		}
		else{
			
			doFilter(request, response, filterChain);
		}
	}*/
	}
	


}
