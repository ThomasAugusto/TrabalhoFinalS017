package org.s017.bookservice.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "books")
public class Book {
    @Id
    String id;
    String title;
    String author;
    boolean available;

    public Book(BookDTO data){
        this.title = data.title();
        this.author = data.author();
        this.available = true;
    }
}
