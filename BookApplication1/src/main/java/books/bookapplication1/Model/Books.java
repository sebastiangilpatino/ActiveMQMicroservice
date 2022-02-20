package books.bookapplication1.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Books {
    private List<Book> books;

    @Override
    public String toString() {
        return "Books{ " + books + "}";
    }
}
