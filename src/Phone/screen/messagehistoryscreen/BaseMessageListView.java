package phone.screen.messagehistoryscreen;

import phone.Phone;
import phone.screen.basescreen.BaseScreenController;
import phone.screen.listviewscreen.ListViewScreen;
import phone.screen.messagehistoryscreen.basemessagelistview.BaseMessageListViewController;

public class BaseMessageListView extends ListViewScreen {

    public BaseMessageListView(Phone phone, BaseMessageListViewController baseMessageListViewController) {
        super(phone, baseMessageListViewController);
    }
}
