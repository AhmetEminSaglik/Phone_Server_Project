package phone.screen.messagehistoryscreen;

import phone.Phone;
import phone.screen.messagehistoryscreen.basemessagelistview.sendingmessage.SentMessageScreenController;

public class SentMessageScreen extends BaseMessageListView {

    public SentMessageScreen(Phone phone) {
        super(phone, new SentMessageScreenController(phone));
        ((SentMessageScreenController) baseScreenController).setSentMessageScreen(this);

//        System.out.println("gonderilen  mesaj boyutu : " + phone.getMessage().getSentMessageHistory().size());
//        phone.getMessage().getSentMessageHistory().getList().forEach(t -> {
//            System.out.println("Gonderilen mesajlar " + t);
//        });
//        System.out.println("Alinan mesaj boyutu : " + phone.getMessage().getReceivedMessageHistory().size());
//        phone.getMessage().getReceivedMessageHistory().getList().forEach(t -> {
//            System.out.println("Alinan mesajlar " + t);
//        });
    }
}
