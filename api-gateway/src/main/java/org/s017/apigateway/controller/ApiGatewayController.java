package org.s017.apigateway.controller;

import org.s017.apigateway.entities.*;
import org.s017.apigateway.routing.BookService;
import org.s017.apigateway.routing.BorrowService;
import org.s017.apigateway.routing.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3006")//apontado para o front
@RestController
@RequestMapping("/api")
public class ApiGatewayController {

    private final BookService bookService;
    private final BorrowService borrowService;
    private final ClientService clientService;

    public ApiGatewayController(BookService bookService, BorrowService borrowService, ClientService clientService) {
        this.bookService = bookService;
        this.borrowService = borrowService;
        this.clientService = clientService;
    }

    // ====== BOOK SERVICE ======

    @PostMapping("/book")
    public ResponseEntity<Void> createBook(@RequestBody BookDTO data) {
        return bookService.saveBook(data);
    }

    @PutMapping("/book/{id}/available")
    public ResponseEntity<Void> setBookAvailable(@PathVariable String id) {
        return bookService.setBookAvailable(id);
    }

    @PutMapping("/book/{id}/unavailable")
    public ResponseEntity<Void> setBookUnavailable(@PathVariable String id) {
        return bookService.setBookUnavailable(id);
    }

    @GetMapping("/book/available")
    public ResponseEntity<List<BookResponseDTO>> listAvailableBooks() {
        var response = bookService.getAllBooksAvailable();
        var iterable = response.getBody();

        if (iterable == null) {
            return ResponseEntity.noContent().build();
        }

        List<BookResponseDTO> list = new ArrayList<>();
        iterable.forEach(list::add);
        return ResponseEntity.ok(list);
    }

    // ====== BORROW SERVICE ======

    @PostMapping("/borrow")
    public ResponseEntity<Borrow> createBorrow(@RequestBody BorrowDTO data) {
        return borrowService.createBorrow(data);
    }

    @PutMapping("/borrow/{id}/add-book")
    public ResponseEntity<Borrow> addBookToBorrow(@PathVariable String id, @RequestBody Book book) {
        return borrowService.addBook(id, book);
    }

    @PutMapping("/borrow/{id}/remove-book")
    public ResponseEntity<Borrow> removeBookFromBorrow(@PathVariable String id, @RequestBody Book book) {
        return borrowService.removeBook(id, book);
    }

    @DeleteMapping("/borrow/{id}")
    public ResponseEntity<Void> deleteBorrow(@PathVariable String id) {
        return borrowService.deleteBorrow(id);
    }

    @GetMapping("/borrow/{id}")
    public ResponseEntity<Borrow> getBorrowByClient(@PathVariable String id) {
        return borrowService.getBorrowById(id);
    }

    // ====== CLIENT SERVICE ======

    @PostMapping("/user")
    public ResponseEntity<String> createUser(@RequestBody UserDTO data) {
        return clientService.saveUser(data);
    }

    @PostMapping("/user/login")
    public ResponseEntity<String> loginUser(@RequestBody UserRequestDTO data) {
        return clientService.loginUser(data);
    }

}