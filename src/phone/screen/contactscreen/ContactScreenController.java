package phone.screen.contactscreen;

import phone.Phone;
import phone.screen.addPhoneNumber.AddPhoneNumberScreen;
import phone.screen.callhistoryscreen.CallHistoryScreen;
import phone.screen.listviewscreen.ListViewScreenController;
import phone.screen.listviewscreen.listViewCard.OptionScreenCard;
import phone.screen.registerednumbers.RegisteredPhoneNumberScreen;

public class ContactScreenController extends ListViewScreenController {
    public ContactScreenController(Phone phone) {
        super(phone);
    }

    @Override
    public void preparePhoneScreenList() {

        addItemtoMenuList(new OptionScreenCard("Registered Numbers", new RegisteredPhoneNumberScreen(phone)));
        addItemtoMenuList(new OptionScreenCard("Add Number", new AddPhoneNumberScreen(phone)));
    }

    @Override
    public void setSwitchScreenParamaters() {
        numberKeyEvent.setEventToSwitchScreen(getWantedPhoneKey(phone, 0, 0),
                menuListView.getSelectionModel().getSelectedItem().getPhoneScreen(), new ContactScreen(phone));
    }
}
