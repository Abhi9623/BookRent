package com.example.RentBook.Serrvices;


import com.example.RentBook.Exceptions.BookCanNotbeGiven;
import com.example.RentBook.Exceptions.BookNotfound;
import com.example.RentBook.Exceptions.Nobbokstoreturn;
import com.example.RentBook.Exceptions.UserNotfound;
import com.example.RentBook.Models.Book;
import com.example.RentBook.Models.User;
import com.example.RentBook.Repository.BookRepository;
import com.example.RentBook.Repository.UserRepository;
import com.example.RentBook.Util.RentBookId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServices {

    @Autowired
     private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<Book> RentBook(RentBookId rentBookId){
        Optional<User> userOptional=userRepository.findById(rentBookId.getUserid());
        Optional<Book> bookOptional=bookRepository.findById(rentBookId.getBookid());

        if(bookOptional.isEmpty()){
           throw new BookNotfound("book not there");
        }

        if(userOptional.isEmpty()){
            throw new UserNotfound("UserNotFound");
        }


        User user=userOptional.get();
        Book book=bookOptional.get();


        if(user.getBookList().size()>=2){
            throw  new BookCanNotbeGiven("Alrady 2 books are rented <Please retrun one of them and checkout this book");
        }


        user.getBookList().add(book);

        userRepository.save(user);

        return  ResponseEntity.ok(book);
    }


    public ResponseEntity<Book> ReturnBook(RentBookId rentBookId){
        Optional<User> userOptional=userRepository.findById(rentBookId.getUserid());
        Optional<Book> bookOptional=bookRepository.findById(rentBookId.getBookid());

        if(bookOptional.isEmpty()){
            throw new BookNotfound("book not there");
        }

        if(userOptional.isEmpty()){
            throw new UserNotfound("UserNotFound");
        }


        User user=userOptional.get();
        Book book=bookOptional.get();

        if(user.getBookList().size()==0){
            throw new Nobbokstoreturn("There are no books to return");
        }


        user.getBookList().remove(book);

        userRepository.save(user);

        return  ResponseEntity.ok(book);
    }
}
