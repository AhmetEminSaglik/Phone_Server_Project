package phone.screen.textingscreen;

import phone.Phone;
import phone.screen.registerednumbers.contact.Contact;
import server.Server;
import server.findnumber.FindTheNumberIsExistInServer;

public class SendingMessage {
    Server server;
    Phone phoneSendMessage;//, phoneReceiveMessage;
    Contact contactReceiveMessage;
    FindTheNumberIsExistInServer findTheNumberIsExistInServer;

    public SendingMessage(Phone phoneSendMessage, Contact contactReceiveMessage) {
        this.phoneSendMessage = phoneSendMessage;
        server = phoneSendMessage.getServer();
        this.contactReceiveMessage = contactReceiveMessage;

    }

//    public Phone searcNumberInServer(Contact contact) {
//        return findTheNumberIsExistInServer.searcNumber(contact);
//    }

    public void sendMessage(String message) {
        server.getServerController().sendMessageToNumber(phoneSendMessage, contactReceiveMessage, message);

    }
}
