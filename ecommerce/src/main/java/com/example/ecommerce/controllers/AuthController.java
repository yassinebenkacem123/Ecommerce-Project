package com.example.ecommerce.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.ecommerce.exceptions.APIException;
import com.example.ecommerce.models.AppRole;
import com.example.ecommerce.models.Role;
import com.example.ecommerce.models.User;
import com.example.ecommerce.payload.APIResponse;
import com.example.ecommerce.payload.LoginRequest;
import com.example.ecommerce.payload.LoginResponse;
import com.example.ecommerce.payload.SignupRequest;
import com.example.ecommerce.repository.RoleRepo;
import com.example.ecommerce.repository.UserRepo;
import com.example.ecommerce.security.jwt.JwtUtils;
import com.example.ecommerce.security.services.UserDetailsImpl;

import jakarta.validation.Valid;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequestMapping("/api/v2/auth")
public class AuthController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> loginMedthod(@RequestBody @Valid LoginRequest loginRequest) {
        Authentication authentication;
        try {
            User user = userRepo.findByEmail(loginRequest.getEmail());
            if (user == null) {
                throw new APIException("No User with this email.");
            }
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getUsername(),
                            loginRequest.getPassword()));

        } catch (AuthenticationException e) {
            APIResponse apiResponse = new APIResponse();
            apiResponse.setMessage(e.getMessage());
            apiResponse.setStatus(false);
            return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String jwtToken = jwtUtils.generateTokenFromUserName(userDetails);
        List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
                .collect(Collectors.toList());
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setId(userDetails.getId());
        loginResponse.setUsername(userDetails.getUsername());
        loginResponse.setEmail(userDetails.getEmail());
        loginResponse.setJwtToken(jwtToken);
        loginResponse.setRoles(roles);
        return new ResponseEntity<>(loginResponse, HttpStatus.OK);

    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody @Valid SignupRequest signupRequest) {

        if (userRepo.existsByUsername(signupRequest.getUsername())) {
            throw new APIException("User name Already used");
        }
        if (userRepo.existsByEmail(signupRequest.getEmail())) {
            throw new APIException("Email Already used");
        }

        User user = new User();
        user.setUsername(signupRequest.getUsername());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(encoder.encode(signupRequest.getPassword()));

        Set<String> strRoles = signupRequest.getRole();
        Set<Role> roles = new HashSet<>();
        if (strRoles == null) {
            Role userRole = roleRepo.findByRoleName(AppRole.ROLE_USER);
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepo.findByRoleName(AppRole.ROLE_ADMIN);
                        roles.add(adminRole);
                        break;
                    case "seller":
                        Role sellerRole = roleRepo.findByRoleName(AppRole.ROLE_SELLER);
                        roles.add(sellerRole);
                        break;
                    default:
                        Role userRole = roleRepo.findByRoleName(AppRole.ROLE_USER);
                        roles.add(userRole);
                        break;
                }
            });

        }
        user.setUserRoles(roles);
        userRepo.save(user);
        APIResponse apiResponse = new APIResponse();
        apiResponse.setMessage("user registered successfly.");
        apiResponse.setStatus(true);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
