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
public class User {
    @Id
    String id;
    String nickName;
    String password;

    public User(UserDTO data) {
        this.nickName = data.nickName();
        this.password = data.password();
    }
}
