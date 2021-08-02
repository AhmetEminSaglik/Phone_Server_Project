package phone.screen.basescreen;

import phone.key.PhoneKey;
import phone.key.PhoneKeyWanted;
import phone.key.ability.KeyAbility;
import phone.Phone;
import javafx.fxml.Initializable;
import phone.key.ability.NumberKeyEvent;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public abstract class
BaseScreenController implements Initializable {
    protected Phone phone;

    protected NumberKeyEvent numberKeyEvent;
    protected KeyAbility keyAbility;
    protected PhoneKey phoneKey;
    protected boolean screenIsLoaded = false;
//    protected  BaseScreen baseScreen;

    public BaseScreenController(Phone phone) {
        this.phone = phone;
        numberKeyEvent = new NumberKeyEvent(phone);
//        updateAllPhone();
    }

    /**
     * Update screen and KeyEvents*/
    public final void updateAllPhone() {
//        phone.addCurrentScreenToStack();
//        System.out.println("updateAllPhone --> GELDI ");

        if (!isScreenLoaded()) {
            updateScreen();
            screenIsLoaded = true;
        }
//        System.out.println("DONGUDE MI ?? (BaseScreenController) "+this.getClass().getSimpleName());
        updateKeysEvent();
//numberKeyEvent.updateAllChanges();
    }

    public void executeProcess() {

    }

    public void updateKeysEvent() {
        addActionToOperatorKeys();
        addActionToNumberKeys();

    }

    public void updateScreen() {

    }

    public void addActionToOperatorKeys() {
        numberKeyEvent.setEventToGoBackScreen(getWantedPhoneKey(phone, 0, 2));
        numberKeyEvent.setEventToOpenEnterPhoneNumberScreen(getWantedPhoneKey(phone, 1, 0));
        numberKeyEvent.setEventToChangeScreenToMainMenuScreen(getWantedPhoneKey(phone, 1, 2));

    }


    public void addActionToNumberKeys() {
        numberKeyEvent.setEventToOpenEnterPhoneNumberScreen(getNumberKeyList());

    }


    boolean isScreenLoaded() {
        return screenIsLoaded;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public PhoneKey getWantedPhoneKey(Phone phone, int row, int column) {
        return new PhoneKeyWanted(phone).getPhoneKey(row, column);
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public List getNumberKeyList() {
        return phone.getPhoneController().getPhoneKeyList().getNumberKeyList();
    }

    public List getOperatorKeyList() {
        return phone.getPhoneController().getPhoneKeyList().getOperatorKeyList();
    }
}
