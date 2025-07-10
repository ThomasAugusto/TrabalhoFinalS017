package org.s017.borrowingservice.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Client {
    private String id;
    private String name;
    private String email;
}
