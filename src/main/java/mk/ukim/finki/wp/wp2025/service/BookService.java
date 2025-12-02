package mk.ukim.finki.wp.wp2025.service;

import mk.ukim.finki.wp.wp2025.model.Book;

import java.util.List;

public interface BookService {
    void deleteBook(Long Id);
    void editBook(Long Id, Book book);
    void addBook(Book book);
    List<Book> listAll();
    List<Book> searchBooks(String text, Double rating);
    Book findBookById(long id);
    long count();
}
