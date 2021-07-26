package phone;

import phone.message.ReceivedMessageHistory;
import phone.message.SentMessageHistory;

public class Message {
    Phone phone;
    private SentMessageHistory sentMessageHistory;
    private ReceivedMessageHistory receivedMessageHistory;


    public Message(Phone phone) {
        this.phone = phone;
        sentMessageHistory = new SentMessageHistory(phone);
        receivedMessageHistory = new ReceivedMessageHistory(phone);
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public SentMessageHistory getSentMessageHistory() {
        return sentMessageHistory;
    }

    public void setSentMessageHistory(SentMessageHistory sentMessageHistory) {
        this.sentMessageHistory = sentMessageHistory;
    }

    public ReceivedMessageHistory getReceivedMessageHistory() {
        return receivedMessageHistory;
    }

    public void setReceivedMessageHistory(ReceivedMessageHistory receivedMessageHistory) {
        this.receivedMessageHistory = receivedMessageHistory;
    }
}
