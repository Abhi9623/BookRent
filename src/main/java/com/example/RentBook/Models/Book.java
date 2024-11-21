package com.example.RentBook.Models;


import com.example.RentBook.Enums.Availibility;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "Books")
public class Book {



    @Id
    private  String id;
    private String title;
    private String author;
    private String genre;
    private Availibility availibility;

}
