package phone.screen.textingscreen;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import phone.Phone;
import phone.screen.basescreen.BaseScreenController;
import phone.screen.registerednumbers.contact.Contact;
import phone.utility.IdentifyNumber;
import phone.utility.TextInputControlList;

import java.util.ArrayList;
import java.util.List;

public class MessageScreenController extends BaseScreenController {
    Contact contact;
    List<Contact> contactListToSendMessage = new ArrayList<Contact>();
    String message;

    TextInputControlList textInputControlList = new TextInputControlList();

    public MessageScreenController(Phone phone, Contact contact) {
        super(phone);
        this.contact = contact;
    }

    @FXML
    private TextField txtFieldToWhom;


    @FXML
    private TextArea TextAreaMessage;

    @Override
    public void updateKeysEvent() {
        super.updateKeysEvent();
        scrollTextArea();
    }

    @Override
    public void updateScreen() {
        if (contact != null) {

            txtFieldToWhom.setText(contact.getPerson().toString());
            textInputControlList.add(getTextAreaMessage());
        } else {

            textInputControlList.add(getTxtFieldToWhom());
            textInputControlList.add(getTextAreaMessage());
        }


    }

    @Override
    public void addActionToOperatorKeys() {
        numberKeyEvent.setEventToSendMessage(getWantedPhoneKey(phone, 0, 0), this);
        numberKeyEvent.setEventToDeleteLastLetter(getWantedPhoneKey(phone, 0, 2), textInputControlList.selectOnIndex());
        numberKeyEvent.setEventToSelectPreviousOnList(getWantedPhoneKey(phone, 0, 1), textInputControlList);
        numberKeyEvent.setEventToSelectNextOnList(getWantedPhoneKey(phone, 1, 1), textInputControlList);
    }

    void scrollTextArea() {

        getTextAreaMessage().setScrollTop(getTextAreaMessage().computeAreaInScreen());
        getTextAreaMessage().setScrollLeft(getTextAreaMessage().computeAreaInScreen());

    }

    @Override
    public void addActionToNumberKeys() {
        if (textInputControlList.selectOnIndex().getId().equals(txtFieldToWhom.getId())) {
            numberKeyEvent.setEventToPrintIntegerInTextInputControl(phone.getPhoneController().getPhoneKeyList().getNumberKeyList(), textInputControlList.selectOnIndex());
        } else {
            numberKeyEvent.setEventToPrintInTextInputControl(phone.getPhoneController().getPhoneKeyList().getNumberKeyList(), textInputControlList.selectOnIndex());
        }
        textInputControlList.selectOnIndex().getOnMouseClicked();
    }
    public void sendMessage(Contact contact, String message) {
        SendingMessage sendingMessage = new SendingMessage(phone, contact);
        sendingMessage.sendMessage(message);
    }

    public void getLastUpdationBeforeSendingMessage() {
        updateContactList();
        updateMessageText();
    }

    void updateMessageText() {
       message = getTextAreaMessage().getText();
    }

    void updateContactList() {
        if (contact != null) {
            contactListToSendMessage.add(contact);
        } else {
            if (getTxtFieldToWhom().getText().length() > 0) {
                String phoneNumber = "";
                String chracterInTextIndex = "";
                String enteredPhoneNumber = getTxtFieldToWhom().getText();
                for (int i = 0; i < enteredPhoneNumber.length(); i++) {
                    phoneNumber += Character.toString(enteredPhoneNumber.charAt(i));
                }
                Contact contact = new IdentifyNumber(phone).identifyNumber(phoneNumber);
                if (contact != null) {
                    contactListToSendMessage.add(contact);
                } else {
                    contact = new Contact(null, phoneNumber);
                    contactListToSendMessage.add(contact);
                }

            } else {
                getTxtFieldToWhom().setPromptText("Please enter phone number");
            }
        }
    }

    public String getMessage() {
        return message;
    }

    public List<Contact> getContactListToSendMessage() {

        return contactListToSendMessage;
    }

    public TextField getTxtFieldToWhom() {
        return txtFieldToWhom;
    }

    public void setTxtFieldToWhom(TextField txtFieldToWhom) {
        this.txtFieldToWhom = txtFieldToWhom;
    }

    public TextArea getTextAreaMessage() {
        return TextAreaMessage;
    }

    public void setTextAreaMessage(TextArea textAreaMessage) {
        TextAreaMessage = textAreaMessage;
    }

}
