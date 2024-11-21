package com.example.RentBook.Exceptions;

public class UserNotfound extends RuntimeException {

    public  UserNotfound(){
        super();
    }

    public  UserNotfound(String message){
        super(message);
    }

}
