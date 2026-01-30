package com.example.bai2.Controller;

import com.example.bai2.Model.Book;
import com.example.bai2.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // GET all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // GET book by id
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    // POST add book
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    // DELETE book
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        boolean deleted = bookService.deleteBook(id);
        return deleted ? "Deleted successfully" : "Book not found";
    }
}