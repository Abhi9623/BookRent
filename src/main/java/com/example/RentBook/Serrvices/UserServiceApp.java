package com.example.RentBook.Serrvices;

import com.example.RentBook.Enums.Roles;
import com.example.RentBook.Models.User;
import com.example.RentBook.Repository.UserRepository;
import com.example.RentBook.Util.LoginBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceApp {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public ResponseEntity<String> Register(User user){

        if(user.getRoles()==null){
            user.setRoles(Roles.USER);
        }

        User user1= User.builder().name(user.getName()).email(user.getEmail()).
                password(passwordEncoder.encode(user.getPassword())).roles(user.getRoles()).
                bookList(new ArrayList<>()).build();

        userRepository.save(user1);

        return  ResponseEntity.ok("USer Registered Succesfully");
    }


    public  ResponseEntity<String> login(LoginBody loginBody){
        authenticationManager.
                authenticate(new UsernamePasswordAuthenticationToken(loginBody.getEmail(),loginBody.getPassword()));

        return  ResponseEntity.ok("Login Succesfully");
    }
}
