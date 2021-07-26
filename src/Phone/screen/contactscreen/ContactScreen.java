package phone.screen.contactscreen;

import phone.Phone;
import phone.screen.basescreen.BaseScreenController;
import phone.screen.listviewscreen.ListViewScreen;

public class ContactScreen extends ListViewScreen {
    public ContactScreen(Phone phone) {
        super(phone, new ContactScreenController(phone));
    }
}
