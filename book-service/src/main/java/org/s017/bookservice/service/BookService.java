package org.s017.bookservice.service;

import org.s017.bookservice.entities.Book;
import org.s017.bookservice.entities.BookDTO;
import org.s017.bookservice.entities.ResponseDTO;
import org.s017.bookservice.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void saveBook(BookDTO data){
        var book = new Book(data);
        this.bookRepository.save(book);
    }

    public void setBookAvailableTrue(String id){
        var book = this.bookRepository.findById(id).orElseThrow();
        book.setAvailable(true);
        this.bookRepository.save(book);
    }

    public void setBookAvailableFalse(String id){
        var book = this.bookRepository.findById(id).orElseThrow();
        book.setAvailable(false);
        this.bookRepository.save(book);
    }

    public List<ResponseDTO> getAllBooksAvailable(){
        return this.bookRepository.findAllByAvailableIsTrue();
    }
}