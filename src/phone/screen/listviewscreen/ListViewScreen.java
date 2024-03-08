package phone.screen.listviewscreen;

import phone.Phone;
import phone.screen.basescreen.BaseScreen;
import phone.screen.basescreen.BaseScreenController;

public abstract class ListViewScreen extends BaseScreen {

    public ListViewScreen(Phone phone, BaseScreenController baseScreenController) {
        super(phone);
        this.baseScreenController = baseScreenController;
        loadFxmlFile("../listviewscreen/ListViewScreen.fxml");

    }


}
