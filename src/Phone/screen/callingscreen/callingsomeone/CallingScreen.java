package phone.screen.callingscreen.callingsomeone;

import phone.Phone;
import phone.screen.callingscreen.BaseCallScreen;
import phone.screen.registerednumbers.contact.Contact;

public class CallingScreen extends BaseCallScreen {

    public CallingScreen(Phone phone, Contact contact) {
        super(phone, new CallingScreenController(phone, contact));
//        this.contact=contact;
    }
}
