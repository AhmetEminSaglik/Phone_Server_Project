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
//    {
//        System.out.println("istenilen : "+baseMessage.toString());
//        for (int i = 0; i < getList().size(); i++) {
//            System.out.println("incelenen: "+((MessageHistoryCard)getList().get(i)).getMessage().toString());
//            if (getList().get(i) == baseMessage)
//                return (MessageHistoryCard) getList().get(i);
//        }
//        System.out.println("NULLLLLL DONUYORRR ");
//        return null;
//    }

    protected final void addMessageToHistory(BaseMessage baseMessage, String extraExpression) {
        add(new MessageHistoryCard(baseMessage, extraExpression));
    }
//    public abstract void addMessage(BaseMessage baseMessage, String extraExpression);
//    {

//        add(new MessageHistoryCard(baseMessage, extraExpression);
////        System.out.println(new MessageHistoryCard(receivedMessage, receivedMessage.getUnReadExpressionIfMessageWasNotRead()));
//    }

    //    public void addSentMessage(MessageHistory messageHistory,BaseMessage baseMessage)
//    {
//messageHistory.add(baseMessage);
//    }
    public void updateMessageHistoryCardReadSituation(BaseMessage baseMessage) {
        MessageHistoryCard messageHistoryCard = findMessageHistoryCard(baseMessage);
        System.out.println("messageHistoryCard (ONCESI) : " + messageHistoryCard.toString());
        messageHistoryCard.setName(messageHistoryCard.getMessageContact().getLimitedNameChracter(0, 10) + " " + messageHistoryCard.getMessageTime());
        System.out.println("messageHistoryCard (SONRASI) : " + messageHistoryCard.toString());
    }
//    ReceivedMessageHistory receivedMessageHistory;
//    SentMessageHistory sentMessageHistory;

//    public MessageHistory(Phone phone) {
//        this.phone = phone;
//        receivedMessageHistory = new ReceivedMessageHistory(phone);
//        sentMessageHistory = new SentMessageHistory(phone);
//    }
//
//    public ReceivedMessageHistory getReceivedMessageHistory() {
//        return receivedMessageHistory;
//    }
//
////    public void setReceivedMessageHistory(ReceivedMessageHistory receivedMessageHistory) {
////        this.receivedMessageHistory = receivedMessageHistory;
////    }
//
//    public SentMessageHistory getSentMessageHistory() {
//        return sentMessageHistory;
//    }

//    public void setSentMessageHistory(SentMessageHistory sentMessageHistory) {
//        this.sentMessageHistory = sentMessageHistory;
//    }
}

//
//public class MessageHistory extends History<MessageHistoryCard> {
//
//    public MessageHistory(Phone phone) {
//        this.phone = phone;
//    }
//}
