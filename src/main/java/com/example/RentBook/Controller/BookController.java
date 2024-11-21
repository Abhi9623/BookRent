package com.example.RentBook.Controller;


import com.example.RentBook.Exceptions.BookNotfound;
import com.example.RentBook.Models.Book;
import com.example.RentBook.Repository.BookRepository;
import com.example.RentBook.Serrvices.BookServices;
import com.example.RentBook.Util.RentBookId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/book")
public class BookController {


    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookServices bookServices;

    @PostMapping("/rent")
    public ResponseEntity<Book> RentBooks(@RequestBody RentBookId rentBookId){
        return bookServices.RentBook(rentBookId);
    }

    @PostMapping("/return")
    public ResponseEntity<Book> ReturnBooks(@RequestBody RentBookId rentBookId){
        return bookServices.ReturnBook(rentBookId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable String id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isEmpty()) {
            throw new BookNotfound("Book not found with ID: " + id);
        }
        return ResponseEntity.ok(book.get());
    }

}
