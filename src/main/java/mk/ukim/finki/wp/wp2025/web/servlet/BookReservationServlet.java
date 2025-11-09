package mk.ukim.finki.wp.wp2025.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.wp2025.model.BookReservation;
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
    private final SpringTemplateEngine templateEngine;

    @Autowired
    public BookReservationServlet(final BookReservationService bookReservationService, SpringTemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
        this.bookReservationService = bookReservationService;
    }

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(req.getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);
        context.setVariable("bookTitle", req.getSession().getAttribute("bookTitle"));
        context.setVariable("readerName", req.getSession().getAttribute("readerName"));
        context.setVariable("readerAddress", req.getSession().getAttribute("readerAddress"));
        context.setVariable("numCopies", req.getSession().getAttribute("numCopies"));
        context.setVariable("IPAddress", req.getRemoteAddr());
        context.setVariable("bookReservationService", bookReservationService);

        try {
            templateEngine.process("reservationConfirmation.html", context, resp.getWriter());
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("Template error: " + e.getMessage());
        }    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String bookTitle = req.getParameter("bookTitle");
        String readerName = req.getParameter("readerName");
        String readerAddress = req.getParameter("readerAddress");

        int numCopies = 1;
        try {
            numCopies = Integer.parseInt(req.getParameter("numCopies"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            resp.sendRedirect("/?errorMessage=Invalid number of copies");
            return;
        }
        BookReservation reservation = bookReservationService.placeReservation(
                bookTitle, readerName, readerAddress, numCopies
        );


        HttpSession session = req.getSession();
        session.setAttribute("bookTitle", bookTitle);
        session.setAttribute("readerName", readerName);
        session.setAttribute("readerAddress", readerAddress);
        session.setAttribute("numCopies", numCopies);

        resp.sendRedirect("/bookReservation");
    }
}

