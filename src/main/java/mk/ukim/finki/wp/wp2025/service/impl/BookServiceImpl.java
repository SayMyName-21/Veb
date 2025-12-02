package mk.ukim.finki.wp.wp2025.service.impl;

import mk.ukim.finki.wp.wp2025.model.Book;
import mk.ukim.finki.wp.wp2025.repository.BookRepository;
import mk.ukim.finki.wp.wp2025.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Override
    public void deleteBook(Long Id)
    {
        bookRepository.delete(Id);
    }
    @Override
    public void editBook(Long Id, Book book) {
        bookRepository.edit(Id, book);
    }
    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> searchBooks(String text, Double rating) {
        return this.bookRepository.searchBooks(text, rating);
    }

    @Override
    public Book findBookById(long id) {
        return bookRepository.findById(id);
    }
}
