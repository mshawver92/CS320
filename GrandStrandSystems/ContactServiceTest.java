package GrandStrandSystems;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class ContactServiceTest {
	
	@BeforeEach
	void setUp() {
		ContactService service = new ContactService();
	}

    @DisplayName("Test adding a contact")
    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "Fred", "James", "0123456789", "555 N Kingsman Dr");
        service.addContact(contact);

        Contact retrieved = service.getContact("1");
        assertNotNull(retrieved);
        assertEquals(contact.getContactID(), retrieved.getContactID());
        assertEquals(contact.getFirstName(), retrieved.getFirstName());
        assertEquals(contact.getLastName(), retrieved.getLastName());
        assertEquals(contact.getPhoneNum(), retrieved.getPhoneNum());
        assertEquals(contact.getAddress(), retrieved.getAddress());
    }

    @DisplayName("Test adding a contact with duplicate ID")
    @Test
    public void testAddDuplicateContact() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("1", "Fred", "James", "0123456789", "555 N Kingsman Dr");
        Contact contact2 = new Contact("1", "John", "Doe", "9876543210", "123 Elm St");

        service.addContact(contact1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }

    @DisplayName("Test deleting a contact")
    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "Fred", "James", "0123456789", "555 N Kingsman Dr");
        service.addContact(contact);

        service.deleteContact("1");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.getContact("1");
        });
    }

    @DisplayName("Test deleting a non-existent contact")
    @Test
    public void testDeleteNonExistentContact() {
        ContactService service = new ContactService();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("999");
        });
    }

    @DisplayName("Test updating first name")
    @Test
    public void testUpdateFirstName() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "Fred", "James", "0123456789", "555 N Kingsman Dr");
        service.addContact(contact);

        service.updateFirstName("1", "John");
        assertEquals("John", service.getContact("1").getFirstName());
    }

    @DisplayName("Test updating last name")
    @Test
    public void testUpdateLastName() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "Fred", "James", "0123456789", "555 N Kingsman Dr");
        service.addContact(contact);

        service.updateLastName("1", "Doe");
        assertEquals("Doe", service.getContact("1").getLastName());
    }

    @DisplayName("Test updating phone number")
    @Test
    public void testUpdatePhoneNumber() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "Fred", "James", "0123456789", "555 N Kingsman Dr");
        service.addContact(contact);

        service.updatePhoneNumber("1", "9876543210");
        assertEquals("9876543210", service.getContact("1").getPhoneNum());
    }

    @DisplayName("Test updating address")
    @Test
    public void testUpdateAddress() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "Fred", "James", "0123456789", "555 N Kingsman Dr");
        service.addContact(contact);

        service.updateAddress("1", "123 Elm St");
        assertEquals("123 Elm St", service.getContact("1").getAddress());
    }

    @DisplayName("Test updating fields of non-existent contact")
    @Test
    public void testUpdateNonExistentContact() {
        ContactService service = new ContactService();
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("999", "John");
        });
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.updateLastName("999", "Doe");
        });
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.updatePhoneNumber("999", "9876543210");
        });
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.updateAddress("999", "123 Elm St");
        });
    }
}



