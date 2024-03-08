package phone.message;

import phone.Phone;
import phone.screen.messagehistoryscreen.ReceivedMessageScreen;
import phone.screen.registerednumbers.contact.Contact;

public class ReceivedMessage extends BaseMessage {
    boolean messageRead = false;

    public ReceivedMessage(Phone phone, Contact messageContact, String message) {
        super(phone, messageContact, message, phone.getMessage().getReceivedMessageHistory()); //new ReceivedMessageHistory(phone)
    }

    public String getUnReadExpressionIfMessageWasNotRead() {
        String text = "";
        if (messageRead == false) {
            text = "(Unread)";
        }
        return text;
    }

    public boolean isMessageRead() {
        return messageRead;
    }

    public void setMessageRead(boolean messageRead) {
        this.messageRead = messageRead;
    }
}
