package org.s017.accountservice.controller;

import jakarta.validation.Valid;
import org.s017.accountservice.entities.RequestDTO;
import org.s017.accountservice.entities.ResponseDTO;
import org.s017.accountservice.service.UserService;
import org.s017.accountservice.entities.User;
import org.s017.accountservice.entities.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3006") // Apontar para o front
@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserDTO data){
        this.userService.saveUser(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> loginUser(@RequestBody @Valid RequestDTO data){
        return ResponseEntity.ok(userService.loginUser(data));
    }
}