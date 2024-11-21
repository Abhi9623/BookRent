package com.example.RentBook.Exceptions;

public class BookNotfound  extends  RuntimeException{

    public BookNotfound(){
        super();
    }
    public BookNotfound(String messgae){
        super(messgae);
    }
}
