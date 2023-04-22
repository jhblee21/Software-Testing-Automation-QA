package test;

/**
 * This Test tests the Contact class object for the following requirements:
 * 
 * 	1. Id        String field cannot be null and cannot be longer than 10 chars
 * 	2. firstName String field cannot be null and cannot be longer than 10 chars
 * 	3. lastName  String field cannot be null and cannot be longer than 10 chars
 * 	4. phoneNum  String field cannot be null and must be exactly 10 digits
 * 	5. address   String field cannot be null and cannot be longer than 30 chars
 * 
 * @author James Lee james.lee4@snhu.edu
 */

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import contactService.Contact;

class ContactTest {
	
	// Test Contact Id for null:
	@Test
	void testContactIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Contact(null, "first name", "last name", "0123456789", "address");
		});
	}
	
	// Test Contact Id for length:
	@Test
	void testContactIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Contact("LongerThan10Chars", "first name", "last name", "0123456789", "address");
		});
	}

	// Test Contact first name for null:
	@Test
	void testContactFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Contact("12345", null, "last name", "0123456789", "address");
		});
	}
	
	// Test Contact first name for length:
	@Test
	void testContactFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Contact("12345", "LongerThan10Chars", "last name", "0123456789", "address");
		});
	}
	
	// Test Contact last name for null:
	@Test
	void testContactLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Contact("12345", "first name", null, "0123456789", "address");
		});
	}
	// Test Contact last name for length:
	@Test
	void testContactLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Contact("12345", "first name", "LongerThan10Chars", "0123456789", "address");
		});
	}
		
	// Test Contact phone number for null:
	@Test
	void testContactPhoneNumNull() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Contact("12345", "first name", "last name", null, "address");
		});
	}
	
	/* Phone number length tested for greater than 10 digits
	 * and less than 10 digits
	 */
	// Test Contact phone number for length other than 10:
	@Test
	void testContactPhoneNumTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Contact("12345", "first name", "last name", "01234567890", "address");   // Phone number greater than 10 digits
		});
	}
	@Test
	void testContactPhoneNumTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Contact("12345", "first name", "last name", "123", "address");   // Phone number less than 10 digits
		});
	}
	
	// Test Contact address for null:
	@Test
	void testContactAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Contact("12345", "first name", "last name", "0123456789", null);
		});
	}
	
	// Test Contact address for length:
	@Test
	void testContactAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Contact("12345", "LongerThan10Chars", "last name", "0123456789", "abcdeabcdeabcdeabcdeabcdeabcde");
		});
	}
	
	// Test getId():
	@Test
	void testGetId() {
		Contact contact = new Contact("12345", "first name", "last name", "1234567890", "address");
		assertEquals("12345", contact.getId());
	}
	
	// Test getFirstName():
	@Test
	void testGetFirstName() {
		Contact contact = new Contact("12345", "Test", "last name", "1234567890", "address");
		assertEquals("Test", contact.getFirstName());
	}
	
	// Test getLastName():
	@Test
	void testGetLastName() {
		Contact contact = new Contact("12345", "firstname", "Test", "1234567890", "address");
		assertEquals("Test", contact.getLastName());
	}
	
	// Test getPhoneNum():
	@Test
	void testGetPhoneNum() {
		Contact contact = new Contact("12345", "firstname", "lastname", "1234567890", "address");
		assertEquals("1234567890", contact.getPhoneNum());
	}
	
	// Test getAddress():
	@Test
	void testGetAddress() {
		Contact contact = new Contact("12345", "firstname", "lastname", "1234567890", "address");
		assertEquals("address", contact.getAddress());
	}
	
	// Test setFirstName():
	@Test
	void testSetFirstName() {
		Contact contact = new Contact("12345", "firstname", "lastname", "1234567890", "address");
		contact.setFirstName("test");
		assertEquals("test", contact.getFirstName());
	}
	
	// Test setLastName():
	@Test
	void testSetLastName() {
		Contact contact = new Contact("12345", "firstname", "lastname", "1234567890", "address");
		contact.setLastName("test");
		assertEquals("test", contact.getLastName());
	}
	
	// Test setPhoneNum():
	@Test
	void testSetPhoneNum() {
		Contact contact = new Contact("12345", "firstname", "lastname", "1234567890", "address");
		contact.setPhoneNum("0987654321");
		assertEquals("0987654321", contact.getPhoneNum());
	}
	
	// Test setAddress():
	@Test
	void testSetAddress() {
		Contact contact = new Contact("12345", "firstname", "lastname", "1234567890", "address");
		contact.setAddress("test");
		assertEquals("test", contact.getAddress());
	}
}