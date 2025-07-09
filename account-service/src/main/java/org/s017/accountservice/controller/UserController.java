package org.s017.accountservice.controller;

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

    @PostMapping()
    public ResponseEntity<String> save(@RequestBody UserDTO data) {
        var id = this.userService.save(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable String id) {
        return ResponseEntity.ok(this.userService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable String id) {
        return ResponseEntity.ok(this.userService.deleteById(id));
    }

    @GetMapping
    public ResponseEntity<Iterable<User>> findAll() {
        return ResponseEntity.ok(this.userService.findAll());
    }

    @PutMapping()
    public ResponseEntity<User> update(@RequestBody User user) {
        this.userService.update(user);
        return ResponseEntity.ok().build();
    }
}