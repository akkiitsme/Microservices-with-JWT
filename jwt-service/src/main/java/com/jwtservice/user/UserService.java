package com.jwtservice.user;

import com.jwtservice.jwt.AuthenticationResponse;
import com.jwtservice.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtil jwtUtil;

    public AuthenticationResponse saveUser(User user){
        user.setId(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user = userDao.save(user);
        return new AuthenticationResponse(jwtUtil.generateToken(user));
    }

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public User getUserById(String userId) throws Throwable {
        return userDao.findById(userId).orElseThrow(Throwable::new);
    }
}
