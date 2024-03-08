package phone.utility;

import phone.Phone;
import phone.screen.registerednumbers.contact.Contact;

public class IdentifyNumber {
    Phone phone;

    public IdentifyNumber(Phone phone) {
        this.phone = phone;
    }

    public Contact identifyNumber(String phoneNumber) {
        Contact contact = phone.getRegisteredContact().getContactByPhoneNumber(phoneNumber);
        if (contact != null) {
            return contact;
        }
        contact = new Contact(null, phoneNumber);
        return contact;
    }
}
