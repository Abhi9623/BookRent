package com.example.RentBook.Controller;


import com.example.RentBook.Models.User;
import com.example.RentBook.Serrvices.UserServiceApp;
import com.example.RentBook.Util.LoginBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserServiceApp  userServiceApp;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user){
        return  userServiceApp.Register(user);
    }

    @PostMapping("/login")
    public  ResponseEntity<String> login(@RequestBody LoginBody loginBody){
        return  userServiceApp.login(loginBody);
    }

}
