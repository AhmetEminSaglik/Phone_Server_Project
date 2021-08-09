package phone.message;


import phone.Phone;
import phone.screen.listviewscreen.listViewCard.MessageHistoryCard;

public class SentMessageHistory extends MessageHistory {

    public SentMessageHistory(Phone phone) {
        super(phone);
    }

    @Override
    MessageHistoryCard findMessageHistoryCard(BaseMessage baseMessage) {

        for (int i = 0; i < getList().size(); i++) {
            if (((MessageHistoryCard) getList().get(i)).getMessage() == baseMessage)
                return (MessageHistoryCard) getList().get(i);
        }
        return null;
    }

    public void addMessage(SentMessage sentMessage) {
        addMessageToHistory(sentMessage, sentMessage.getWarningExpresionIfMessageWasNotSend());
    }
}
