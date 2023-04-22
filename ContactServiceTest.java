package test;

/**
 * This Test tests the ContactService class object for the following requirements:
 * 
 * 	1. Adding contacts
 * 		a. Add single contact with unique ID
 * 		b. Add multiple contacts with unique ID's
 * 		c. Test for exception when trying to add contact with existing ID
 * 	2. Deleting contacts
 * 	3. Updating contacts
 * 		a. Update first name
 * 		b. Update last name
 * 		c. Update phone number
 * 		d. Update address
 * 
 * @author James Lee james.lee4@snhu.edu
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contactService.Contact;
import contactService.ContactService;

class ContactServiceTest {
	
	// Test adding single contact:
	@Test
	void testAddContact() {
		// Create test instance of ContactService
		ContactService cs = new ContactService();
		
		cs.addContact("123", "first name", "last name", "0123456789", "address");
		assertTrue(cs != null);
	}

	// Test adding multiple unique contacts:
	@Test
	void testAddMultipleContacts() {
		// Create test instance of ContactService
		ContactService cs = new ContactService();
		
		// Create two test objects and add to contacts list
		Contact contact1 = cs.addContact("123", "first name", "last name", "0123456789", "address");
		Contact contact2 = cs.addContact("2", "first name", "last name", "0123456789", "address");
		
		// Assert that two objects are stored in the contacts list
		assertTrue((ContactService.getList().contains(contact1)) && (ContactService.getList().contains(contact2)));
	}
	
	// Test error when adding contact with duplicate ID:
	@Test
	void testDuplicateId() {
		// Create test instance of ContactService
		ContactService cs = new ContactService();
		
		// Create a test object and add to contacts list
		cs.addContact("1", "first name", "last name", "0123456789", "address");		
		
		// Assert that adding new object with existing ID to the contacts list
		// will throw an error
		Assertions.assertThrows(NoSuchElementException.class,  () -> {
			cs.addContact("1", "John", "Doe", "0123456789", "address");
		});
		
	}
	
	// Test deleting a contact:
	@Test
	void testDeleteContact() {
		// Create test instance of ContactService
		ContactService cs = new ContactService();
		
		// Create a test object 'contact' and add to contacts list
		Contact contact = cs.addContact("123", "first name", "last name", "0123456789", "address");
		// Delete the test object from the contacts list
		cs.deleteContact("123");
		// Assert that the contact has been deleted from the list
		assertTrue(!ContactService.getList().contains(contact));
	}
	
	// Test updating a contact:
	@Test
	void testUpdateContact() {
		// Create test instance of ContactService
		ContactService cs = new ContactService();
		// Create a test object 'contact' and add to contacts list
		Contact contact = cs.addContact("123", "first name", "last name", "0123456789", "address");
		
		// update first name, last name, phone number, address
		cs.updateContactFirstName("123", "John");
		cs.updateContactLastName ("123", "Doe");
		cs.updateContactPhoneNum ("123", "9876543210");
		cs.updateContactAddress  ("123", "123 Elm St");
		
		// assert all updates:
		assertAll("contact", () -> assertEquals("John", contact.getFirstName()), 
							 () -> assertEquals("Doe", contact.getLastName()), 
							 () -> assertEquals("9876543210", contact.getPhoneNum()),
							 () -> assertEquals("123 Elm St", contact.getAddress())
				 );
	}
}