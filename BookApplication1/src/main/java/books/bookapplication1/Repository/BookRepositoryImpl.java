package books.bookapplication1.Repository;

import books.bookapplication1.Model.Book;
import books.bookapplication1.Model.Books;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private Map<String, Book> bookMap;

    public BookRepositoryImpl() {
        this.bookMap = new HashMap<>();
    }

    @Override
    public Book addBook(Book book) {
        return bookMap.put(book.getIsbn(),book);
    }

    @Override
    public Book updateBook(Book book) {
        Book book1 = bookMap.get(book.getIsbn());
        bookMap.remove(book1);
        book1.setAuthor(book.getAuthor());
        book1.setPrice(book.getPrice());
        book1.setTitle(book.getTitle());
        return bookMap.put(book1.getIsbn(),book1);
    }

    @Override
    public Book deleteBook(String isbn) {
        Book book1 = bookMap.get(isbn);
        if(book1 != null){
            bookMap.remove(book1);
            return book1;
        }
        return Book.builder().build();
    }

    @Override
    public Book getBook(String isbn) {
        Book book = bookMap.get(isbn);
        if (book != null){
            return book;
        }
        return Book.builder().build();
    }

    @Override
    public Books getAllBooks() {
        return  Books.builder()
                .books(bookMap.values().stream().collect(Collectors.toList()))
                .build();
    }
}
