package phone.screen.callhistoryscreen;

import phone.Phone;
import phone.screen.listviewscreen.ListViewScreen;

public class CallHistoryScreen extends ListViewScreen {
    public CallHistoryScreen(Phone phone) {
        super(phone, new CallHistoryController(phone));
        ((CallHistoryController) baseScreenController).setCallHistory(this);


    }
}
