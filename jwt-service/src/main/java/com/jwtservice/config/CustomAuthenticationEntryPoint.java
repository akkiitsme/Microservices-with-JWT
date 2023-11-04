package com.jwtservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request , HttpServletResponse response , AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(new ErrorResponse("Access Denied - "+authException.getMessage()));
        response.getWriter().write(json);
    }
}

@Data
class ErrorResponse {
    private String status;
    private String message;
    private boolean success;

    public ErrorResponse(String message) {
        this.status = HttpStatus.UNAUTHORIZED.toString();
        this.message = message;
        this.success = false;
    }
}


