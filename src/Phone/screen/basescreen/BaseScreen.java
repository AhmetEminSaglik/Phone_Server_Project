package phone.screen.basescreen;

import phone.Phone;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public abstract class
BaseScreen extends AnchorPane {
    protected Phone phone;
    //    protected String fxmlPath;
    protected BaseScreenController baseScreenController;


    public BaseScreen(Phone phone) {
        this.phone = phone;

    }


    public void loadFxmlFile(String fxmlPath) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));//"Screen/Types/mainscreen/MainMenuScreen.fxml" ____iFxmlVariables.getFxmlLoader(); //new FXMLLoader(getClass().getResource("")); //".fxml"
        fxmlLoader.setController(baseScreenController);
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();

//            System.out.println(fxmlLoader.getClassLoader());
//            System.out.println(fxmlLoader.getLocation());
        } catch (IOException ex) {
            System.out.println("HATAAA >>> PHNOESCREEN " + ex.getMessage() + ">>");
            System.exit(0);


        }
//        System.out.println("((BaseScreen)phone.getPhoneController().getScreenAnchorPane().getChildren().get(0)) :"

//        if (phone.getPhoneController().getScreenAnchorPane().getChildren().size() > 0) {
//            getController().updateAllPhone();
//        }
//if(((BaseScreen)phone.getPhoneController().getScreenAnchorPane().getChildren().get(0))==this)
//        getController().updateAllPhone();

    }

    public Phone getPhone() {
        return phone;
    }

    public BaseScreenController getController() {
        return baseScreenController;
    }

}
