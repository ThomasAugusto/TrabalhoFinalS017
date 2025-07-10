package org.s017.apigateway.entities;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Borrow {
    @Id
    private String id;
    private Client client;
    private List<Book> books;

    public Borrow(Client client, List<Book> books){
        this.client = client;
        this.books = books;
    }

    public void addBook(Book book){
        this.books.add(book);
    }

    public void removeBook(Book book){
        this.books.remove(book);
    }
}
