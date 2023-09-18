package com.kroll;

import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void testBookConstructor() {
        Book book = new Book("Книга 1", "Автор 1", "ISBN1", 2020);
        assertEquals("Книга 1", book.getTitle());
        assertEquals("Автор 1", book.getAuthor());
        assertEquals("ISBN1", book.getIsbn());
        assertEquals(2020, book.getYear());
    }

    @Test
    public void testToString() {
        Book book = new Book("Книга 1", "Автор 1", "ISBN1", 2020);
        String expected = "Назва: Книга 1. Автор: Автор 1. ISBN: ISBN1. Рік: 2020";
        assertEquals(expected, book.toString());
    }
}

