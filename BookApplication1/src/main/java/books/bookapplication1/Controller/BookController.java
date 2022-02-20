package books.bookapplication1.Controller;

import books.bookapplication1.Model.Book;
import books.bookapplication1.Service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("book/{isbn}")
    public ResponseEntity<?> getBook(@PathVariable String isbn) throws JsonProcessingException {
        return new ResponseEntity<>(bookService.getBook(isbn), HttpStatus.OK);
    }

    @PostMapping("book")
    public ResponseEntity<?> addBook(@RequestBody Book book) throws JsonProcessingException {
        return new ResponseEntity<>(bookService.addBook(book), HttpStatus.CREATED);
    }

    @PutMapping("book")
    public ResponseEntity<?> updateBook(@RequestBody Book book) throws JsonProcessingException {
        return new ResponseEntity<>(bookService.updateBook(book), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("book/{isbn}")
    public ResponseEntity<?> deleteBook(@PathVariable String isbn) throws JsonProcessingException {
        return new ResponseEntity<>(bookService.deleteBook(isbn), HttpStatus.OK);
    }

    @GetMapping("books")
    public ResponseEntity<?> getAllBooks() throws JsonProcessingException {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }
}
