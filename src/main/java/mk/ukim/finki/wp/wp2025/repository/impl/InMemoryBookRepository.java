//package mk.ukim.finki.wp.wp2025.repository.impl;
//
//import mk.ukim.finki.wp.wp2025.bootstrap.DataHolder;
//import mk.ukim.finki.wp.wp2025.model.Book;
//import mk.ukim.finki.wp.wp2025.repository.BookRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Objects;
//
//@Repository
//public class InMemoryBookRepository implements BookRepository {
//    @Override
//    public void delete(Long Id) {
//        DataHolder.books = DataHolder.books.stream().filter(b -> !Objects.equals(b.getId(), Id)).toList();
//    }
//
//    @Override
//    public void edit(Long id, Book book) {
//        DataHolder.books.removeIf(b -> Objects.equals(b.getId(), id));
//        book.setId(id); //za sekoj slucaj
//        DataHolder.books.add(book);
//    }
//
//    @Override
//    public void save(Book book) {
//        book.setId(DataHolder.nextBookId++);
//        DataHolder.books.add(book);
//    }
//    @Override
//    public List<Book> findAll() {
//        return DataHolder.books;
//    }
//
//    @Override
//    public List<Book> searchBooks(String text, Double rating) {
//        return DataHolder.books.stream()
//                .filter(b -> b.getTitle().contains(text) &&
//                        b.getAverageRating() > rating)
//                .toList();
//    }
//
//    @Override
//    public Book findById(long id) {
//        return DataHolder.books.stream()
//                .filter(b -> b.getId().equals(id)).findFirst().orElse(null);
//    }
//}
