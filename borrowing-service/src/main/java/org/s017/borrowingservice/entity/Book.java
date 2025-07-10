package org.s017.borrowingservice.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {
    private String id;
    private String title;
    private String author;
}
