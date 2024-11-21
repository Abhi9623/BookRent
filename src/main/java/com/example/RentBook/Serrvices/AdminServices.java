package com.example.RentBook.Serrvices;

import com.example.RentBook.Enums.Availibility;
import com.example.RentBook.Models.Book;
import com.example.RentBook.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminServices {

    @Autowired
    private BookRepository bookRepository;
    public ResponseEntity<Book> Addbook(Book book){

        if(book.getAvailibility()==null){
            book.setAvailibility(Availibility.AVILABLE);
        }

        Book book1=Book.builder().title(book.getTitle()).genre(book.getGenre())
                .author(book.getAuthor()).availibility(book.getAvailibility()).build();

        bookRepository.save(book1);
        return ResponseEntity.ok(book1);
    }
}
