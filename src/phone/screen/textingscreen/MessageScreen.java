package phone.screen.textingscreen;

import phone.Phone;
import phone.screen.basescreen.BaseScreen;
import phone.screen.registerednumbers.contact.Contact;

public class MessageScreen extends BaseScreen {

    public MessageScreen(Phone phone, Contact contact) {
        super(phone);
        this.baseScreenController = new MessageScreenController(phone, contact);
        loadFxmlFile("MessageScreen.fxml");
    }
}
