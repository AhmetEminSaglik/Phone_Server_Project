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

    }
}
