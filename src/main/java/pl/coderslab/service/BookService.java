package pl.coderslab.service;

import pl.coderslab.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book getBookById(long id);

    Book saveBook(Book book);

    Book updateBook(long id,Book book);

    void deleteBook(long id);
}
