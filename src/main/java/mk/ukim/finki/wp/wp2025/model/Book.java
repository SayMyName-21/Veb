package mk.ukim.finki.wp.wp2025.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    private String title;
    private String genre;
    private Double averageRating;

    public Book(String title, String genre, Double averageRating) {
        this.title = title;
        this.genre = genre;
        this.averageRating = averageRating;
    }
}
