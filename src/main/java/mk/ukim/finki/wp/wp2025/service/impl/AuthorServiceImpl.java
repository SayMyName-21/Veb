package mk.ukim.finki.wp.wp2025.service.impl;

import jakarta.transaction.Transactional;
import mk.ukim.finki.wp.wp2025.model.Author;
import mk.ukim.finki.wp.wp2025.repository.AuthorRepository;
import mk.ukim.finki.wp.wp2025.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
@Transactional
@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findAuthorById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public long count() {
        return authorRepository.count();
    }
}
