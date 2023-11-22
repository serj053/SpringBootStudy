package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Storage {
    static int currentId = 1;
    static HashMap<Integer, Book> books = new HashMap<Integer, Book>();
    public static List<Book> getAllBook(){
        ArrayList<Book> list = new ArrayList<>();
        list.addAll(books.values());
        return list;
    }
    public static int addBook(Book book){
        int id = currentId++;
        book.setId(id);
        books.put(id, book);
        return id;
    }
}
