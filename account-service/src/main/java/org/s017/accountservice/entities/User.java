package org.s017.accountservice.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "users")
public class User{
    @Id
    String id;
    String name;
    String email;
    String password;

    public User(UserDTO data) {
        this.name = data.name();
        this.email = data.email();
        this.password = data.password();
    }
}
