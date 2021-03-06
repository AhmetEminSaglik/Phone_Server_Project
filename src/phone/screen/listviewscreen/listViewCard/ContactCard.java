package phone.screen.listviewscreen.listViewCard;

import phone.screen.basescreen.BaseScreen;
import phone.screen.registerednumbers.contact.Contact;

public class ContactCard extends Card {

    private Contact contact;

    public ContactCard(Contact contact, BaseScreen phoneScreen) {
        this(contact.getPerson().toString(), phoneScreen);
        this.contact = contact;

    }

    public ContactCard(String name, BaseScreen phoneScreen) {
        super(name, phoneScreen);

    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }


    @Override
    public String toString() {
        if (contact != null) {
            return contact.toString();
        } else {
             return "";
        }
    }
}
