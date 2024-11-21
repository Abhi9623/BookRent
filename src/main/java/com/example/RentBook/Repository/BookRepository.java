package com.example.RentBook.Repository;

import com.example.RentBook.Models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository  extends MongoRepository<Book,String> {
}
