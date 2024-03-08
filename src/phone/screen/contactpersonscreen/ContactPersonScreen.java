package phone.screen.contactpersonscreen;

import phone.Phone;
import phone.screen.listviewscreen.ListViewScreen;
import phone.screen.registerednumbers.contact.Contact;

public class ContactPersonScreen extends ListViewScreen {

   protected Contact contact;
    public ContactPersonScreen(Phone phone,Contact contact) {
        super(phone, new ContactPersonScreenController(phone,contact));
        this.contact=contact;
    }
}
