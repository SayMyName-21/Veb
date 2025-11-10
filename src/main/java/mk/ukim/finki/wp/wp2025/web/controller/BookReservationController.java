package mk.ukim.finki.wp.wp2025.web.controller;

import mk.ukim.finki.wp.wp2025.service.BookReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookReservation")
public class BookReservationController {
    private final BookReservationService bookReservationService;
    public BookReservationController(BookReservationService bookReservationService)
    {
        this.bookReservationService = bookReservationService;
    }

    @GetMapping("/")
    public String getReservationForm(){
        return "reservationConfirmation";
    }
}
