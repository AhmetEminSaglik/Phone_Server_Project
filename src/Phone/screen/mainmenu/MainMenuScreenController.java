package phone.screen.mainmenu;

import phone.Phone;
import phone.screen.callhistoryscreen.CallHistoryScreen;
import phone.screen.contactscreen.ContactScreen;
import phone.screen.listviewscreen.ListViewScreenController;
import phone.screen.listviewscreen.listViewCard.OptionScreenCard;
import phone.screen.messagehistoryscreen.MessageHistoryScreen;


public class MainMenuScreenController extends ListViewScreenController {

    public MainMenuScreenController(Phone phone) {
        super(phone);
    }

    @Override
    public void setSwitchScreenParamaters() {
        numberKeyEvent.setEventToSwitchScreen(getWantedPhoneKey(phone, 0, 0),
                menuListView.getSelectionModel().getSelectedItem().getPhoneScreen(), new MainMenuScreen(phone));
    }

    @Override
    public void preparePhoneScreenList() {
        getLblBack().setVisible(false);
        addItemtoMenuList(new OptionScreenCard("Contact", new ContactScreen(phone)));
        addItemtoMenuList(new OptionScreenCard("Call", new CallHistoryScreen(phone)));
        addItemtoMenuList(new OptionScreenCard("Message", new MessageHistoryScreen(phone)));
    }

}
