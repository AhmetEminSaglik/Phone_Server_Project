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

    }

    @Override
    public void executeProcess() {
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


}
