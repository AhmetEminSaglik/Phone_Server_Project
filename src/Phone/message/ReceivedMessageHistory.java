package phone.message;

import phone.Phone;
import phone.screen.listviewscreen.listViewCard.MessageHistoryCard;

public class ReceivedMessageHistory extends MessageHistory {
    public ReceivedMessageHistory(Phone phone) {
        super(phone);
    }

    @Override
    MessageHistoryCard findMessageHistoryCard(BaseMessage baseMessage) {
        System.out.println("=====================================>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + getClass().getSimpleName());
//        System.out.println(" LISTE  SIZE " + getList().size());
        System.out.println("istenilen : "+baseMessage.toString());
        for (int i = 0; i < getList().size(); i++) {
            System.out.println("incelenen: "+((MessageHistoryCard)getList().get(i)).getMessage().toString());
            if (((MessageHistoryCard) getList().get(i)).getMessage() == baseMessage) {
                return (MessageHistoryCard) getList().get(i);
            } else {
                System.out.println("(MessageHistoryCard) getList().get(i)).getMessage() != baseMessage) == >  " + (((MessageHistoryCard) getList().get(i)).getMessage()) + " != " + baseMessage);


            }
        }
        System.out.println("NULLLLLL DONUYORRR ");
        return null;
    }


    public void addMessage(ReceivedMessage receivedMessage) {
        System.out.println("MESSAGE IS RECEIVED ");
//        System.out.println(phone.getStage().isShowing());
        for (int i = 0; i < getList().size(); i++) {
            System.out.println("MESSAGE IS RECEIVED  : " + getList().get(i).toString());
            System.out.println("MESSAGE IS RECEIVED  : " + ((MessageHistoryCard) getList().get(i)).getMessage().toString());
        }
//        System.out.println("GELEN MESAJ PHONE : " + receivedMessage.toString());
////        add(new MessageHistoryCard(receivedMessage, receivedMessage.getUnReadExpressionIfMessageWasNotRead()));
        addMessageToHistory(receivedMessage, receivedMessage.getUnReadExpressionIfMessageWasNotRead());
////        System.out.println(new MessageHistoryCard(receivedMessage, receivedMessage.getUnReadExpressionIfMessageWasNotRead()));
    }
}

