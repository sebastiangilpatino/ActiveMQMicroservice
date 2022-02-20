package books.bookapplication1.Repository;

import books.bookapplication1.Model.Book;
import books.bookapplication1.Model.Books;

import java.util.List;

public interface BookRepository {
    Book addBook(Book book);
    Book updateBook(Book book);
    Book deleteBook(String isbn);
    Book getBook(String isbn);
    Books getAllBooks();
}
