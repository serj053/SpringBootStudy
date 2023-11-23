package main;

import main.model.Book;
import main.model.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    public ResponseEntity getBook(@PathVariable int id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(!bookOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(bookOptional.get(), HttpStatus.OK);
       // return Storage.getBook(id);
    }
@DeleteMapping("/books/{id}")
    public Boolean delete(@PathVariable int id){
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()){
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
