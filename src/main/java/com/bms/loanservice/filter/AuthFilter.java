package com.bms.loanservice.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class AuthFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		
		String userName=request.getHeader("Auth_User");
		
		if(userName==null && !request.getRequestURL().toString().contains("/swagger") && !request.getRequestURL().toString().contains("v3/api-docs") && !request.getRequestURL().toString().contains("/h2-console"))
		{
			throw new IllegalStateException("Not Authorized");
		}
		filterChain.doFilter(request,response);
	}
	
	
	

}
