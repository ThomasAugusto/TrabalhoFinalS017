package org.s017.accountservice.repository;
import org.s017.accountservice.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    boolean existsByEmail(String email);

    User findByEmailAndPassword(String email, String password);
}