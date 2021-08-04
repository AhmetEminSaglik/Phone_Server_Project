package phone.screen.addPhoneNumber;

import phone.Phone;
import phone.screen.basescreen.BaseScreenController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import phone.utility.TextInputControlList;

import java.net.URL;
import java.util.ResourceBundle;

public class AddPhoneNumberScreenController extends BaseScreenController {

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSurname;

    @FXML
    private TextField txtPhoneNo;

    TextInputControlList textInputControlList = new TextInputControlList();

    public AddPhoneNumberScreenController(Phone phone) {
        super(phone);
    }

    @Override
    public void updateKeysEvent() {
        super.updateKeysEvent();
    }

    @Override
    public void updateScreen() {
        textInputControlList.add(txtName);
        textInputControlList.add(txtSurname);
        textInputControlList.add(txtPhoneNo);
    }

    @Override
    public void addActionToOperatorKeys() {
        numberKeyEvent.setEventToSaveContact(getWantedPhoneKey(phone, 0, 0), textInputControlList);
        numberKeyEvent.setEventToDeleteLastLetter(getWantedPhoneKey(phone, 0, 2), textInputControlList.selectOnIndex());
        numberKeyEvent.setEventToSelectPreviousOnList(getWantedPhoneKey(phone, 0, 1), textInputControlList);
        numberKeyEvent.setEventToSelectNextOnList(getWantedPhoneKey(phone, 1, 1), textInputControlList);
    }

    @Override
    public void addActionToNumberKeys() {
        if (textInputControlList.selectOnIndex().getId().equals(txtPhoneNo.getId())) {
            numberKeyEvent.setEventToPrintIntegerInTextInputControl(phone.getPhoneController().getPhoneKeyList().getNumberKeyList(), textInputControlList.selectOnIndex());
        } else {
            numberKeyEvent.setEventToPrintInTextInputControl(phone.getPhoneController().getPhoneKeyList().getNumberKeyList(), textInputControlList.selectOnIndex());
        }
        textInputControlList.selectOnIndex().getOnMouseClicked();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
