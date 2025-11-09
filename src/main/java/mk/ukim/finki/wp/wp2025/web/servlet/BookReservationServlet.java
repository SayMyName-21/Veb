package mk.ukim.finki.wp.wp2025.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.wp2025.service.BookReservationService;
import mk.ukim.finki.wp.wp2025.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;


@WebServlet(name = "BookReservationServlet", urlPatterns = "/bookReservation")
@Component
public class BookReservationServlet extends HttpServlet {
    private final BookReservationService bookReservationService;

    @Autowired
    public BookReservationServlet(final BookReservationService bookReservationService) {
        this.bookReservationService = bookReservationService;
    }

    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(req.getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);
//        templateEngine.process("listBooks.html", context, resp.getWriter());

    }
}
