package mk.ukim.finki.wp.wp2025.service.impl;

import mk.ukim.finki.wp.wp2025.model.Author;
import mk.ukim.finki.wp.wp2025.repository.AuthorRepository;
import mk.ukim.finki.wp.wp2025.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }
}
