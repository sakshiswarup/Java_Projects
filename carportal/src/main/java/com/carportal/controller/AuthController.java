package com.carportal.controller;


import com.carportal.entity.User;
import com.carportal.payload.LoginDto;
import com.carportal.repository.UserRepository;
import com.carportal.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private UserRepository userRepository;
    private AuthService authService;

    public AuthController(UserRepository userRepository, AuthService authService) {
        this.userRepository = userRepository;
        this.authService = authService;
    }
   @PostMapping("/user/sign-up")
    public ResponseEntity<String> createUser(
            @RequestBody User user) {
       Optional<User> opEmail = userRepository.findByEmail(user.getEmail());
       if (opEmail.isPresent()) {
           return new ResponseEntity<>("Email id exists", HttpStatus.INTERNAL_SERVER_ERROR);
       }

       Optional<User> opMobile = userRepository.findByMobile(user.getMobile());
       if (opMobile.isPresent()) {
           return new ResponseEntity<>("Mobile number exists", HttpStatus.INTERNAL_SERVER_ERROR);
       }

       Optional<User> opUsername = userRepository.findByUsername(user.getUsername());
       if (opUsername.isPresent()) {
           return new ResponseEntity<>("Username already exists", HttpStatus.INTERNAL_SERVER_ERROR);
       }
       String hashpw = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
       user.setPassword(hashpw);
       user.setRole("ROLE_USER");
       userRepository.save(user);
       return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
   }

    @PostMapping("/owner/sign-up")
    public ResponseEntity<String> createOwner(
            @RequestBody User user) {
        Optional<User> opEmail = userRepository.findByEmail(user.getEmail());
        if (opEmail.isPresent()) {
            return new ResponseEntity<>("Email id exists", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Optional<User> opMobile = userRepository.findByMobile(user.getMobile());
        if (opMobile.isPresent()) {
            return new ResponseEntity<>("Mobile number exists", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Optional<User> opUsername = userRepository.findByUsername(user.getUsername());
        if (opUsername.isPresent()) {
            return new ResponseEntity<>("Username already exists", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        String hashpw = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
        user.setPassword(hashpw);
        user.setRole("ROLE_OWNER");
        userRepository.save(user);
        return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<String> verifyLogin(
            @RequestBody LoginDto dto
    ){
        String jwtToken = authService.authenticate(dto);
        if(jwtToken != null){

            return new ResponseEntity<>(jwtToken, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Invalid ", HttpStatus.OK);
        }
    }

}
