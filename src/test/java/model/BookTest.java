package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BookTest {

	//G
	@Test
	public void test2EqualBooks() {
		Book book1 = new Book(001, "To Kill a Mockingbird", "Harper Lee", "978-0-06-112008-4", "Fiction", 281);
		Book book2 = new Book(001, "To Kill a Mockingbird", "Harper Lee", "978-0-06-112008-4", "Fiction", 281);

		assertEquals(book1, book2, "Books with the same properties should be equal");

	}

	//G
	@Test
	public void test2NonEqualBooks() {
		Book book1 = new Book(001, "To Kill a Mockingbird", "Harper Lee", "978-0-06-112008-4", "Fiction", 281);
		Book book2 = new Book(002, "1984", "George Orwell", "978-0-452-28423-4", "Dystopian Fiction", 281);

		assertNotEquals(book1, book2, "Books with the same properties should not be equal");

	}

}
