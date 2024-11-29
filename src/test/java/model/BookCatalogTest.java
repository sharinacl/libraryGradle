package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookCatalogTest {

	private BookCatalog bc;
	private Book book1;

	public BookCatalogTest() {
		bc = new BookCatalog();
		book1 = new Book(1,"Learning Java","","","",0);
		bc.addBook(book1);
	}

	//G
	@Test
	public void testAddABook() {
		Book newBook = new Book(2,"Amazing Java","","","",0);
		bc.addBook(newBook);
		assertEquals(2, bc.getNumberOfBooks());
		assertEquals(newBook, bc.getBookArray()[1]);
	}

	//G
	@Test
	public void testFindBook() throws BookNotFoundException {
		// Call findBook() method with the title of book1 to retrieve it from the catalog.
		Book bookFound = bc.findBook(book1.getTitle()); // retrieve book by its title.
		assertNotNull(bookFound); // test to ensure the book is found (should not be null).
		assertEquals(book1, bookFound); // test to confirm that the expected book is the same as the book that is found(book1).
	}

	//G
	@Test
	public void testFindBookIgnoringCase() throws BookNotFoundException {
		// Test with exact case
		Book bookFoundExact = bc.findBook("Learning Java");
		assertTrue(book1.getTitle().equalsIgnoreCase(bookFoundExact.getTitle()));

		// Test with all lowercase
		Book bookFoundLowercase = bc.findBook("learning java");
		assertTrue(book1.getTitle().equalsIgnoreCase(bookFoundLowercase.getTitle()));

		// Test with all uppercase
		Book bookFoundUppercase = bc.findBook("LEARNING JAVA");
		assertTrue(book1.getTitle().equalsIgnoreCase(bookFoundUppercase.getTitle()));

		// Test with mixed case
		Book bookFoundMixedCase = bc.findBook("LeArNiNg jAvA");
		assertTrue(book1.getTitle().equalsIgnoreCase(bookFoundMixedCase.getTitle()));
	}


	//G
	@Test
	public void testFindBookWithExtraSpaces() throws BookNotFoundException {
		// Test with leading and trailing spaces
		Book bookFoundExtraSpace = bc.findBook(" Learning Java ");
		assertNotNull(bookFoundExtraSpace, "Book should be found even with extra spaces");
		assertEquals("Learning Java", bookFoundExtraSpace.getTitle(), "Title should match original book title");

		// Test with trailing spaces
		Book bookFoundTrailingSpace = bc.findBook("Learning Java  ");
		assertNotNull(bookFoundTrailingSpace, "Book should be found with trailing spaces");
		assertEquals("Learning Java", bookFoundTrailingSpace.getTitle(), "Title should match original book title");

		// Test with leading spaces
		Book bookFoundLeadingSpace = bc.findBook(" Learning Java");
		assertNotNull(bookFoundLeadingSpace, "Book should be found with leading spaces");
		assertEquals("Learning Java", bookFoundLeadingSpace.getTitle(), "Title should match original book title");

	}
	//VG
	// This test should throw BookNotFoundException in order to pass.
	@Test
	public void testFindBookThatDoesntExist() {
		// Ensure the catalog has no books
		bc = new BookCatalog();

		// Use assertThrows to check that BookNotFoundException is thrown
		assertThrows(BookNotFoundException.class, () -> {
			bc.findBook("Learning Java");  // This should throw an exception
		});
	}

}
