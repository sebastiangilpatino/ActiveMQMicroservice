package books.bookapplication1.Service;

import books.bookapplication1.Model.Book;
import books.bookapplication1.Model.Books;
import books.bookapplication1.Repository.BookRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Book addBook(Book book) throws JsonProcessingException {
        String bookString = objectMapper.writeValueAsString(book);
        jmsTemplate.convertAndSend("testQueue",bookString);
        return bookRepository.addBook(book);
    }

    @Override
    public Book updateBook(Book book) throws JsonProcessingException {
        String bookString = objectMapper.writeValueAsString(book);
        jmsTemplate.convertAndSend("testQueue",bookString);
        return bookRepository.updateBook(book);
    }

    @Override
    public Book deleteBook(String isbn) throws JsonProcessingException {
        Book book = bookRepository.getBook(isbn);
        String bookString = objectMapper.writeValueAsString(book);
        jmsTemplate.convertAndSend("testQueue",bookString);
        return bookRepository.deleteBook(isbn);
    }

    @Override
    public Book getBook(String isbn) throws JsonProcessingException {
        Book book = bookRepository.getBook(isbn);
        String bookString = objectMapper.writeValueAsString(book);
        jmsTemplate.convertAndSend("testQueue",bookString);
        return book;
    }

    @Override
    public Books getAllBooks() {
        return bookRepository.getAllBooks();
    }
}
