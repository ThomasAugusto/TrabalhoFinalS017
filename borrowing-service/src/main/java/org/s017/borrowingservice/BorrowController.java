package org.s017.borrowingservice;

import jakarta.validation.Valid;
import org.s017.borrowingservice.entity.Book;
import org.s017.borrowingservice.entity.Borrow;
import org.s017.borrowingservice.entity.BorrowDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3006")
@RestController
@RequestMapping("/v1/borrow")
public class BorrowController {
    private final BorrowService borrowService;

    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @PostMapping
    public ResponseEntity<Borrow> createBorrow(@RequestBody @Valid BorrowDTO data){
        return ResponseEntity.status(HttpStatus.CREATED).body(borrowService.createBorrow(data));
    }

    @PutMapping("/{id}/remove-book")
    public ResponseEntity<Borrow> removeBook(@PathVariable String id, @RequestBody @Valid Book book){
        return ResponseEntity.ok(borrowService.removeBook(id, book));
    }

    @PutMapping("/{id}/add-book")
    public ResponseEntity<Borrow> addBook(@PathVariable String id, @RequestBody @Valid Book book){
        return ResponseEntity.ok(borrowService.addBook(id, book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBorrow(@PathVariable String id){
        borrowService.deleteBorrow(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Borrow> getBorrowById(@PathVariable String id){
        return ResponseEntity.ok(borrowService.getBorrowByClient(id));
    }
}