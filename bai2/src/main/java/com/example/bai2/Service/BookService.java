package com.example.bai2.Service;

import com.example.bai2.Model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>();

    public BookService() {

    }

    // GET all
    public List<Book> getAllBooks() {
        return books;
    }

    // GET by id
    public Book getBookById(int id) {
        for (Book b : books) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    // POST - add
    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    public Book updateBook(int id, Book newBook) {
        for (Book b : books) {
            if (b.getId() == id) {
                b.setTitle(newBook.getTitle());
                b.setAuthor(newBook.getAuthor());
                b.setCategory(newBook.getCategory());
                b.setPrice(newBook.getPrice());
                return b;
            }
        }
        return null;
    }

    // DELETE
    public boolean deleteBook(int id) {
        return books.removeIf(b -> b.getId() == id);
    }
}