package com.project.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.google.gson.Gson;

public class DDAuthenticationFailureHandler implements AuthenticationFailureHandler{

	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		
		StatusMessageDto statusMessageDto = new StatusMessageDto();
		
		statusMessageDto.setStatus(HttpServletResponse.SC_FORBIDDEN);
		statusMessageDto.setMessage("Authentication has been failed");
		
		
		String json = new Gson().toJson(statusMessageDto);
		
		response.getWriter().print(json);
		
	}

}
