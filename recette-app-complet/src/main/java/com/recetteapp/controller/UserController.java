// Controller for User
package com.recetteapp.controller;

import com.recetteapp.model.User;
import com.recetteapp.service.UserService;
import com.recetteapp.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class UserController {
    @Autowired private UserService userService;
    @Autowired private AuthenticationManager authManager;
    @Autowired private JwtUtils jwtUtils;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> body) {
        Authentication auth = authManager.authenticate(
            new UsernamePasswordAuthenticationToken(body.get("username"), body.get("password")));
        SecurityContextHolder.getContext().setAuthentication(auth);
        String token = jwtUtils.generateToken(auth);
        return ResponseEntity.ok(Map.of("token", token));
    }
}
