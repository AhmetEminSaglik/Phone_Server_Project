package server;

import phone.Phone;
import phone.screen.registerednumbers.contact.Contact;
import server.connection.SettingTwoPhoneForCallingConnection;
import server.connection.SettingTwoPhoneForSendingMessageConnection;
import server.registeredphonecard.RegisteredPhoneCard;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class
ServerController implements Initializable {


    @FXML
    private TextField txtGivenPhoneNumber;
    @FXML
    private VBox registeredPhoneNumberVBox;

    RegisteredPhoneInServer registeredPhoneInServer = new RegisteredPhoneInServer();
    Server server;

    public ServerController(Server server) {
        this.server = server;
    }

    @FXML
    public void addPhoneNumberBtnFunction(ActionEvent event) {
        String phoneNumber = txtGivenPhoneNumber.getText().trim();
        addPhoneNumber(phoneNumber);
        clearTxtGivenPhoneNumber();
    }


    public void addPhoneNumber(String phoneNumber) {

        if (numberIsAdded(phoneNumber) == false) {

            Phone phone = new Phone(server);
            phone.setNumber(phoneNumber);

            RegisteredPhoneCard registeredPhoneCard = new RegisteredPhoneCard(phone);
            registeredPhoneNumberVBox.getChildren().add(registeredPhoneCard);
            registeredPhoneInServer.add(registeredPhoneCard);

            phone.start(new Stage());
            UpdationRegisteredPhoneCardSituation.addProcessesOfRegisteringNewPhoneCard(registeredPhoneCard);

        } else {
            System.out.println("This phone number is created already : " + phoneNumber);
        }

    }

    boolean numberIsAdded(String number) {
        return registeredPhoneInServer.isPhoneNumberExist(number);
    }

    void clearTxtGivenPhoneNumber() {
        txtGivenPhoneNumber.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        for (int i = 0; i < 2; i++) {
            addPhoneNumber("" + (i + 1));
        }
    }

    /**
     * when one of phone call a phone first it dial a number  and then in server  try to find out that number's phone.
     */
    public Phone findPhoneByNumber(String phoneNumber) {
        return registeredPhoneInServer.searchNumberAndGetPhone(phoneNumber);

    }

    RegisteredPhoneCard findRegisteredPhoneCard(String phoneNumber) {

        for (int i = 1; i < registeredPhoneNumberVBox.getChildren().size(); i++) {
             if (((RegisteredPhoneCard) registeredPhoneNumberVBox.getChildren().get(i)).getPhone().getNumber().equals(phoneNumber)) {
                return ((RegisteredPhoneCard) registeredPhoneNumberVBox.getChildren().get(i));
            }
        }
         return null;
    }

    public void callNumber(Contact contactWhoIsCallingSomeone, Contact contactWhoWillAnswerCall) { // who is being call --> callingContact / who calls --> comingCallContact

        SettingTwoPhoneForCallingConnection connectionTwoPhone = new SettingTwoPhoneForCallingConnection(
                findRegisteredPhoneCard(contactWhoIsCallingSomeone.getPhoneNumber()),
                findRegisteredPhoneCard(contactWhoWillAnswerCall.getPhoneNumber()));
        connectionTwoPhone.connectPhones();
    }

    public void sendMessageToNumber(Phone phoneSendMessage, Contact contactReceiveMessage, String message) {
        SettingTwoPhoneForSendingMessageConnection connectPhone = new SettingTwoPhoneForSendingMessageConnection(server, phoneSendMessage, contactReceiveMessage, message);
        connectPhone.sendMessage();

    }


}

