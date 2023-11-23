package main;

import main.model.Book;
import main.model.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    ;

    @PostMapping("/books/")
    public int saveBook(Book book) {
        Book newBook = bookRepository.save(book);
        Logger.getLogger(BookController.class.getName()).info("*** " + book.toString());
        Storage.addBook(book);
        return newBook.getId();
    }

    @GetMapping("/books/")
    public List<Book> gatAllBook() {
        Iterable<Book> booksIterable = bookRepository.findAll();
        ArrayList<Book> books = new ArrayList<>();
        for (Book book : booksIterable) {
            books.add(book);
        }
        return books;//получаем из базы данных
        //return Storage.getAllBook();//получаем из коллекции(оперативной памяти
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable int id) {
        return Storage.getBook(id);
    }
}
