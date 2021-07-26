package phone.screen.messagehistoryscreen;

import phone.Phone;
import phone.screen.listviewscreen.ListViewScreen;

public class MessageHistoryScreen extends ListViewScreen {

    public MessageHistoryScreen(Phone phone) {
        super(phone, new MessageHistoryScreenController(phone));
        ((MessageHistoryScreenController) baseScreenController).setMessageHistory(this);
    }
}
