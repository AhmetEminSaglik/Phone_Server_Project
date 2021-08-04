package phone.message;

import phone.History;
import phone.Phone;
import phone.screen.listviewscreen.listViewCard.MessageHistoryCard;
import phone.screen.messagehistoryscreen.basemessagelistview.sendingmessage.SentMessageScreenController;

public abstract class MessageHistory extends History<MessageHistoryCard> {//extends History<MessageHistoryCard>
    Phone phone;

    public MessageHistory(Phone phone) {
        super(phone);
    }

    abstract MessageHistoryCard findMessageHistoryCard(BaseMessage baseMessage);

    protected final void addMessageToHistory(BaseMessage baseMessage, String extraExpression) {
        add(new MessageHistoryCard(baseMessage, extraExpression));
    }

    public void updateMessageHistoryCardReadSituation(BaseMessage baseMessage) {
        MessageHistoryCard messageHistoryCard = findMessageHistoryCard(baseMessage);
        messageHistoryCard.setName(messageHistoryCard.getMessageContact().getLimitedNameChracter(0, 10) + " " + messageHistoryCard.getMessageTime());
    }
}
