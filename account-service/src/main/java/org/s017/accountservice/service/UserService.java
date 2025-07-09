package org.s017.accountservice.service;

import org.s017.accountservice.entities.User;
import org.s017.accountservice.entities.UserDTO;
import org.s017.accountservice.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String save(UserDTO data) {
        var user = new User(data);
        return userRepository.save(user).getId();
    }

    public User findById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public boolean deleteById(String id) {
        userRepository.deleteById(id);
        return !userRepository.existsById(id);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public void update(User user) {
        userRepository.save(user);
    }
}
