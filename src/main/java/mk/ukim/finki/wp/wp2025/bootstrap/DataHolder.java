package mk.ukim.finki.wp.wp2025.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.wp2025.model.Author;
import mk.ukim.finki.wp.wp2025.model.Book;
import mk.ukim.finki.wp.wp2025.model.BookReservation;
import mk.ukim.finki.wp.wp2025.service.AuthorService;
import mk.ukim.finki.wp.wp2025.service.BookService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class DataHolder {
    private final AuthorService authorService;
    private final BookService bookService;
    public static Long nextBookId = 1L;
    public static List<Book> books = null;
    public static List<BookReservation> bookReservations = null;
    public static List<Author> authors = null;

    public DataHolder(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

//    @PostConstruct
    public void init() {
        if (authorService.count() > 0 && bookService.count() > 0) {
            return;
        }
        authors = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
//            authors.add(new Author(String.valueOf(i), String.valueOf(i), String.valueOf(i), String.valueOf(i)));
            Author author = new Author(String.valueOf(i), String.valueOf(i), String.valueOf(i), String.valueOf(i));
            authorService.addAuthor(author);
            authors.add(author);
        }
        books = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
//            Book book = new Book("title "+ i, "genre " + i, (double) i, authors.get(i%3));
//            books.add(book);
            Book book = new Book("title " + i, "genre " + i, (double) i, authors.get(i % 3));
            bookService.addBook(book);
        }
        bookReservations = new ArrayList<>();
    }
}
