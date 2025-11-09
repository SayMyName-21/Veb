package mk.ukim.finki.wp.wp2025.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.wp2025.model.Book;
import mk.ukim.finki.wp.wp2025.model.BookReservation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Book> books = null;
    public static List<BookReservation> bookReservations = null;

    @PostConstruct
    public void init(){
        books = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            books.add(new Book(String.valueOf(i), String.valueOf(i), (double) i));
        }

        bookReservations = new ArrayList<>();
    }
}
