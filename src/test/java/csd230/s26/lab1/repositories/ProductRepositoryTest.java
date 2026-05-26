package csd230.s26.lab1.repositories;

import com.github.javafaker.Faker;
import csd230.s26.lab1.entities.BookEntity;
import csd230.s26.lab1.entities.TurretSpiderEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.*;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
// import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Use real MySQL, not H2
@Transactional(propagation = Propagation.NOT_SUPPORTED) // Don't rollback so data persists for inspection
class ProductRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private TurretSpiderRepository turretSpiderRepository;

    @Test
    void testSaveAndRetrieveBook() {
        Faker faker = new Faker();

        // 1. Create a fake book
        BookEntity book = new BookEntity(
                faker.book().author(),
                faker.book().title(),
                29.99,
                10
        );

        // 2. Save to database
        bookRepository.save(book);
        Long savedId = book.getId();
        assertNotNull(savedId, "ID should be generated upon saving");

        // 3. Retrieve and Verify
        BookEntity foundBook = bookRepository.findById(savedId).orElseThrow();
        assertEquals(book.getTitle(), foundBook.getTitle());
        assertEquals(book.getAuthor(), foundBook.getAuthor());

        System.out.println("Successfully verified book: " + foundBook.getTitle());
    }

    @Test
    void testCrudOperations() {

        BookEntity book = new BookEntity(
                "J.K. Rowling",
                "Harry Potter",
                25.99,
                5
        );

        // CREATE
        BookEntity savedBook = bookRepository.save(book);

        assertNotNull(savedBook.getId());

        // READ
        BookEntity foundBook = bookRepository.findById(savedBook.getId()).orElse(null);

        assertNotNull(foundBook);
        assertEquals("Harry Potter", foundBook.getTitle());

        // DELETE
        bookRepository.delete(foundBook);

        BookEntity deletedBook =
                bookRepository.findById(savedBook.getId()).orElse(null);

        assertNull(deletedBook);
    }

    @Test
    void testFindByAuthor() {

        BookEntity book1 = new BookEntity(
                "Stephen King",
                "It",
                19.99,
                3
        );

        BookEntity book2 = new BookEntity(
                "Stephen King",
                "The Shining",
                24.99,
                4
        );

        BookEntity book3 = new BookEntity(
                "J.R.R. Tolkien",
                "The Hobbit",
                29.99,
                7
        );

        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);

        var results = bookRepository.findByAuthor("Stephen King");

        assertEquals(2, results.size());

        for (BookEntity book : results) {
            assertEquals("Stephen King", book.getAuthor());
        }
    }

    @Test
    void testSaveAndRetrieveTurretSpider() {

        TurretSpiderEntity spider = new TurretSpiderEntity(
                "Steel",
                149.99,
                8,
                10
        );

        turretSpiderRepository.save(spider);

        Long savedId = spider.getId();

        assertNotNull(savedId);

        TurretSpiderEntity retrievedSpider =
                turretSpiderRepository.findById(savedId).orElse(null);

        assertNotNull(retrievedSpider);

        assertEquals("Steel", retrievedSpider.getMaterial());
        assertEquals(8, retrievedSpider.getBallBearings());
        assertEquals(10, retrievedSpider.getSpoons());
    }
}