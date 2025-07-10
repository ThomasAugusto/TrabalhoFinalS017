package org.s017.bookservice.controller;

import jakarta.validation.Valid;
import org.s017.bookservice.entities.Book;
import org.s017.bookservice.entities.BookDTO;
import org.s017.bookservice.entities.ResponseDTO;
import org.s017.bookservice.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3006")
@RestController
@RequestMapping("/v1/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody @Valid BookDTO data){
        this.bookService.saveBook(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}/available")
    public ResponseEntity<Void> setBookAvailable(@PathVariable String id){
        this.bookService.setBookAvailableTrue(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/unavailable")
    public ResponseEntity<Void> setBookUnavailable(@PathVariable String id){
        this.bookService.setBookAvailableFalse(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/available")
    public ResponseEntity<Iterable<ResponseDTO>> getAllBooksAvailable(){
        return ResponseEntity.ok(this.bookService.getAllBooksAvailable());
    }
}
