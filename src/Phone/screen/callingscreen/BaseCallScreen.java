package phone.screen.callingscreen;

import phone.Phone;
import phone.screen.basescreen.BaseScreen;
import phone.screen.registerednumbers.contact.Contact;

public abstract class BaseCallScreen extends BaseScreen {
    protected Contact contact;

//    public BaseCallScreen(Phone phone, Contact contact) {
//        super(phone);
//        this.baseScreenController = new BaseCallScreenController(phone, contact);
//        loadFxmlFile("BaseCallScreen.fxml");
//    }

    public BaseCallScreen(Phone phone,  BaseCallScreenController callingScreenController) {
        super(phone);
         this.baseScreenController = callingScreenController;
        contact = callingScreenController.contact;
        loadFxmlFile("../BaseCallScreen.fxml");
    }


}
