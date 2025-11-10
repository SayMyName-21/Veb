package mk.ukim.finki.wp.wp2025.repository;


import mk.ukim.finki.wp.wp2025.model.Book;

import java.util.List;

public interface BookRepository {
    void delete(Long Id);
    void edit(Long Id, Book book);
    void save(Book book);
    List<Book> findAll();
    List<Book> searchBooks(String text, Double rating);
}
