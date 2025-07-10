package org.s017.borrowingservice;

import org.s017.borrowingservice.entity.Book;
import org.s017.borrowingservice.entity.Borrow;
import org.s017.borrowingservice.entity.BorrowDTO;
import org.s017.borrowingservice.exception.BorrowNotFoundException;
import org.s017.borrowingservice.repository.BorrowRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BorrowService {
    private final BorrowRepository borrowRepository;

    public BorrowService(BorrowRepository borrowRepository) {
        this.borrowRepository = borrowRepository;
    }

    public Borrow createBorrow(BorrowDTO data) {
        var borrow = new Borrow(data.client(), data.books());
        return borrowRepository.save(borrow);
    }

    public Borrow getBorrowByClient(String id){
        var borrow = borrowRepository.getBorrowByClientId(id);
        return Optional.ofNullable(borrow).orElseThrow(BorrowNotFoundException::new);
    }

    public Borrow addBook(String clientId, Book book){
        Borrow borrow = getBorrowByClient(clientId);
        borrow.addBook(book);
        return borrowRepository.save(borrow);
    }

    public Borrow removeBook(String clientId, Book book){
        Borrow borrow = getBorrowByClient(clientId);
        borrow.removeBook(book);
        return borrowRepository.save(borrow);
    }

    public void deleteBorrow(String id){
        if (!existsById(id)){
            throw new BorrowNotFoundException();
        }
        borrowRepository.deleteById(id);
    }

    public boolean existsById(String id){
        return borrowRepository.existsById(id);
    }
}
