package com.cognitive.cogdemver.controllers;

import com.cognitive.cogdemver.models.dto.LoginDto;
import com.cognitive.cogdemver.models.dto.RegistrationDTO;
import com.cognitive.cogdemver.models.User;
import com.cognitive.cogdemver.services.UserService;
import com.cognitive.cogdemver.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @Autowired
    public AuthController(UserService userService, AuthenticationService authenticationService) {
        this.userService = userService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<HttpStatus> register(@RequestBody RegistrationDTO dto) {
        User user = userService.create(dto);
        userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        authenticationService.setUserAuthentication(loginDto.getUsername());
        return ResponseEntity.ok("Login successful");
    }
}
