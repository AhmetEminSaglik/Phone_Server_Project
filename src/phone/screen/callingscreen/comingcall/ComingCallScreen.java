package phone.screen.callingscreen.comingcall;

import phone.Phone;
import phone.screen.callingscreen.BaseCallScreen;
import phone.screen.callingscreen.BaseCallScreenController;
import phone.screen.registerednumbers.contact.Contact;

public class ComingCallScreen extends BaseCallScreen {

    public ComingCallScreen(Phone phone, Contact contact) {
        super(phone, new ComingCallScreenController(phone, contact));
    }
}
