package phone.screen.messagehistoryscreen;

import phone.Phone;
import phone.screen.callhistoryscreen.CallHistoryScreen;
import phone.screen.listviewscreen.ListViewScreenController;
import phone.screen.listviewscreen.listViewCard.OptionScreenCard;
import phone.screen.textingscreen.MessageScreen;

public class MessageHistoryScreenController extends ListViewScreenController {
    MessageHistoryScreen messageHistory;

    public MessageHistoryScreenController(Phone phone) {
        super(phone);
    }

    @Override
    public void preparePhoneScreenList() {
//        addItemtoMenuList(new OptionScreenCard("Send BaseMessage", new (phone)));
//        addItemtoMenuList(new OptionScreenCard("Send BaseMessage", new MessageScreen(phone, null)));
        addToScreenMessageHistoryOptions();
    }
    @Override
    public void setSwitchScreenParamaters() {
        numberKeyEvent.setEventToSwitchScreen(getWantedPhoneKey(phone, 0, 0),
                menuListView.getSelectionModel().getSelectedItem().getPhoneScreen(),new MessageHistoryScreen(phone));
    }
    void addToScreenMessageHistoryOptions() {
        addItemtoMenuList(new OptionScreenCard("Send BaseMessage", new MessageScreen(phone,null)));
        addItemtoMenuList(new OptionScreenCard("Sent Messages",new SentMessageScreen(phone)));
        addItemtoMenuList(new OptionScreenCard("Received Messages",new ReceivedMessageScreen(phone)));

//        List<MessageHistoryCard> messageHistoryList = phone.getMessageHistory().getList();
//        if (messageHistoryList.size() > 0) {
//            for (int i = messageHistoryList.size() - 1; i >= 0; i--) {
//                addItemtoMenuList((Card) messageHistoryList.get(i));
//            }
//        } else {
//            addItemtoMenuList(new ContactCard(new Contact(new Person("Has not been got or sent phone.message", null), null), messageHistory));
//        }
    }

    public void setMessageHistory(MessageHistoryScreen messageHistory) {
        this.messageHistory = messageHistory;
    }
}
