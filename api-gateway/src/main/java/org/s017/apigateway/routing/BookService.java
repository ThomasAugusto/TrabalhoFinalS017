package org.s017.apigateway.routing;

import org.s017.apigateway.entities.BookDTO;
import org.s017.apigateway.entities.BookResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "book-service", url = "http://localhost:3004")
public interface BookService {

    @PostMapping("/v1/book")
    ResponseEntity<Void> saveBook(@RequestBody BookDTO data);

    @PutMapping("/v1/book/{id}/available")
    ResponseEntity<Void> setBookAvailable(@PathVariable String id);

    @PutMapping("/v1/book/{id}/unavailable")
    ResponseEntity<Void> setBookUnavailable(@PathVariable String id);

    @GetMapping("/v1/book/available")
    ResponseEntity<Iterable<BookResponseDTO>> getAllBooksAvailable();
}

