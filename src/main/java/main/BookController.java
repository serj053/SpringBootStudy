package main;

import main.model.Book;
import main.model.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    ;
    @PostMapping("/books/")
    public int saveBook(Book book){
        Book newBook = bookRepository.save(book);
        Logger.getLogger(BookController.class.getName()).info("*** "+book.toString());
        Storage.addBook(book);
        return newBook.getId();
    }
    @GetMapping("/books/")
    public List<Book> gatAllBook(){
        return Storage.getAllBook();
    }
    public Book getBook(){
        return null;
    }
}
