package GrandStrandSystems;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class ContactTest {
	

    @DisplayName("Test a valid Constructor")
    @Test
    public void testConstructor() {
        String contactID = "1";
        String firstName = "Fred";
        String lastName = "James";
        String phoneNum = "0123456789";
        String address = "555 N Kingsman Dr";

        Contact testContact = new Contact(contactID, firstName, lastName, phoneNum, address);

        assertEquals(contactID, testContact.getContactID());
        assertEquals(firstName, testContact.getFirstName());
        assertEquals(lastName, testContact.getLastName());
        assertEquals(phoneNum, testContact.getPhoneNum());
        assertEquals(address, testContact.getAddress());
    }

    @DisplayName("Test an invalid Constructor")
    @Test
    public void testInvalidConstructor() {
        String contactID = "2";
        String firstName = "Fred";
        String lastName = "J";
        String phoneNum = "0123";
        String address = "555 N Kingsman Dr";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactID, firstName, lastName, phoneNum, address);
        });
    }

    @DisplayName("Test a valid First Name")
    @Test
    public void testValidFirst() {
        String contactID = "2";
        String firstName = "Fred";
        String lastName = "James";
        String phoneNum = "0123456789";
        String address = "555 N Kingsman St";

        Contact testContact = new Contact(contactID, firstName, lastName, phoneNum, address);
        testContact.setFirstName("Bob");
        assertEquals("Bob", testContact.getFirstName());
    }

    @DisplayName("Test an invalid null First Name")
    @Test
    public void testInvalidFirst() {
        String contactID = "2";
        String firstName = "Fred";
        String lastName = "James";
        String phoneNum = "0123456789";
        String address = "555 N Kingsman St";

        Contact testContact = new Contact(contactID, firstName, lastName, phoneNum, address);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testContact.setFirstName(null);
        });
    }

    @DisplayName("Test getting ID")
    @Test
    public void testGetID() {
        String contactID = "2";
        String firstName = "Fred";
        String lastName = "James";
        String phoneNum = "0123456789";
        String address = "555 N Kingsman St";

        Contact testContact = new Contact(contactID, firstName, lastName, phoneNum, address);
        assertEquals(contactID, testContact.getContactID());
    }

    @DisplayName("Test invalid ID")
    @Test
    public void testInvalidID() {
        String contactID = "2";
        String firstName = "Fred";
        String lastName = "James";
        String phoneNum = "0123456789";
        String address = "555 N Kingsman St";

        Contact testContact = new Contact(contactID, firstName, lastName, phoneNum, address);
        assertNotEquals("3", testContact.getContactID());
    }

    @DisplayName("Test too long getID")
    @Test
    public void testLongID() {
        String contactID = "12345678901";
        String firstName = "Fred";
        String lastName = "James";
        String phoneNum = "0123456789";
        String address = "555 N Kingsman St";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactID, firstName, lastName, phoneNum, address);
        });
    }

    @DisplayName("Test invalid null Last Name")
    @Test
    public void testInvalidLast() {
        String contactID = "2";
        String firstName = "Fred";
        String lastName = "James";
        String phoneNum = "0123456789";
        String address = "555 N Kingsman St";

        Contact testContact = new Contact(contactID, firstName, lastName, phoneNum, address);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testContact.setLastName(null);
        });
    }

    @DisplayName("Test invalid length Last Name")
    @Test
    public void testLongLast() {
        String contactID = "2";
        String firstName = "Fred";
        String lastName = "James";
        String phoneNum = "0123456789";
        String address = "555 N Kingsman St";

        Contact testContact = new Contact(contactID, firstName, lastName, phoneNum, address);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testContact.setLastName("ThisIsWayTooLongOfALastName");
        });
    }

    @DisplayName("Test a valid Last Name")
    @Test
    public void testValidLast() {
        String contactID = "2";
        String firstName = "Fred";
        String lastName = "James";
        String phoneNum = "0123456789";
        String address = "555 N Kingsman St";

        Contact testContact = new Contact(contactID, firstName, lastName, phoneNum, address);
        testContact.setLastName("Harris");
        assertEquals("Harris", testContact.getLastName());
    }

    @DisplayName("Test an invalid Phone Number")
    @Test
    public void testInvalidNumber() {
        String contactID = "2";
        String firstName = "Fred";
        String lastName = "James";
        String phoneNum = "0123456789";
        String address = "555 N Kingsman St";

        Contact testContact = new Contact(contactID, firstName, lastName, phoneNum, address);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testContact.setPhoneNum(null);
        });
    }

    @DisplayName("Test an invalid length Phone Number")
    @Test
    public void testInvalidLengthNumber() {
        String contactID = "2";
        String firstName = "Fred";
        String lastName = "James";
        String phoneNum = "0123456789";
        String address = "555 N Kingsman St";

        Contact testContact = new Contact(contactID, firstName, lastName, phoneNum, address);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testContact.setPhoneNum("1");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testContact.setPhoneNum("1234567890123456789");
        });
    }

    @DisplayName("Test a valid length Phone Number")
    @Test
    public void testValidNumber() {
        String contactID = "2";
        String firstName = "Fred";
        String lastName = "James";
        String phoneNum = "0123456789";
        String address = "555 N Kingsman St";

        Contact testContact = new Contact(contactID, firstName, lastName, phoneNum, address);

        testContact.setPhoneNum("4128675309");
        assertEquals("4128675309", testContact.getPhoneNum());
    }

    @DisplayName("Test an Invalid Address")
    @Test
    public void testInvalidAddress() {
        String contactID = "2";
        String firstName = "Fred";
        String lastName = "James";
        String phoneNum = "0123456789";
        String address = "555 N Kingsman St";

        Contact testContact = new Contact(contactID, firstName, lastName, phoneNum, address);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testContact.setAddress(null);
        });
    }

    @DisplayName("Test an Invalid Length Address")
    @Test
    public void testInvalidLengthAddress() {
        String contactID = "2";
        String firstName = "Fred";
        String lastName = "James";
        String phoneNum = "0123456789";
        String address = "555 N Kingsman St";

        Contact testContact = new Contact(contactID, firstName, lastName, phoneNum, address);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testContact.setAddress("89088899990000 Frederico Way Long Rd");
        });
    }

    @DisplayName("Test a valid Address")
    @Test
    public void testValidAddress() {
        String contactID = "2";
        String firstName = "Fred";
        String lastName = "James";
        String phoneNum = "0123456789";
        String address = "555 N Kingsman St";

        Contact testContact = new Contact(contactID, firstName, lastName, phoneNum, address);

        testContact.setAddress("375 Shady Oak Ln");
        assertEquals("375 Shady Oak Ln", testContact.getAddress());
    }
}