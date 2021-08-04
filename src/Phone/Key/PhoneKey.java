package phone.key;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import java.io.IOException;

public class PhoneKey extends Button {
    PhoneKeyController controller;
    TimeForClickValue timeForClickValue;

    public PhoneKey(String text, PhoneKeyController phoneKeyController, TimeForClickValue timeForClickValue) {
        this.controller = phoneKeyController;
        this.timeForClickValue = timeForClickValue;
        controller.setTimeForClickValue(timeForClickValue);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PhoneKey.fxml"));
        fxmlLoader.setRoot(this);

        fxmlLoader.setController(phoneKeyController);
        phoneKeyController.setBtnText(text);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            System.out.println("HATAAA ::: >>> " + exception.getMessage());
            throw new RuntimeException(exception.getMessage());

        }
    }

    public PhoneKeyController getController() {
        return controller;
    }
}
