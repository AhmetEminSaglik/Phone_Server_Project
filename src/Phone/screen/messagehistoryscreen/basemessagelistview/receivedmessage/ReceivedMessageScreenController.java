package phone.screen.messagehistoryscreen.basemessagelistview.receivedmessage;

import phone.Phone;
import phone.message.ReceivedMessageHistory;
import phone.screen.callhistoryscreen.CallHistoryScreen;
import phone.screen.listviewscreen.listViewCard.Card;
import phone.screen.listviewscreen.listViewCard.EmptyCard;
import phone.screen.listviewscreen.listViewCard.MessageHistoryCard;
import phone.screen.messagehistoryscreen.ReceivedMessageScreen;
import phone.screen.messagehistoryscreen.basemessagelistview.BaseMessageListViewController;

import java.util.List;

public class ReceivedMessageScreenController extends BaseMessageListViewController {
    ReceivedMessageScreen receivedMessageScreen;

    public ReceivedMessageScreenController(Phone phone) {
        super(phone);
    }

    @Override
    public void setSwitchScreenParamaters() {
        numberKeyEvent.setEventToSwitchScreen(getWantedPhoneKey(phone, 0, 0),
                menuListView.getSelectionModel().getSelectedItem().getPhoneScreen(),new ReceivedMessageScreen(phone));
    }
    @Override
    public void preparePhoneScreenList() {
        List<MessageHistoryCard> receivedMessageList = phone.getMessage().getReceivedMessageHistory().getList();
        if (receivedMessageList.size() > 0) {
            for (int i = receivedMessageList.size() - 1; i >= 0; i--) {
                addItemtoMenuList((Card) receivedMessageList.get(i));
            }
        } else {
//            addItemtoMenuList(new ContactCard(new Contact(new Person("Has not been got or sent phone.message", null), null), messageHistory) );
            addItemtoMenuList(new EmptyCard("Received BaseMessage history is empty", receivedMessageScreen));
        }

    }

    public void setReceivedMessageScreen(ReceivedMessageScreen receivedMessageScreen) {
        this.receivedMessageScreen = receivedMessageScreen;
    }
}
