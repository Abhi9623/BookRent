package com.example.RentBook.Exceptions;


public class BookCanNotbeGiven extends  RuntimeException {

    public  BookCanNotbeGiven(){
        super();
    }

    public  BookCanNotbeGiven(String message){
        super(message);
    }
}
