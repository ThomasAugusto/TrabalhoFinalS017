package org.s017.apigateway.routing;

import org.s017.apigateway.entities.Book;
import org.s017.apigateway.entities.Borrow;
import org.s017.apigateway.entities.BorrowDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "borrow-service", url = "http://localhost:3005")
public interface BorrowService {

    @PostMapping("/v1/borrow")
    ResponseEntity<Borrow> createBorrow(@RequestBody BorrowDTO data);

    @PutMapping("/v1/borrow/{id}/remove-book")
    ResponseEntity<Borrow> removeBook(@PathVariable String id, @RequestBody Book book);

    @PutMapping("/v1/borrow/{id}/add-book")
    ResponseEntity<Borrow> addBook(@PathVariable String id, @RequestBody Book book);

    @DeleteMapping("/v1/borrow/{id}")
    ResponseEntity<Void> deleteBorrow(@PathVariable String id);

    @GetMapping("/v1/borrow/{id}")
    ResponseEntity<Borrow> getBorrowById(@PathVariable String id);
}
