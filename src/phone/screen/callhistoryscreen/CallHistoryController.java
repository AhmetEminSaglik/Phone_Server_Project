package phone.screen.callhistoryscreen;

import phone.Phone;
import phone.screen.enterphonenumberscreen.EnterPhoneNumberScreen;
import phone.screen.listviewscreen.ListViewScreenController;
import phone.screen.listviewscreen.listViewCard.Card;
import phone.screen.listviewscreen.listViewCard.ContactCard;
import phone.screen.listviewscreen.listViewCard.OptionScreenCard;
import phone.screen.listviewscreen.listViewCard.CallHistoryCard;
import phone.screen.registerednumbers.contact.Contact;
import phone.screen.registerednumbers.contact.Person;

import java.util.List;

public class CallHistoryController extends ListViewScreenController {
    CallHistoryScreen callHistory;

    public CallHistoryController(Phone phone) {
        super(phone);
    }

    @Override
    public void setSwitchScreenParamaters() {
        numberKeyEvent.setEventToSwitchScreen(getWantedPhoneKey(phone, 0, 0),
                menuListView.getSelectionModel().getSelectedItem().getPhoneScreen(), new CallHistoryScreen(phone));
    }

    @Override
    public void preparePhoneScreenList() {
        addItemtoMenuList(new OptionScreenCard("Call New Number", new EnterPhoneNumberScreen(phone)));
        addToScreenCallHistory();
    }

    void addToScreenCallHistory() {
       List<CallHistoryCard> callHistoryList = phone.getCallHistory().getList();

        if (callHistoryList.size() > 0) {
            for (int i = callHistoryList.size() - 1; i >= 0; i--) {
                 addItemtoMenuList((Card) callHistoryList.get(i));
            }
        } else {
            addItemtoMenuList(new ContactCard(new Contact(new Person("Has not been call or get called", null), null), callHistory));
        }
    }

    public CallHistoryScreen getCallHistory() {
        return callHistory;
    }

    public void setCallHistory(CallHistoryScreen callHistory) {
        this.callHistory = callHistory;
    }
}
