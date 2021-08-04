package phone.message;

import phone.Phone;
import phone.screen.registerednumbers.contact.Contact;

public class SentMessage extends BaseMessage {
    boolean messageSent = false;

    public SentMessage(Phone phone, Contact messageContact, String message) {
        super(phone, messageContact, message, phone.getMessage().getSentMessageHistory());
        updateMessageSeen(true);
    }

    public boolean isMessageSent() {
        return messageSent;
    }

    public void setMessageSent(boolean messageSent) {
        this.messageSent = messageSent;
    }

    public String getWarningExpresionIfMessageWasNotSend() {

        String text = "";
        if (messageSent == false) {
            text = "(Unsend)";
        }
        return text;
    }
}
