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
            System.out.println("CONTACTY NULL DEGILLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
            return contact;
        }
        contact = new Contact(null, phoneNumber);
        System.out.println(getClass().getName() + " --> Person is empty. So it is created here to not return null by just number / PHone Number :" +phoneNumber);
        return contact;
    }
}
