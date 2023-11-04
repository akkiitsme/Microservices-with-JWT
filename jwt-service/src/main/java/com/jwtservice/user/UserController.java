package com.jwtservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired private UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/users-details")
    public ResponseEntity<?> getUserList(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/users-details/{userId}")
    public ResponseEntity<?> getSpecificUser(@PathVariable String userId){
        try {
            return ResponseEntity.ok(userService.getUserById(userId));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
