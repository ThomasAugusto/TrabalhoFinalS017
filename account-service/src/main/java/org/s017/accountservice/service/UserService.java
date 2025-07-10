package org.s017.accountservice.service;

import org.s017.accountservice.entities.RequestDTO;
import org.s017.accountservice.entities.ResponseDTO;
import org.s017.accountservice.entities.User;
import org.s017.accountservice.entities.UserDTO;
import org.s017.accountservice.exception.EmailAlreadyInUseException;
import org.s017.accountservice.exception.UserNotFoundException;
import org.s017.accountservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(UserDTO data){

        if (existsByEmail(data.email())) {
            throw new EmailAlreadyInUseException();
            }
        var user = new User(data);
        this.userRepository.save(user);
    }

    public ResponseDTO loginUser(RequestDTO data){
        var user = this.userRepository.findByEmailAndPassword(data.email(),data.password());
        return Optional.ofNullable(user)
                .map(u -> new ResponseDTO(u.getId(), u.getName(), u.getEmail()))
                .orElseThrow(UserNotFoundException::new);
    }

    private boolean existsByEmail(String email) {
        return this.userRepository.existsByEmail(email);
    }
}