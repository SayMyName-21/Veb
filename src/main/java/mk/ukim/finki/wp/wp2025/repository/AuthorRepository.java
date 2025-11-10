package mk.ukim.finki.wp.wp2025.repository;

import mk.ukim.finki.wp.wp2025.model.Author;

import java.util.List;

public interface AuthorRepository {
    public List<Author> findAll();
}
