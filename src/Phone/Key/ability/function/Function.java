package phone.key.ability.function;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.AnchorPane;
import phone.Phone;
import phone.key.IntegerFromString;
import phone.key.PhoneKey;
import phone.key.TimeForClickValue;
import phone.screen.basescreen.BaseScreen;
import phone.screen.basescreen.BaseScreenController;
import phone.screen.callingscreen.callingsomeone.CallingScreen;
import phone.screen.mainmenu.MainMenuScreen;
import phone.screen.registerednumbers.contact.Contact;
import phone.screen.textingscreen.MessageScreenController;
import phone.utility.IdentifyNumber;
import server.registeredphonecard.archive.RecordManagement;
import server.registeredphonecard.archive.RecordServer;

import java.util.List;

public class Function<T> {
    Phone phone;
    T list;
    BaseScreenController baseScreenController;
    TimeForClickValue timeForClickValue;

    public Function(Phone phone, T list) {
        this(phone);
        this.list = list;

    }

    public Function(Phone phone) {
        this.phone = phone;
        timeForClickValue = phone.getPhoneController().getTimeForClickValue();
    }

    public void changeScreenToMainScreen() {
        changeScreen(new MainMenuScreen(phone), null);
        phone.getScreenStack().clearScreenStack();
    }

    public void changeScreen(BaseScreen newScreen, BaseScreen oldScreenNewInitialize) {
        AnchorPane phoneScreenAnchorPane = phone.getPhoneController().getScreenAnchorPane();
        BaseScreen phoneScreen = phone.getPhoneController().getScreen();
        if (oldScreenNewInitialize != null) {
            addScreenToStack(oldScreenNewInitialize, newScreen);
        } else {
            addScreenToStack(phoneScreen, newScreen);
        }
        deleteScreenItem(phoneScreenAnchorPane);
        addScreenItem(phoneScreenAnchorPane, newScreen);
        updateAllChanges();
    }

    void addScreenToStack(BaseScreen phoneScreen, BaseScreen newScreen) {

        if (!phoneScreen.getClass().getSimpleName().equals(newScreen.getClass().getSimpleName()))
            phone.getScreenStack().addCurrentScreenToStack(phoneScreen);

    }


    void deleteScreenItem(AnchorPane screen) {
        screen.getChildren().remove(0);
    }

    void addScreenItem(AnchorPane screenPlace, BaseScreen newScreen) {
        screenPlace.getChildren().add(newScreen);
    }

    public void changeScreenToLastScreen() {
        if (!phone.getScreenStack().isScreenStackEmpty()) {
            AnchorPane oldScreen = phone.getPhoneController().getScreenAnchorPane();
            deleteScreenItem(oldScreen);
            BaseScreen newScreen = phone.getScreenStack().popLastScreenFromScreenStack();
            addScreenItem(oldScreen, newScreen);
            updateAllChanges();
        }


    }

    public void activateKeyByLastScreenController(Phone phone) {
        BaseScreen lastScreen = phone.getScreenStack().peekLastScreenFromScreenStack();
        lastScreen.getController().updateAllPhone();
    }

    public void callPhoneNumber(Contact contact) {
        BaseScreen basePhoneScreen = new CallingScreen(phone, contact);
        AnchorPane phoneScreenAnchorPane = phone.getPhoneController().getScreenAnchorPane();
        deleteScreenItem(phoneScreenAnchorPane);
        addScreenItem(phoneScreenAnchorPane, basePhoneScreen);
        basePhoneScreen.getController().executeProcess();
    }

    public void sendMessageToEveryOneInContactlist(List<Contact> contactList, String message) {
        int a = 0;
        for (Contact item : contactList) {
            a++;
            sendMessage(item, message);
        }
        if (contactList.size() > 0)
            changeScreenToLastScreen();
    }

    void sendMessage(Contact contact, String message) {
        ((MessageScreenController) phone.getPhoneController().getScreenController()).sendMessage(contact, message);
    }


    public void updateScreenController(BaseScreenController baseScreenController) {
        baseScreenController.updateAllPhone();
    }

    public void printIntegerValueToTextInputControl(TextInputControl textInputControl, PhoneKey phoneKey) {

        if (!isNull(textInputControl)) {
            String newStringCharacter = getIntegerValue(phoneKey);

            String text = textInputControl.getText();
            text += newStringCharacter;
            textInputControl.setText(text);

            updateAllChanges();
        }


    }

    public void printStringValueToTextInputControl(TextInputControl textInputControl, PhoneKey phoneKey) {

        if (!isNull(textInputControl)) {
            String newStringCharacter = getStringValue(phoneKey);

            if (!phoneKey.getController().isCanBeAddNewCharacter()) {
                deleteLastLetter(textInputControl);
            }

            String text = textInputControl.getText();
            text += newStringCharacter;
            textInputControl.setText(text);

            updateAllChanges();
        } else {
        }
    }

    public void scrollUpTextArea(TextArea textArea) {
        scrollTextArea(textArea, false);

    }

    public void scrollDownTextArea(TextArea textArea) {
        scrollTextArea(textArea, true);

    }

    public void scrollTextArea(TextArea textArea, boolean seeDownText) {
        double scale = textArea.getScrollTop();
        if (seeDownText) {
            scale += textArea.getFont().getSize();
        } else {
            scale -= textArea.getFont().getSize();
        }
        textArea.setScrollTop(scale);

    }

    boolean isNull(Object object) {
        if (object == null)
            return true;
        return false;

    }

    String getIntegerValue(PhoneKey phoneKey) {
        String value = phoneKey.getController().getIntegerValue();
        return value;
    }

    String getStringValue(PhoneKey phoneKey) {
        String value = phoneKey.getController().getStringValue();
        return value;
    }

    /**
     * this function is used to update all phone  after execution of an updation process like  texfield
     * or something that is added value like textfield to get last value of these editable value objects
     * -> this update is essential especial for texfield.
     */
    public void updateAllChanges() {
        ((BaseScreen) (phone.getPhoneController().getScreenAnchorPane().getChildren().get(0))).getController().updateAllPhone();
    }

    /**
     * this function is used to update all phone of given screen controller
     */

    public Contact getRegisteredContactInPhoneByPhoneNumber(String phoneNumber) {
        Contact contact = new IdentifyNumber(phone).identifyNumber(phoneNumber);
        if (contact != null)
            return contact;

        return new Contact(null, phoneNumber);
    }

    public void deleteLastLetter(TextInputControl textInputControl) {
        String text = "";
        for (int i = 0; i < textInputControl.getText().length() - 1; i++) {
            text += textInputControl.getText().charAt(i);
        }
        textInputControl.setText(text);
    }
}
