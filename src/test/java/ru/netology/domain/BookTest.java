package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private Book book1 = new Book(1, "Head First Java", 1500, "Kathy Sierra");
    private Book book2 = new Book(2, "Introduction to Programming in Java: An Interdisciplinary Approach", 3900, "Robert Sedgewick");

    @Test
    void shouldMatchesName() {
        boolean actual = book1.matches("Head First Java");
        assertTrue(actual);
    }

    @Test
    void shouldMatchesAuthor() {
        boolean actual = book2.matches("Robert Sedgewick");
        assertTrue(actual);
    }
}