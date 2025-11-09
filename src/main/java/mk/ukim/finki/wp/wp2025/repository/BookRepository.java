package mk.ukim.finki.wp.wp2025.repository;


import mk.ukim.finki.wp.wp2025.model.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAll();
    List<Book> searchBooks(String text, Double rating);
}
