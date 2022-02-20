package books.bookapplication1.Service;

import books.bookapplication1.Model.Book;
import books.bookapplication1.Model.Books;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface BookService {
    Book addBook(Book book) throws JsonProcessingException;
    Book updateBook(Book book) throws JsonProcessingException;
    Book deleteBook(String isbn) throws JsonProcessingException;
    Book getBook(String isbn) throws JsonProcessingException;
    Books getAllBooks() throws JsonProcessingException;
}
