package org.s017.apigateway.entities;

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
