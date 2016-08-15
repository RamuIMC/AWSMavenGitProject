package com.project.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.google.gson.Gson;

public class DDAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException {
		//String token = "989009esdfldkklkdri8y9[-p-0-0[p;r";
		
		StatusMessageDto statusMessageDto = new StatusMessageDto();
		
		statusMessageDto.setStatus(HttpServletResponse.SC_OK);
		statusMessageDto.setMessage("Authentication has been successful");
		
		
		String json = new Gson().toJson(statusMessageDto);
		
		response.getWriter().print(json);
		
	
		
	}

}
