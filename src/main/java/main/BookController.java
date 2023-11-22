package main;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @PostMapping("/books/")
    public int saveBook(Book book){
        return Storage.addBook(book);
    }
}
