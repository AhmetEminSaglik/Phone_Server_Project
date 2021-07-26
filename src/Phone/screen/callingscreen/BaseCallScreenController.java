package phone.screen.callingscreen;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import phone.Phone;
import phone.screen.basescreen.BaseScreenController;
import phone.screen.registerednumbers.contact.Contact;


public abstract class BaseCallScreenController extends BaseScreenController {
    @FXML
    private Label lblContactInfo;

    @FXML
    private Label lblTime;

    @FXML
    private Label lblSituation;
    protected Contact contact;

    public BaseCallScreenController(Phone phone, Contact contact) {
        super(phone);
        this.contact = contact;

//        Aradiktan sonra  yanlis numarada ya da hatali olunca tuslarin kabiliyeti geri gelmmyur
    }
    @Override
    public void executeProcess() {
//        callContact();
    }


    public String getTextLblContactInfo() {
        return lblContactInfo.getText();
    }

    public void setTextLblContactInfo(String text) {
        lblContactInfo.setText(text);
    }

    public String getTextLblTime() {
        return lblTime.getText();
    }

    public void setTextLblTime(String text) {
        lblTime.setText(text);
    }

    public Label getLblSituation() {
        return lblSituation;
    }

    public void setLblSituation(Label lblSituation) {
        this.lblSituation = lblSituation;
    }

    public String getTextLblSituation() {
        return lblSituation.getText();
    }

    public void setTextLblSituation(String text) {
        lblSituation.setText(text);
    }


//    @Override
//    public void addActionToOperatorKeys() {
////        String phone.message="!!! Telefon arandiginda Eger karsidaki kisinin cevap vermesi beklenyorsa sadece kapatma tusu aktif edilir\n" +
////                "Eger telefon arandiginda caliyorsa sadece  acma ve kapatma tusu aktif edilir.";
////        MyNote.showMessageDialog(phone.message);
////        super.addActionToOperatorKeys();
////        numberKeyEvent.clearEvent(phone.getPhoneController().getPhoneKeyList().getOperatorKeyList());
//
//
//    }

//    void disableKey(List<PhoneKey> list) {
//        numberKeyEvent.clearEvent(list);
//
//    }
//
//    @Override
//    public void addActionToOperatorKeys() {
////        super.addActionToOperatorKeys();
////        numberKeyEvent.clearEvent(phone.getPhoneController().getPhoneKeyList().getOperatorKeyList());
////        disableKey(getOperatorKeyList());
//
//    }
//
//    @Override
//    public void addActionToNumberKeys() {
////        numberKeyEvent.clearEvent(phone.getPhoneController().getPhoneKeyList().getNumberKeyList());
////        disableKey(getNumberKeyList());
//    }


    //    public Label getLblContactInfo() {
//        return lblContactInfo;
//    }
//
//    public Label getLblTime() {
//        return lblTime;
//    }
//
//    public Label getLblSituation() {
//        return lblSituation;
//    }
}
