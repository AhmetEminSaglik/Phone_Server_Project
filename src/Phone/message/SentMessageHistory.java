package phone.message;

import mynote.MyNote;
import phone.Phone;
import phone.screen.listviewscreen.listViewCard.MessageHistoryCard;

public class SentMessageHistory extends MessageHistory {

    public SentMessageHistory(Phone phone) {
        super(phone);
    }

    @Override
    MessageHistoryCard findMessageHistoryCard(BaseMessage baseMessage)   {
//        MyNote.showMessageDialog("MESAJ GONDEREN TELEFONUN GONDERILEN MESAJLAR KIMSINDA SORUN VAR");

        System.out.println("=====================================>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+getClass().getSimpleName());
        System.out.println("istenilen : "+baseMessage.toString());
        for (int i = 0; i < getList().size(); i++) {
            System.out.println("incelenen: "+((MessageHistoryCard)getList().get(i)).getMessage().toString());
            if (((MessageHistoryCard) getList().get(i)).getMessage() == baseMessage)
                return (MessageHistoryCard) getList().get(i);
        }
        System.out.println("NULLLLLL DONUYORRR ");
        return null;
    }

    public void addMessage(SentMessage sentMessage) {
//        add(new MessageHistoryCard(sentMessage, sentMessage.getWarningExpresionIfMessageWasNotSend()));
        addMessageToHistory(sentMessage, sentMessage.getWarningExpresionIfMessageWasNotSend());
    }
}
