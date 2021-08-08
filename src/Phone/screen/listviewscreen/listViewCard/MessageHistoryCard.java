package phone.screen.listviewscreen.listViewCard;

import phone.message.BaseMessage;
import phone.screen.registerednumbers.contact.Contact;

public class MessageHistoryCard extends Card {

    BaseMessage baseMessage;
    boolean read = false;

    public MessageHistoryCard(BaseMessage baseMessage, String messageExtraInfo) {
        super(baseMessage.getMessageContact().getLimitedNameChracter(messageExtraInfo.length()/2) + " " +
                messageExtraInfo + " " + baseMessage.getTimeAtThatMoment().getCallTimeInString(), baseMessage.getBaseScreen());
        this.baseMessage = baseMessage;
        }

    public BaseMessage getMessage() {
        return baseMessage;
    }

    public void setMessage(BaseMessage baseMessage) {
        this.baseMessage = baseMessage;
    }

    public Contact getMessageContact() {
        return baseMessage.getMessageContact();
    }

    public String getMessageTime() {
        return baseMessage.getTimeAtThatMoment().getCallTimeInString();
    }
}
