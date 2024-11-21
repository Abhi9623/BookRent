package com.example.RentBook.Controller;

import com.example.RentBook.Enums.Availibility;
import com.example.RentBook.Models.Book;
import com.example.RentBook.Repository.BookRepository;
import com.example.RentBook.Serrvices.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminServices adminServices;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/books")
    public ResponseEntity<Book> Addbook(@RequestBody Book book){
        return  adminServices.Addbook(book);
    }
}
