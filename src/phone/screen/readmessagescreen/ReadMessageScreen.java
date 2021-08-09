package phone.screen.readmessagescreen;

import phone.Phone;
import phone.message.BaseMessage;
import phone.message.MessageHistory;
import phone.screen.basescreen.BaseScreen;

public class ReadMessageScreen extends BaseScreen {
    public ReadMessageScreen(Phone phone, BaseMessage baseMessage,MessageHistory messageHistory) {
        super(phone);
        this.baseScreenController = new ReadMessageScreenController(phone, baseMessage,messageHistory);
        loadFxmlFile("ReadMessageScreen.fxml");
    }
}
