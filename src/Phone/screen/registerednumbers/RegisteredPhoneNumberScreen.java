package phone.screen.registerednumbers;

import phone.Phone;
import phone.screen.listviewscreen.ListViewScreen;

public class RegisteredPhoneNumberScreen extends ListViewScreen {

    public RegisteredPhoneNumberScreen(Phone phone) {
        super(phone, new RegisteredPhoneNumberScreenController(phone));
        ((RegisteredPhoneNumberScreenController) baseScreenController).setRegisteredPhoneNumberScreen(this);
    }


}
