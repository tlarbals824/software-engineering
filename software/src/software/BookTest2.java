package software;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Year;

class BookTest2 {

	private Book bookManager;

    @BeforeEach
    void setUp() {
        bookManager = new Book();
    }
    
    @Test
    void testSearchBookWithoutException(){
        Book book1 = new Book("1", "자바 기초", "Jane", Year.of(2021));
        Book book2 = new Book("2", "소프트웨어 공학", "Tom", Year.of(2014));
        Book book3 = new Book("3", "분산 컴퓨팅", "Yoon", Year.of(2024));

        bookManager.addBook(book1);
        bookManager.addBook(book2);
        bookManager.addBook(book3);

        assertEquals(book1, bookManager.searchBook(book1.getId()));
        assertEquals(book2, bookManager.searchBook(book2.getId()));
        assertEquals(book3, bookManager.searchBook(book3.getId()));
    }
    
    @Test
    void testRemoveBookWithoutDoubleRemove(){
        Book book1 = new Book("1", "자바 기초", "Jane", Year.of(2021));
        Book book2 = new Book("2", "소프트웨어 공학", "Tom", Year.of(2014));

        bookManager.addBook(book1);
        bookManager.addBook(book2);

        bookManager.deleteBook(book1.getId());
        assertThrows(IllegalArgumentException.class, () -> bookManager.searchBook(book1.getId()));

        bookManager.deleteBook(book2.getId());
        assertThrows(IllegalArgumentException.class, () -> bookManager.searchBook(book2.getId()));
    }

    @Test
    void testAddBookWithoutDoubleAddException(){
        Book book = new Book("1", "자바 기초", "Jane", Year.of(2021));

        bookManager.addBook(book);
        assertEquals(book, bookManager.searchBook(book.getId()));
    }
}

