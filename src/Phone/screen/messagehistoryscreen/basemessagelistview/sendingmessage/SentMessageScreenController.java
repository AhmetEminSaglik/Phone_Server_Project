package phone.screen.messagehistoryscreen.basemessagelistview.sendingmessage;

import phone.Phone;
import phone.screen.callhistoryscreen.CallHistoryScreen;
import phone.screen.listviewscreen.listViewCard.Card;
import phone.screen.listviewscreen.listViewCard.EmptyCard;
import phone.screen.listviewscreen.listViewCard.MessageHistoryCard;
import phone.screen.messagehistoryscreen.SentMessageScreen;
import phone.screen.messagehistoryscreen.basemessagelistview.BaseMessageListViewController;

import java.util.List;

public class SentMessageScreenController extends BaseMessageListViewController {
    SentMessageScreen sentMessageScreen;

    public SentMessageScreenController(Phone phone) {
        super(phone);
    }

    @Override
    public void setSwitchScreenParamaters() {
        numberKeyEvent.setEventToSwitchScreen(getWantedPhoneKey(phone, 0, 0),
                menuListView.getSelectionModel().getSelectedItem().getPhoneScreen(),new SentMessageScreen(phone));
    }
    @Override
    public void preparePhoneScreenList() {
        List<MessageHistoryCard> sentMessageList = phone.getMessage().getSentMessageHistory().getList();
        if (sentMessageList.size() > 0) {
            for (int i = sentMessageList.size() - 1; i >= 0; i--) {
                addItemtoMenuList((Card) sentMessageList.get(i));
            }
        } else {
            addItemtoMenuList(new EmptyCard("Sent BaseMessage history is empty", sentMessageScreen));
        }
    }

    public void setSentMessageScreen(SentMessageScreen sentMessageScreen) {
        this.sentMessageScreen = sentMessageScreen;
    }

}
