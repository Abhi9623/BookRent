package com.example.RentBook.Repository;

import com.example.RentBook.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository  extends MongoRepository<User,String> {

    User findByEmail(String email);
}
