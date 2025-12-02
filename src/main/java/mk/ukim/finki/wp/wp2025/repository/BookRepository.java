package mk.ukim.finki.wp.wp2025.repository;

import mk.ukim.finki.wp.wp2025.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByAuthor_Id(Long authorId);

    List<Book> findAllByTitleAndAverageRating(String title, double rating);
}