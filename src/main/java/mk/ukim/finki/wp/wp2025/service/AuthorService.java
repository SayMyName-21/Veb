package mk.ukim.finki.wp.wp2025.service;

import mk.ukim.finki.wp.wp2025.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();
    Author findAuthorById(Long id);
    void addAuthor(Author author);
    long count();
}
