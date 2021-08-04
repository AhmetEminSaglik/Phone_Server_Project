package phone.screen.addPhoneNumber;

import phone.Phone;
import phone.screen.basescreen.BaseScreen;

public class AddPhoneNumberScreen extends BaseScreen {
    public AddPhoneNumberScreen(Phone phone) {
        super(phone);
        this.baseScreenController = new AddPhoneNumberScreenController(phone);
        loadFxmlFile("AddPhoneNumberScreen.fxml");
    }

}
