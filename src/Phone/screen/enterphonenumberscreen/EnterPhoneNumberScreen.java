package phone.screen.enterphonenumberscreen;

import phone.Phone;
import phone.screen.basescreen.BaseScreen;
import phone.screen.basescreen.BaseScreenController;

public class EnterPhoneNumberScreen extends BaseScreen {


    public EnterPhoneNumberScreen(Phone phone) {
        super(phone);
        this.baseScreenController = new EnterPhoneNumberScreenController(phone);
        loadFxmlFile("EnterPhoneNumberScreen.fxml");


    }

    @Override
    public BaseScreenController getController() {

        return baseScreenController;


    }

}
