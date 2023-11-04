package com.config;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.function.Predicate;

@Component
public class RouteValidator {

    //It's Ignore these mappings
    public static final List<String> openApiEndpoints =
            new ArrayList<>(Arrays.asList("/users/**",
                    "/eureka"
            ));

    //filter associations
    public Predicate<ServerHttpRequest> isSecured = request -> openApiEndpoints.stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));

}
