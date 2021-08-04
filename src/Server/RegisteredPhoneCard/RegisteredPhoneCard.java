package server.registeredphonecard;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import phone.Phone;

import java.io.IOException;

public class RegisteredPhoneCard extends AnchorPane {
    private RegisteredPhoneCardController registeredPhoneCardController;

    Phone phone;

    public RegisteredPhoneCard(Phone phone) {
        this.phone = phone;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RegisteredPhoneCard.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(new RegisteredPhoneCardController(phone.getNumber()));
        try {
            fxmlLoader.load();

            this.registeredPhoneCardController = fxmlLoader.getController();

        } catch (IOException exception) {
            System.out.println("Exception : " + exception.getMessage());
            throw new RuntimeException(exception.getMessage());
        }
    }


    public RegisteredPhoneCardController getRegisteredPhoneCardController() {
        return registeredPhoneCardController;
    }

    public void setRegisteredPhoneCardController(RegisteredPhoneCardController registeredPhoneCardController) {
        this.registeredPhoneCardController = registeredPhoneCardController;
    }

    public Circle getPhoneSituation() {
        return registeredPhoneCardController.getPhoneSituation();
    }

    public Button getBtnActivateOrUnActivate() {
        return registeredPhoneCardController.getBtnPhoneActivateOrUnActivate();
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
