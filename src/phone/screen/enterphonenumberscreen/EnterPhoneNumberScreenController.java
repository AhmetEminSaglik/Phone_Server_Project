package phone.screen.enterphonenumberscreen;

import phone.Phone;
import phone.screen.basescreen.BaseScreenController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class EnterPhoneNumberScreenController extends BaseScreenController {

    @FXML
    private TextField txtWillBeEnteredPhoneNumber;

    List txtFieldList = new ArrayList<TextField>();

    public EnterPhoneNumberScreenController(Phone phone) {
        super(phone);
        txtFieldList.add(txtWillBeEnteredPhoneNumber);
    }

    public void updateKeysEvent() {
        super.updateKeysEvent();
    }


    @Override
    public void addActionToOperatorKeys() {
        numberKeyEvent.setEventToCallNumberByPhoneNumber(getWantedPhoneKey(phone, 0, 0), txtWillBeEnteredPhoneNumber.getText());
        numberKeyEvent.setEventToDeleteLastLetter(getWantedPhoneKey(phone, 0, 2), txtWillBeEnteredPhoneNumber);
        numberKeyEvent.setEventToCallNumberByPhoneNumber(getWantedPhoneKey(phone, 1, 0), txtWillBeEnteredPhoneNumber.getText());
        numberKeyEvent.setEventToChangeScreenToMainMenuScreen(getWantedPhoneKey(phone, 1, 2));
    }

    @Override
    public void addActionToNumberKeys() {
        numberKeyEvent.setEventToPrintIntegerInTextInputControl(phone.getPhoneController().getPhoneKeyList().getNumberKeyList(), txtWillBeEnteredPhoneNumber);
    }


}
