package contactService;

/**
 * This class uses in-memory date structure
 * to support storing contacts.
 * There is no user interface for this class.
 * 
 * @author James Lee james.lee4@snhu.edu
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;   // Import Iterator utility

public class ContactService {
	
	// A list of the created contacts
	private static List<Contact> contacts = new ArrayList<Contact>();
	
	// public constructor:
	public ContactService() {
	}
	
	// Get contacts list
	public static List<Contact> getList() {
		return contacts;
	}
	
	// Add new contact the the contacts list
	public Contact addContact(String id, String firstName, String lastName, String phoneNum, String address) {

		// a local contact instance
		Contact contact = null;
		
		/**
		 * Use an iterator pattern to check every contact
		 * in the list to determine if the new contact ID
		 * specified by the user is in use or not.
		 */
		// instantiate the Iterator of type Contact:
		Iterator<Contact>it = contacts.iterator();
			
		// iterate through the contacts ArrayList
		while (it.hasNext()) {
			if (it.next().getId().equals(id)) {   // if the contact's ID equals the id parameter...
				contact = it.next();   			  // assign local contact instance with the found instance
			}
		}
		// if not found, make a new contact instance and add to list of contacts
		if (contact == null) {
			contact = new Contact(id, firstName, lastName, phoneNum, address);
			contacts.add(contact);
		}
				
		// return the contact instance
		return contact;
	}
	
	// Delete the contact from the contacts list by the unique ID:
	public void deleteContact(String id) {
		
		// instantiate the Iterator of type Contact:
		Iterator<Contact>it = contacts.iterator();
					
		// iterate through the contacts ArrayList
		while (it.hasNext()) {
			if (it.next().getId().equals(id)) {   // if the contact's ID equals the id parameter...
				it.remove();              // assign local contact instance with the found instance
			}
		}
	}
	
	// Update the contact's first name:
	public void updateContactFirstName(String id, String firstName) {
		// a local contact instance
		Contact contact = null;
		
		// instantiate the Iterator of type Contact:
		Iterator<Contact>it = contacts.iterator();
							
		// iterate through the contacts ArrayList
		while (it.hasNext()) {
			if (it.next().getId().equals(id)) {    // if the contact's ID equals the id parameter...
				contact = it.next();               // assign local contact instance with the found instance
				contact.setFirstName(firstName);   // update the contact's first name
			}
		}
	}
	
	// Update the contact's last name:
	public void updateContactLastName(String id, String lastName) {
		// a local contact instance
		Contact contact = null;
		
		// instantiate the Iterator of type Contact:
		Iterator<Contact>it = contacts.iterator();
							
		// iterate through the contacts ArrayList
		while (it.hasNext()) {
			if (it.next().getId().equals(id)) {   // if the contact's ID equals the id parameter...
				contact = it.next();              // assign local contact instance with the found instance
				contact.setLastName(lastName);    // update the contact's last name
			}
		}
	}
	
	// Update the contact's phone number:
	public void updateContactPhoneNum(String id, String phoneNum) {
		// a local contact instance
		Contact contact = null;
		
		// instantiate the Iterator of type Contact:
		Iterator<Contact>it = contacts.iterator();
							
		// iterate through the contacts ArrayList
		while (it.hasNext()) {
			if (it.next().getId().equals(id)) {   // if the contact's ID equals the id parameter...
				contact = it.next();              // assign local contact instance with the found instance
				contact.setPhoneNum(phoneNum);    // update the contact's phone number
			}
		}
	}
	
	// Update the contact's address:
	public void updateContactAddress(String id, String address) {
		// a local contact instance
		Contact contact = null;
		
		// instantiate the Iterator of type Contact:
		Iterator<Contact>it = contacts.iterator();
							
		// iterate through the contacts ArrayList
		while (it.hasNext()) {
			if (it.next().getId().equals(id)) {   // if the contact's ID equals the id parameter...
				contact = it.next();              // assign local contact instance with the found instance
				contact.setAddress(address);      // update the contact's address
			}
		}
	}
}