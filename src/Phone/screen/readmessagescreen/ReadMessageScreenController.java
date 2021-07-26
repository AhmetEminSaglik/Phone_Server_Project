package phone.screen.readmessagescreen;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import phone.Phone;
import phone.message.BaseMessage;
import phone.message.MessageHistory;
import phone.screen.basescreen.BaseScreenController;

public class ReadMessageScreenController extends BaseScreenController {
    BaseMessage baseMessage;
    MessageHistory messageHistory;

    public ReadMessageScreenController(Phone phone, BaseMessage baseMessage, MessageHistory messageHistory) {//, MessageHistory messageHistory
        super(phone);
        this.baseMessage = baseMessage;
//        messageHistory=phone.getMessage().get
        this.messageHistory = messageHistory;
    }

    @FXML
    private TextArea MessageTextArea;

    @Override
    public void addActionToOperatorKeys() {
        super.addActionToOperatorKeys();

        numberKeyEvent.setEventToScrollUpTextArea(getWantedPhoneKey(phone, 0, 1), MessageTextArea);
        numberKeyEvent.setEventToScrollDownTextArea(getWantedPhoneKey(phone, 1, 1), MessageTextArea);

    }

    @Override
    public void updateScreen() {
        System.out.println("messageHistory : " + messageHistory);
        MessageTextArea.setText(baseMessage.getMessage());
        baseMessage.updateMessageSeen(true);
//        phone.getMessage().getReceivedMessageHistory().updateMessageHistoryCardReadSituation(baseMessage);
        messageHistory.updateMessageHistoryCardReadSituation(baseMessage);

    }


}
