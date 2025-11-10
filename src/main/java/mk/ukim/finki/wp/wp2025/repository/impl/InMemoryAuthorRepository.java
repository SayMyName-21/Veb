package mk.ukim.finki.wp.wp2025.repository.impl;

import mk.ukim.finki.wp.wp2025.bootstrap.DataHolder;
import mk.ukim.finki.wp.wp2025.model.Author;
import mk.ukim.finki.wp.wp2025.repository.AuthorRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryAuthorRepository implements AuthorRepository {
    @Override
    public List<Author> findAll() {
        return DataHolder.authors;
    }
}
