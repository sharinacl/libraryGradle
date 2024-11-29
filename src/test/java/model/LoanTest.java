package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import utilities.GenderType;

public class LoanTest {

	// Test for checking if dueDate is set correctly (14 days from now)
	@Test
	public void testDueDate() {
		Customer customer = new Customer("Mr.","Markus", "Lissjanis","Göteborg","12345","m@email.com",12, GenderType.MALE);
		Book book = new Book(1, "Learning Java", "The Author", "123-346-78", "Branch", 208);

		// Create Loan instance
		Loan loan = new Loan(1, customer, book);

		// Calculate the expected due date (14 days from now)
		LocalDate expectedDueDate = LocalDate.now().plusDays(14);

		// Verify that the due date is correct
		assertEquals(expectedDueDate, loan.getDueDate(), "Due date should be 14 days after the current date.");
	}
}
