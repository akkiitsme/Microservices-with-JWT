package com.jwtservice.home;

import com.jwtservice.user.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class HomeController {

    @GetMapping("/welcome")
    public String welcome(){
        System.out.println("Auth Details: " + SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        User user  = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "Welcome Home - "+user.getFirstName() + " "+user.getLastName();
    }

}
