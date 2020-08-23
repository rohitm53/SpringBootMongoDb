package com.rohit.mongo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Document(collection = "Book")
public class Book implements Serializable {

    @Id
    private int id;
    private String bookName;
    private String authorName;

}
