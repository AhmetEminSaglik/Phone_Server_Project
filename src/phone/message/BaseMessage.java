package phone.message;

import date.TimeAtThatMoment;
import phone.Phone;
import phone.screen.basescreen.BaseScreen;
import phone.screen.readmessagescreen.ReadMessageScreen;
import phone.screen.registerednumbers.contact.Contact;

public abstract class BaseMessage {
    Phone phone;
    BaseScreen baseScreen;
    Contact messageContact;
    String message;
    TimeAtThatMoment timeAtThatMoment;
    boolean messageIsSeen = false;

    public BaseMessage(Phone phone, Contact messageContact, String message, MessageHistory messageHistory) {
        this.phone = phone;
        this.messageContact = messageContact;
        this.message = message;
        timeAtThatMoment = new TimeAtThatMoment();
        this.baseScreen = new ReadMessageScreen(phone, this, messageHistory);
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Contact getMessageContact() {
        return messageContact;
    }

    public void setMessageContact(Contact messageContact) {
        this.messageContact = messageContact;
    }

    public String getUnReadExpression() {
        return "(new)";
    }

    public String getMessage() {
        return message;
    }

    public TimeAtThatMoment getTimeAtThatMoment() {
        return timeAtThatMoment;
    }

    public BaseScreen getBaseScreen() {
        return baseScreen;
    }

    public void updateMessageSeen(boolean isSeen) {
        messageIsSeen = isSeen;
    }

    @Override
    public String toString() {
        return "BaseMessage{" +
                "phone=" + phone +
                ", messageContact=" + messageContact +
                ", messageIsSeen=" + messageIsSeen +
                '}';
    }

}
