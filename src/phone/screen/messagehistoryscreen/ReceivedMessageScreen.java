package phone.screen.messagehistoryscreen;

import phone.Phone;
import phone.screen.messagehistoryscreen.basemessagelistview.receivedmessage.ReceivedMessageScreenController;
import phone.screen.messagehistoryscreen.basemessagelistview.sendingmessage.SentMessageScreenController;


public class ReceivedMessageScreen extends BaseMessageListView {

    public ReceivedMessageScreen(Phone phone) {
        super(phone, new ReceivedMessageScreenController(phone));
        ((ReceivedMessageScreenController) baseScreenController).setReceivedMessageScreen(this);
    }
}
