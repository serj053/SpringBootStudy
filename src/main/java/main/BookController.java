package main;

import main.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class BookController {
    ;
    @PostMapping("/books/")
    public int saveBook(Book book){
        Logger.getLogger(BookController.class.getName()).info("*** "+book.toString());
        return Storage.addBook(book);
    }
    @GetMapping("/books/")
    public List<Book> gatAllBook(){
        return Storage.getAllBook();
    }
    public Book getBook(){
        return null;
    }
}
