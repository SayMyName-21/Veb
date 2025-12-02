package mk.ukim.finki.wp.wp2025.repository;

import mk.ukim.finki.wp.wp2025.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
