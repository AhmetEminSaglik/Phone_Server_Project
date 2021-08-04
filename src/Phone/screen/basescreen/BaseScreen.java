package phone.screen.basescreen;

import phone.Phone;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public abstract class
BaseScreen extends AnchorPane {
    protected Phone phone;
    protected BaseScreenController baseScreenController;

    public BaseScreen(Phone phone) {
        this.phone = phone;
    }

    public void loadFxmlFile(String fxmlPath) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
        fxmlLoader.setController(baseScreenController);
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException ex) {
            System.out.println("EXCEPTION " + ex.getMessage() + ">>");
            System.exit(0);
        }

    }

    public Phone getPhone() {
        return phone;
    }

    public BaseScreenController getController() {
        return baseScreenController;
    }

}
