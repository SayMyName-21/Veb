package mk.ukim.finki.wp.wp2025.repository.impl;

import mk.ukim.finki.wp.wp2025.bootstrap.DataHolder;
import mk.ukim.finki.wp.wp2025.model.Book;
import mk.ukim.finki.wp.wp2025.repository.BookRepository;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;

@Repository
public class InMemoryBookRepository implements BookRepository {
    @Override
    public void delete(Long Id){
        DataHolder.books = DataHolder.books.stream().filter(b -> b.getId() != Id).toList();
    }
    @Override
    public void edit(Long Id, Book book) {
        DataHolder.books.stream().filter(b -> b.getId() != Id);
        DataHolder.books.add(book);
    }
    @Override
    public void save(Book book) {
        DataHolder.books.add(book);
    }
    @Override
    public List<Book> findAll() {
        return DataHolder.books;
    }

    @Override
    public List<Book> searchBooks(String text, Double rating) {
        return DataHolder.books.stream()
                .filter(b -> b.getTitle().contains(text) &&
                        b.getAverageRating() > rating)
                .toList();
    }
}
