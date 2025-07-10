package org.s017.bookservice.repository;

import org.s017.bookservice.entities.Book;
import org.s017.bookservice.entities.ResponseDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    List<ResponseDTO> findAllByAvailableIsTrue();
}
