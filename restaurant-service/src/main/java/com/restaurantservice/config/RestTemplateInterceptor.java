package com.restaurantservice.config;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RestTemplateInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request , byte[] body , ClientHttpRequestExecution execution) throws IOException {
        // Get the current HttpServletRequest
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest httpServletRequest = attributes.getRequest();
        String token  = httpServletRequest.getHeader("Authorization");
        //System.out.println("Rest Interceptor Token: "+token);
        request.getHeaders().add("Authorization",token);
        return execution.execute(request, body);
    }
}
