package com.example.bookclient1;

import com.example.bookclient1.model.Book;
import com.example.bookclient1.model.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BookClient1Application implements CommandLineRunner {

    @Autowired
    private RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(BookClient1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String serverUrl = "http://localhost:8080/api/";

        // add Book
        restTemplate.postForLocation(serverUrl + "book",
                Book.builder()
                        .isbn("ABC")
                        .author("JK Rowling")
                        .price(120)
                        .title("Harry Potter")
                        .build());
        // add Book
        restTemplate.postForLocation(serverUrl + "book",
                Book.builder()
                        .isbn("DEF")
                        .author("JK Rowling")
                        .price(120)
                        .title("Harry Potter 2")
                        .build());

        // get book ABC
        Book book = restTemplate.getForObject(serverUrl + "/book/{isbn}", Book.class, "ABC");

        System.out.println("----------- get ABC-----------------------");
        System.out.println(book);

        // get all
        Books books = restTemplate.getForObject(serverUrl + "/books", Books.class);
        System.out.println("----------- get all Books-----------------------");
        System.out.println(books);

        // delete DEF
        restTemplate.delete(serverUrl + "/book/{isbn}", "DEF");

        // update ABC
        book.setTitle("Fenix order");
        restTemplate.put(serverUrl + "book", book);

        // get all
        books = restTemplate.getForObject(serverUrl + "/books", Books.class);
        System.out.println("----------- get all contacts-----------------------");
        System.out.println(books);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
