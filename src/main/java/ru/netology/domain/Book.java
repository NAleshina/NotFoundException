package ru.netology.domain;

import java.util.Objects;

public class Book extends Product {
    private String author;


    public Book() {
        super();
    }

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;

    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author=" + author +
                '}';
    }

    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        return this.getAuthor().equalsIgnoreCase(search);
    }
}
