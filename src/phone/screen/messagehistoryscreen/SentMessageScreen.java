package phone.screen.messagehistoryscreen;

import phone.Phone;
import phone.screen.messagehistoryscreen.basemessagelistview.sendingmessage.SentMessageScreenController;

public class SentMessageScreen extends BaseMessageListView {

    public SentMessageScreen(Phone phone) {
        super(phone, new SentMessageScreenController(phone));
        ((SentMessageScreenController) baseScreenController).setSentMessageScreen(this);

    }
}
