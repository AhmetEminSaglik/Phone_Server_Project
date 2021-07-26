package server;

import archive.Archive;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollToEvent;
import javafx.scene.control.TextArea;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import phone.Phone;
import phone.key.ability.function.Function;
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

/*
//  !!! when new phone added and if it is not able to reach it then this function must be activated
    public void updateAllPhonesServer() {
        for (int i = 0; i < registeredPhoneList.size(); i++) {
            registeredPhoneList.get(i).setServer(server);
        }

    }*/


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        prepareScrolBar();
        for (int i = 0; i < 2; i++) {
            addPhoneNumber("" + (i + 1));
        }
//        updateAllPhonesServer();
    }

    /**
     * when one of phone call a phone first it dial a number  and then in server  try to find out that number's phone.
     */
    public Phone findPhoneByNumber(String phoneNumber) {
        return registeredPhoneInServer.searchNumberAndGetPhone(phoneNumber);

    }

    RegisteredPhoneCard findRegisteredPhoneCard(String phoneNumber) {

        for (int i = 1; i < registeredPhoneNumberVBox.getChildren().size(); i++) {
            System.out.println("registeredPhoneNumberVBox.getChildren()  " + registeredPhoneNumberVBox.getChildren().get(i).toString());
            if (((RegisteredPhoneCard) registeredPhoneNumberVBox.getChildren().get(i)).getPhone().getNumber().equals(phoneNumber)) {
                return ((RegisteredPhoneCard) registeredPhoneNumberVBox.getChildren().get(i));
            }
        }
        System.out.println(getClass().getSimpleName() + " findRegisteredPhoneCard --> NULL GIRDI");
        return null;
    }


    //Contact contactWhoIsCallingSomeone, Contact contactWhoWillAnswerCall
    public void callNumber(Contact contactWhoIsCallingSomeone, Contact contactWhoWillAnswerCall) { // who is being call --> callingContact / who calls --> comingCallContact
//        Phone dialedPhone = findPhoneByNumber(contactWhoWillAnswerCall.getPhoneNumber());
//        Phone callerPhone = findPhoneByNumber(contactWhoIsCallingSomeone.getPhoneNumber()).getPhoneController().getPhone();

        SettingTwoPhoneForCallingConnection connectionTwoPhone = new SettingTwoPhoneForCallingConnection(
                findRegisteredPhoneCard(contactWhoIsCallingSomeone.getPhoneNumber()),
                findRegisteredPhoneCard(contactWhoWillAnswerCall.getPhoneNumber()));
        connectionTwoPhone.connectPhones();
    }

    public void sendMessageToNumber(Phone phoneSendMessage, Contact contactReceiveMessage, String message) {
        SettingTwoPhoneForSendingMessageConnection connectPhone = new SettingTwoPhoneForSendingMessageConnection(server, phoneSendMessage, contactReceiveMessage, message);
        connectPhone.sendMessage();

    }

//    void prepareScrolBar() {
//        double HBoxPaneHeight = getHeight(HBoxRegisterPhoneArea);
//        double VBoxPaneHeight = getHeight(HBoxRegisterPhoneArea);
//        double SBMinHeight = HBoxPaneHeight;
//        double SBMaxHeight = VBoxPaneHeight;
//
////        serverScrolBar.setValue(0);
////        serverScrolBar.setOnScroll(scrollBarEvent(serverScrolBar));
//    }
//
///*    EventHandler<ScrollEvent> scrollBarEvent(ScrollBar scrollBar) {
//        return new EventHandler<ScrollEvent>() {
//            @Override
//            public void handle(ScrollEvent scrollEvent) {
//                double val = scrollBar.getValue();
//                scrollBar.setValue(val++);
//
//            }
//        };
//    }*/
//
//    double getHeight(Pane pane) {
//        return pane.getHeight();
//    }



}

