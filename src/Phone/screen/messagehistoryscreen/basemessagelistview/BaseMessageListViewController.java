package phone.screen.messagehistoryscreen.basemessagelistview;

import phone.Phone;
import phone.screen.callhistoryscreen.CallHistoryScreen;
import phone.screen.listviewscreen.ListViewScreenController;
import phone.screen.messagehistoryscreen.BaseMessageListView;

public abstract  class BaseMessageListViewController extends ListViewScreenController {
    public BaseMessageListViewController(Phone phone) {
        super(phone);
    }

    @Override
    public void preparePhoneScreenList() {

//        List<MessageHistoryCard> messageHistoryList = phone.getMessageHistory().getList();
//        if (messageHistoryList.size() > 0) {
//            for (int i = messageHistoryList.size() - 1; i >= 0; i--) {
//                addItemtoMenuList((Card) messageHistoryList.get(i));
//            }
//        } else {
//            addItemtoMenuList(new ContactCard(new Contact(new Person("Has not been got or sent phone.message", null), null), messageHistory));
//        }
    }
}
