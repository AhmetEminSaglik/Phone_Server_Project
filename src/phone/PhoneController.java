package phone;

import css.PhoneKeyCssString;
import phone.key.PhoneKey;
import phone.key.PhoneKeyController;
import phone.key.TimeForClickValue;
import phone.key.ability.function.Function;
import phone.screen.basescreen.BaseScreen;
import phone.screen.basescreen.BaseScreenController;
import phone.screen.callingscreen.comingcall.ComingCallScreen;
import phone.screen.mainmenu.MainMenuScreen;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import phone.screen.registerednumbers.contact.Contact;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PhoneController implements Initializable {

    private Phone phone;

    private TimeForClickValue timeForClickValue;
    private PhoneKeyList phoneKeyList = new PhoneKeyList();

    public PhoneController(Phone phone, TimeForClickValue timeForClickValue) {
        this.phone = phone;
        this.timeForClickValue = timeForClickValue;
    }

    @FXML
    private AnchorPane screenAnchorPane;

    @FXML
    private VBox phoneVBoxLayer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addKeys();
        addScreen();
    }

    public BaseScreen getScreen() {
        return ((BaseScreen) screenAnchorPane.getChildren().get(0));
    }

    public BaseScreenController getScreenController() {
        return getScreen().getController();
    }

    void addScreen() {
        BaseScreen phoneScreen = new MainMenuScreen(phone);
        screenAnchorPane.getChildren().add(phoneScreen);

        BaseScreen firstScreen = getScreen();
        firstScreen.getController().updateAllPhone();
        phone.getScreenStack().addCurrentScreenToStack(firstScreen);
    }

    public void beingCalledByThisContact(Contact contact) {
        BaseScreen comingCallScreen = new ComingCallScreen(phone, contact);
        new Function(phone).changeScreen(comingCallScreen, null);

    }

    void addKeys() {
        List<String> cssList = new ArrayList();

        HBox floor;
        floor = createPhoneFloor();
        PhoneKey phoneKey;

        PhoneKeyCssString css = new PhoneKeyCssString();
        cssList.add(css.getBigSize());

        operatorKeyExecuteAddingProcess("---", "select", cssList, floor);
        operatorKeyExecuteAddingProcess("Ʌ", "goUp", cssList, floor);
        operatorKeyExecuteAddingProcess("---", "goBack", cssList, floor);

        floor = createPhoneFloor();
        cssList.add(css.getBtnCallOpen());


        operatorKeyExecuteAddingProcess("---", "call", cssList, floor);
        cssList.remove(css.getBtnCallOpen());
        operatorKeyExecuteAddingProcess("∨", "goDown", cssList, floor);
        cssList.add(css.getBtnHangUp());
        operatorKeyExecuteAddingProcess("---", "HangUp", cssList, floor);

        cssList.clear();
        floor = createPhoneFloor();

        numberKeyExecuteAddingProcess("1.,", "1", null, floor);
        numberKeyExecuteAddingProcess("ABC2", "2", null, floor);
        numberKeyExecuteAddingProcess("DEF3", "3", null, floor);

        floor = createPhoneFloor();

        numberKeyExecuteAddingProcess("GHI4", "4", null, floor);
        numberKeyExecuteAddingProcess("JKL5", "5", null, floor);
        numberKeyExecuteAddingProcess("MNO6", "6", null, floor);

        floor = createPhoneFloor();

        numberKeyExecuteAddingProcess("PQRS7", "7", null, floor);
        numberKeyExecuteAddingProcess("TUV8", "8", null, floor);
        numberKeyExecuteAddingProcess("WXYZ9", "9", null, floor);

        floor = createPhoneFloor();

        numberKeyExecuteAddingProcess("*!?", "star", null, floor);
        numberKeyExecuteAddingProcess("0 +", "0", null, floor);
        numberKeyExecuteAddingProcess("#-_", "square", null, floor);

    }

    void numberKeyExecuteAddingProcess(String text, String keyId, List<String> cssList, HBox floor) {
        addNumberKeyList(executeAddingProcessKey(text, keyId, cssList, floor));
    }

    void operatorKeyExecuteAddingProcess(String text, String keyId, List<String> cssList, HBox floor) {
        addOperatorKeyList(executeAddingProcessKey(text, keyId, cssList, floor));
    }

    PhoneKey executeAddingProcessKey(String text, String keyId, List<String> cssList, HBox floor) {

        PhoneKey phoneKey = createNumberPhoneKey(text, keyId);
        addSpecialKey(cssList, phoneKey, floor);
        addOperatorKeyList(phoneKey);
        return phoneKey;
    }

    PhoneKey createNumberPhoneKey(String text, String keyId) {
        PhoneKey phoneKey = new PhoneKey(text, new PhoneKeyController(), timeForClickValue);
        phoneKey.setId(keyId + "Key");
        phoneKey.setCursor(Cursor.HAND);

        return phoneKey;
    }


    void addSpecialKey(List<String> css, PhoneKey phoneKey, HBox floor) {
        if (css != null) {
            for (String item : css) {
                phoneKey.getStyleClass().add(item);
            }
        }
        addKey(phoneKey, floor);

    }

    void addKey(PhoneKey phoneKey, HBox floor) {
        addCssToPhoneKey(phoneKey);
        floor.getChildren().add(phoneKey);
    }

    void addCssToPhoneKey(PhoneKey phoneKey) {
        phoneKey.getStylesheets().add(getClass().getResource("../Css/PhoneKeyBtn.css").toExternalForm());
    }


    HBox createPhoneFloor() {
        HBox hBox = new HBox();
        hBox.setSpacing(30);
        hBox.setPrefHeight(screenAnchorPane.getPrefHeight());
        hBox.setPrefWidth(screenAnchorPane.getPrefWidth());
        hBox.setAlignment(Pos.CENTER);
        addFloorToPhoneLayer(hBox);

        return hBox;
    }

    void addFloorToPhoneLayer(HBox floor) {
        phoneVBoxLayer.getChildren().add(floor);

    }

    public Phone getPhone() {
        return phone;
    }

    public VBox getPhoneVBoxLayer() {
        return phoneVBoxLayer;
    }

    public AnchorPane getScreenAnchorPane() {
        return screenAnchorPane;
    }

    public void setScreenAnchorPane(AnchorPane screenAnchorPane) {
        this.screenAnchorPane = screenAnchorPane;
    }

    public void addOperatorKeyList(PhoneKey phoneKey) {
        phoneKeyList.getOperatorKeyList().add(phoneKey);
    }

    public void addNumberKeyList(PhoneKey phoneKey) {
        phoneKeyList.getNumberKeyList().add(phoneKey);
    }

    public PhoneKeyList getPhoneKeyList() {
        return phoneKeyList;
    }

    public TimeForClickValue getTimeForClickValue() {
        return timeForClickValue;
    }
}
