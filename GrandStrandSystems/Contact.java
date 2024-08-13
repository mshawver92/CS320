package GrandStrandSystems;

public class Contact {
    private final String contactID;
    private String firstName;
    private String lastName;
    private String phoneNum;
    private String address;

    public Contact(String contactID, String firstName, String lastName, String phoneNum, String address) {
        if (contactID == null || contactID.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        if (phoneNum == null || phoneNum.length() != 10 || !phoneNum.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }

        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.address = address;
    }

    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        this.lastName = lastName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        if (phoneNum == null || phoneNum.length() != 10 || !phoneNum.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;
    }
}
