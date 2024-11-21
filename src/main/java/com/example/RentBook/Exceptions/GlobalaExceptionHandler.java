package com.example.RentBook.Exceptions;


import com.example.RentBook.Util.ErrorResponsedf;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalaExceptionHandler {


    @ExceptionHandler(BookNotfound.class)
    public ResponseEntity<ErrorResponsedf> booknotfound(BookNotfound ex, WebRequest webRequest) {

        ErrorResponsedf errorResponse = new ErrorResponsedf(
                LocalDateTime.now(), ex.getMessage(),
                webRequest.getDescription(false)

        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(UserNotfound.class)
    public ResponseEntity<ErrorResponsedf> usernotfound(UserNotfound ex, WebRequest webRequest) {

        ErrorResponsedf errorResponse = new ErrorResponsedf(
                LocalDateTime.now(), ex.getMessage(),
                webRequest.getDescription(false)

        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookCanNotbeGiven.class)
    public ResponseEntity<ErrorResponsedf> Bookcannotbegiven(BookCanNotbeGiven ex, WebRequest webRequest) {

        ErrorResponsedf errorResponse = new ErrorResponsedf(
                LocalDateTime.now(), ex.getMessage(),
                webRequest.getDescription(false)

        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(Nobbokstoreturn.class)
    public ResponseEntity<ErrorResponsedf> nobookstoreturn(Nobbokstoreturn ex, WebRequest webRequest) {

        ErrorResponsedf errorResponse = new ErrorResponsedf(
                LocalDateTime.now(), ex.getMessage(),
                webRequest.getDescription(false)

        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_ACCEPTABLE);
    }

}
