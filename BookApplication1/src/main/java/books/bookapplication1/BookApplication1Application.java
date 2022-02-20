package books.bookapplication1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class BookApplication1Application {

    public static void main(String[] args) {
        SpringApplication.run(BookApplication1Application.class, args);
    }

}
