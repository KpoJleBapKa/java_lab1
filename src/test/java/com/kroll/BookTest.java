package com.kroll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class BookTest {
    Book book;
    @BeforeEach
    void setup() {
        this.book = new Book("Книга 1", "Автор 1", "ISBN1", 2020);
    }
    @Test
    void testBookConstructor() {
        assertEquals("Книга 1", book.getTitle());
        assertEquals("Автор 1", book.getAuthor());
        assertEquals("ISBN1", book.getIsbn());
        assertEquals(2020, book.getYear());
    }

    @Test
    void testToString() {
        Book book = new Book("Книга 1", "Автор 1", "ISBN1", 2020);
        String expected = "Назва: Книга 1. Автор: Автор 1. ISBN: ISBN1. Рік: 2020";
        assertEquals(expected, book.toString());
    }
}

