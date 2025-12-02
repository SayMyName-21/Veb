package mk.ukim.finki.wp.wp2025.web.controller;

import mk.ukim.finki.wp.wp2025.model.Author;
import mk.ukim.finki.wp.wp2025.model.Book;
import mk.ukim.finki.wp.wp2025.service.AuthorService;
import mk.ukim.finki.wp.wp2025.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping
    public String getBooksPage(@RequestParam(required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", error);
        }
        List<Book> books = bookService.listAll();
        ;
        List<Author> authors = authorService.findAll();
        model.addAttribute("books", books);
        model.addAttribute("authors", authors);
        return "listBooks";
    }

    @GetMapping("/book-form/{id}")
    public String getEditBookForm(@PathVariable Long id, Model model) {
        model.addAttribute("authors", authorService.findAll());
        model.addAttribute("selectedBook", bookService.findBookById(id));
        return "book-form";
    }

    @GetMapping("/book-form")
    public String getAddBookPage(Model model) {
        model.addAttribute("authors", authorService.findAll());
        model.addAttribute("books", bookService.listAll());
        return "book-form";
    }


    @PostMapping("/add")
    public String saveBook(Model model,
                           @RequestParam String bookTitle,
                           @RequestParam String genre,
                           @RequestParam Double averageRating,
                           @RequestParam Long authorId) {
        Author author = authorService.findAll().stream().filter(a -> Objects.equals(a.getId(), authorId)).findFirst().orElse(null);
        bookService.addBook(new Book(bookTitle, genre, averageRating, author));
        return "redirect:/books";
    }

    @PostMapping("/edit/{bookId}")
    public String editBook(@PathVariable Long bookId,
                           @RequestParam String bookTitle,
                           @RequestParam String genre,
                           @RequestParam Double averageRating,
                           @RequestParam Long authorId) {
        Author author = authorService.findAll().stream().filter(a -> Objects.equals(a.getId(), authorId)).findFirst().orElse(null);
        bookService.editBook(bookId, new Book(bookTitle, genre, averageRating, author));
        return "redirect:/books";
    }

    @PostMapping("/delete/{bookId}")
    public String deleteBook(Model model,
                             @PathVariable Long bookId) {
        bookService.deleteBook(bookId);
        return "redirect:/books";
    }
}
