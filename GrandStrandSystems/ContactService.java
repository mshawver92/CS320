package GrandStrandSystems;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contacts;

    public ContactService() {
        this.contacts = new HashMap<>();
    }

    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("Contact ID must be unique");
        }
        contacts.put(contact.getContactID(), contact);
    }

    public void deleteContact(String contactID) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        contacts.remove(contactID);
    }

    public void updateFirstName(String contactID, String firstName) {
        Contact contact = getContact(contactID);
        contact.setFirstName(firstName);
    }

    public void updateLastName(String contactID, String lastName) {
        Contact contact = getContact(contactID);
        contact.setLastName(lastName);
    }

    public void updatePhoneNumber(String contactID, String phoneNum) {
        Contact contact = getContact(contactID);
        contact.setPhoneNum(phoneNum);
    }

    public void updateAddress(String contactID, String address) {
        Contact contact = getContact(contactID);
        contact.setAddress(address);
    }

    Contact getContact(String contactID) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        return contact;
    }
}
