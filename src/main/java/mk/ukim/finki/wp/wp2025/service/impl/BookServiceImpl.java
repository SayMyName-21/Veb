package mk.ukim.finki.wp.wp2025.service.impl;

import jakarta.transaction.Transactional;
import mk.ukim.finki.wp.wp2025.model.Book;
import mk.ukim.finki.wp.wp2025.repository.BookRepository;
import mk.ukim.finki.wp.wp2025.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
@Transactional
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void deleteBook(Long Id) {
        bookRepository.delete(findBookById(Id));
    }

    @Override
    public void editBook(Long id, Book updatedBook) {
        Book book = bookRepository.findById(id)
                .orElse(null);
        assert book != null;
        book.setTitle(updatedBook.getTitle());
        book.setGenre(updatedBook.getGenre());
        book.setAverageRating(updatedBook.getAverageRating());
        book.setAuthor(updatedBook.getAuthor());

        bookRepository.save(book);
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
    public List<Book> searchBooks(String title, Double rating) {
        return this.bookRepository.findAllByTitleAndAverageRating(title, rating);
    }

    @Override
    public Book findBookById(long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public long count() {
        return bookRepository.count();
    }
}
