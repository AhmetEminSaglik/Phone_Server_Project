package phone.message;

import phone.Phone;
import phone.screen.listviewscreen.listViewCard.MessageHistoryCard;

public class ReceivedMessageHistory extends MessageHistory {
    public ReceivedMessageHistory(Phone phone) {
        super(phone);
    }

    @Override
    MessageHistoryCard findMessageHistoryCard(BaseMessage baseMessage) {
        for (int i = 0; i < getList().size(); i++) {
            if (((MessageHistoryCard) getList().get(i)).getMessage() == baseMessage) {
                return (MessageHistoryCard) getList().get(i);
            }
        }
        return null;
    }


    public void addMessage(ReceivedMessage receivedMessage) {
        addMessageToHistory(receivedMessage, receivedMessage.getUnReadExpressionIfMessageWasNotRead());
    }
}

