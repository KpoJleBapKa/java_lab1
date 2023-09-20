package com.kroll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class LibraryTest {
    private Library library;

    @BeforeEach
    public void setUp() {
        library = new Library();
    }

    @Test
    public void testAddBook() {
        Book book = new Book("Книга 1", "Автор 1", "ISBN1", 2023);
        library.addBook(book);
        assertTrue(library.getBooks().contains(book));
    }

    @Test
    public void testRemoveBookByIsbn() {
        Book book1 = new Book("Книга 1", "Автор 1", "ISBN1", 2005);
        Book book2 = new Book("Книга 2", "Автор 2", "ISBN2", 2019);
        library.addBook(book1);
        library.addBook(book2);
        library.removeBookByIsbn("ISBN1");
        assertFalse(library.getBooks().contains(book1));
        assertTrue(library.getBooks().contains(book2));
    }
}
