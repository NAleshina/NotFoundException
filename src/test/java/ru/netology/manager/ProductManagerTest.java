package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ProductManagerTest {
    @Mock
    private ProductRepository repository;
    @InjectMocks
    private ProductManager manager;

    private Book book1 = new Book(1, "Head First Java", 1500, "Kathy Sierra");
    private Book book2 = new Book(2, "Introduction to Programming in Java: An Interdisciplinary Approach", 3900, "Robert Sedgewick");
    private Smartphone phone1 = new Smartphone(3, "Galaxy S20+", 74990, "Samsung");
    private Smartphone phone2 = new Smartphone(4, "P40 128Gb", 39990, "Huawei");

    @Test
    void shouldSearchByText() {
        Product[] returned = new Product[]{book1, book2, phone1, phone2};
        doReturn(returned).when(repository).findAll();
        Product[] actual = manager.searchBy("Head First Java");
        Product[] expected = new Product[]{book1};
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }
}