package contactService;

/**
 * This class holds information about contact objects
 * 
 * @author James Lee james.lee4@snhu.edu
 */

public class Contact {
	String id;
	String firstName;
	String lastName;
	String phoneNum;
	String address;
	
	/**
	 * Create Contact constructor with:
	 * 		identifier   (immutable; 10 chars or less; cannot be null)
	 * 		first name   (mutable; 10 chars or less; cannot be null)
	 * 		last  name   (mutable; 10 chars or less; cannot be null)
	 * 		phone number (mutable; exactly 10 digits; cannot be null)
	 * 		address      (mutable; 30 chars or less; cannot be null)
	 */
	public Contact(String id, String firstName, 
			String lastName, String phoneNum, String address) {
		// Check id parameter for null and length:
		if ((id == null) || (id.length() > 10)) {
			throw new IllegalArgumentException("Invalid id");
		}
		// Check first name parameter for null and length:
		if ((firstName == null) || (firstName.length() > 10)) {
			throw new IllegalArgumentException("Invalid first name");
		}
		// Check last name parameter for null and length:
		if ((lastName == null) || (lastName.length() > 10)) {
			throw new IllegalArgumentException("Invalid last name");
		}
		// Check phone number parameter for null and length other than 10 digits:
		if ((phoneNum == null) || (phoneNum.length() != 10)) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		// Check address parameter for null and length:
		if ((address == null) || (address.length() > 30)) {
			throw new IllegalArgumentException("Invalid address");
		}
		
		// If all conditions above pass, assign variables with parameters:
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
		this.address = address;
	}
	
	// Get the id
	public String getId() {
		return id;
	}
	
	// Get the first name
	public String getFirstName() {
		return firstName;
	}
	
	// Get the last name
	public String getLastName() {
		return lastName;
	}
	
	// Get the phone number
	public String getPhoneNum() {
		return phoneNum;
	}
	
	// Get the address
	public String getAddress() {
		return address;
	}
	
	// Set the first name
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	// Set the last name
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	// Set the first name
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	// Set the first name
	public void setAddress(String address) {
		this.address = address;
	}
}