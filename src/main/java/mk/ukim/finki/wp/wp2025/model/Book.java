package mk.ukim.finki.wp.wp2025.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    private Author author;
    private Long id;
    private String title;
    private String genre;
    private Double averageRating;

    public Book(String title, String genre, Double averageRating, Author author) {
        this.title = title;
        this.genre = genre;
        this.averageRating = averageRating;
        this.author = author;
    }

}
