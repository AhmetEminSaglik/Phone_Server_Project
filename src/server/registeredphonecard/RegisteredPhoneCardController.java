package server.registeredphonecard;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisteredPhoneCardController implements Initializable {

    @FXML
    private Label lblPhoneNumber;

    @FXML
    private Circle phoneSituation;

    @FXML
    private Button btnPhoneActivateOrUnActivate;

    @FXML
    void btnShowHide(ActionEvent event) {

    }

    private String phoneNumber;


    public RegisteredPhoneCardController(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        lblPhoneNumber.setText(phoneNumber);
    }

    public Circle getPhoneSituation() {
        return phoneSituation;
    }

    public void setPhoneSituation(Circle phoneSituation) {
        this.phoneSituation = phoneSituation;
    }

    public Button getBtnPhoneActivateOrUnActivate() {
        return btnPhoneActivateOrUnActivate;
    }

    public void setBtnPhoneActivateOrUnActivate(Button btnPhoneActivateOrUnActivate) {
        this.btnPhoneActivateOrUnActivate = btnPhoneActivateOrUnActivate;
    }
}
