package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.service.BookService;
import pl.coderslab.service.MemoryBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> books() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable long id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    public Book adBook(@RequestBody Book book) {
        Book saveBook=bookService.saveBook(book);
        return saveBook;
    }
    @DeleteMapping("/{id}")
    public List<Book> deleteBookById(@PathVariable long id) {
        bookService.deleteBook(id);
        return bookService.getAllBooks();
    }
    @PutMapping("/id")
    public Book updateBookById(@PathVariable long id, @RequestBody Book book){
        Book updatedBook=bookService.updateBook(id, book);
        return updatedBook;
    }
}

