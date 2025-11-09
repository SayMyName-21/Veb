package mk.ukim.finki.wp.wp2025.repository.impl;

import mk.ukim.finki.wp.wp2025.bootstrap.DataHolder;
import mk.ukim.finki.wp.wp2025.model.BookReservation;
import mk.ukim.finki.wp.wp2025.repository.BookReservationRepository;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryBookReservationRepository implements BookReservationRepository {
    @Override
    public BookReservation save(BookReservation bookReservation) {
        DataHolder.bookReservations.add(bookReservation);
        return bookReservation;
    }
}
