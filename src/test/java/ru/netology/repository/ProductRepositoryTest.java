package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book book1 = new Book(1, "Head First Java", 1500, "Kathy Sierra");
    private Book book2 = new Book(2, "Introduction to Programming in Java: An Interdisciplinary Approach", 3900, "Robert Sedgewick");
    private Smartphone phone1 = new Smartphone(3, "Galaxy S20+", 74990, "Samsung");
    private Smartphone phone2 = new Smartphone(4, "P40 128Gb", 39990, "Huawei");
    @BeforeEach
    public void setUp(){
        repository.save(book1);
        repository.save(book2);
        repository.save(phone1);
        repository.save(phone2);
    }
    @Test
    void shouldRemoveByExistId() {
    repository.removeById(3);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{book1, book2, phone2};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldRemoveByNotExistId() {
        assertThrows(NotFoundException.class, () -> repository.removeById(5));
    }
}