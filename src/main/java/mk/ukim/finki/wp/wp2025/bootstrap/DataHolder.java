package mk.ukim.finki.wp.wp2025.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.wp2025.model.Author;
import mk.ukim.finki.wp.wp2025.model.Book;
import mk.ukim.finki.wp.wp2025.model.BookReservation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;



@Component
public class DataHolder {
    public static Long nextBookId = 1L;
    public static List<Book> books = null;
    public static List<BookReservation> bookReservations = null;
    public static List<Author> authors = null;

    @PostConstruct
    public void init() {
        authors = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            authors.add(new Author(String.valueOf(i), String.valueOf(i), String.valueOf(i), String.valueOf(i)));
        }
        books = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Book book = new Book("title "+ i, "genre " + i, (double) i, authors.get(i%3));
            book.setId(nextBookId++);
            books.add(book);
        }
        bookReservations = new ArrayList<>();
    }
}
