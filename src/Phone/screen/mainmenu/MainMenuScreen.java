package phone.screen.mainmenu;

import phone.Phone;
import phone.screen.listviewscreen.ListViewScreen;

public class MainMenuScreen extends ListViewScreen {

    public MainMenuScreen(Phone phone) {
        super(phone, new MainMenuScreenController(phone));

    }

}

