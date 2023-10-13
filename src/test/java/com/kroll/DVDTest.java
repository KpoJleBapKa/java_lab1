package com.kroll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DVDTest {
    private DVD dvd;

    @BeforeEach
    void setUp() {
        this.dvd = new DVD("DVD 1", "Режисер 1", "2023");
    }

    @Test
    void testDVDConstructor() {
        assertEquals("DVD 1", dvd.getTitle());
        assertEquals("Режисер 1", dvd.getDirector());
        assertEquals("2023", dvd.getReleaseYear());
    }

    @Test
    void testToString() {
        DVD dvd = new DVD("DVD 1", "Режисер 1", "2023");
        String expected = "Назва: DVD 1. Режисер: Режисер 1. Рік випуску: 2023";
        assertEquals(expected, dvd.toString());
    }
}
