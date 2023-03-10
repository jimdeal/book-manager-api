package com.techreturners.bookmanager.repository;

import com.techreturners.bookmanager.model.Book;
import com.techreturners.bookmanager.model.Genre;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BookManagerRepositoryTests {

    @Autowired
    private BookManagerRepository bookManagerRepository;

    @Test
    public void testFindAllBooksReturnsBooks() {

        Book book = new Book(1L, "Book One", "This is the description for Book One", "Person One", Genre.Education);
        bookManagerRepository.save(book);

        Iterable<Book> books = bookManagerRepository.findAll();
        assertThat(books).hasSize(1);

    }

    @Test
    public void testCreatesAndFindBookByIdReturnsBook() {

        Book book = new Book(1L, "Book Two", "This is the description for Book Two", "Person Two", Genre.Fantasy);
        bookManagerRepository.save(book);

        Iterable<Book> books = bookManagerRepository.findAll();
        assertThat(books).hasSize(1);
// debug - try & find out whats going on with Id's
//        System.out.println("testCreatesAndFindBookByIdReturnsBook");
//        System.out.println(book.getId());

        var bookById = bookManagerRepository.findById(book.getId());
        assertThat(bookById).isNotNull();

    }

    @Test
    public void testCreateAndDeleteBookCheckByFindId() {

        Book book = new Book(3L, "Book Three", "This is the description for Book Three", "Person Three", Genre.Fantasy);
        bookManagerRepository.save(book);

        var bookById = bookManagerRepository.findById(book.getId());
        assertThat(bookById).isNotNull();

        Iterable<Book> books = bookManagerRepository.findAll();
        assertThat(books).hasSize(1);

// debug - try & find out whats going on with Id's
//        Long id = 0L;
//        System.out.println("testCreateAndDeleteBookCheckByFindId");
//        System.out.println(book.getId());
//        for (Book b: books) {
//            System.out.println(b.getId());
//            id = b.getId();
//        }

        bookManagerRepository.deleteById(book.getId());
        var deletedBook = bookManagerRepository.findById(book.getId());
        assert(deletedBook.equals(Optional.empty()));
    }

}
