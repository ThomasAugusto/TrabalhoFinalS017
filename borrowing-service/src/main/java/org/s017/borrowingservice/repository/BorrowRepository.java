package org.s017.borrowingservice.repository;

import org.s017.borrowingservice.entity.Borrow;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRepository extends MongoRepository<Borrow, String> {
    Borrow getBorrowByClientId(String clientId);
}
