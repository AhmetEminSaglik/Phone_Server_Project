package server.connection;

import date.TimeAtThatMoment;
import phone.Phone;
import phone.message.ReceivedMessage;
import server.registeredphonecard.archive.recordclass.RecordMessage;
import phone.message.SentMessage;
import phone.screen.registerednumbers.contact.Contact;
import phone.utility.IdentifyNumber;
import server.Server;
import server.findnumber.FindTheNumberIsExistInServer;
import server.registeredphonecard.archive.RecordManagement;
import server.registeredphonecard.archive.RecordServer;

import java.util.ArrayList;
import java.util.List;

public class SettingTwoPhoneForSendingMessageConnection {
    Phone sendMessagePhone, receiveMessagePhone;
    Contact contact;
    FindTheNumberIsExistInServer findTheNumberIsExistInServer;
    String messageText;

    public SettingTwoPhoneForSendingMessageConnection(Server server, Phone sendMessagePhone, Contact contactReceiveMessage, String messageText) {
        findTheNumberIsExistInServer = new FindTheNumberIsExistInServer(server);
        receiveMessagePhone = searcNumberInServer(contactReceiveMessage);
        this.sendMessagePhone = sendMessagePhone;

        this.messageText = messageText;
        this.contact = contactReceiveMessage;
    }


    public void sendMessage() {
        SentMessage sentMessage;
        if (receiveMessagePhone != null) {

            sentMessage = new SentMessage(sendMessagePhone, new IdentifyNumber(sendMessagePhone).identifyNumber(receiveMessagePhone.getNumber()), messageText);
            sentMessage.setMessageSent(true);

            sendMessagePhone.getMessage().getSentMessageHistory().addMessage(sentMessage);
            ReceivedMessage receivedMessage = new ReceivedMessage(receiveMessagePhone, new IdentifyNumber(receiveMessagePhone).identifyNumber(sendMessagePhone.getNumber()), messageText);

            receiveMessagePhone.getMessage().getReceivedMessageHistory().addMessage(receivedMessage);
            if (receiveMessagePhone.getStage().isShowing())
                receiveMessagePhone.getMusicPlayer().playMusicTextNotification();

        } else {
            sentMessage = new SentMessage(sendMessagePhone, contact, messageText);
            sendMessagePhone.getMessage().getSentMessageHistory().addMessage(sentMessage);

        }
        saveMessageToXML(sentMessage);


    }

    void saveMessageToXML(SentMessage sentMessage) {

        RecordManagement recordManagement = new RecordManagement(sendMessagePhone.getServer());
        recordManagement.recordMessage(getRecordServerToSaveXML(sendMessagePhone, getReceivedTextPhoneNumber(), messageText, sentMessage.getTimeAtThatMoment()));


    }

    RecordServer getRecordServerToSaveXML(Phone sentMessage, String phoneNumberReceivedMessage, String messageText, TimeAtThatMoment time) {
        RecordServer recordServer = new RecordServer();
        recordServer.addListMessageOpearations(getRecordMessage(sentMessage, phoneNumberReceivedMessage, messageText, time));
        return recordServer;

    }

    List<RecordMessage> getRecordMessage(Phone sentMessage, String phoneNumberReceivedMessage, String messageText, TimeAtThatMoment time) {

        RecordMessage recordMessage = new RecordMessage();

        recordMessage.setMessage(messageText);
        recordMessage.setPhoneSentMessage(sentMessage.getNumber());
        recordMessage.setPhonerReceivedMessage(phoneNumberReceivedMessage);

        recordMessage.setTimeAtThatMoment(time.getCallTimeInString());


        List list = new ArrayList<RecordMessage>();
        list.add(recordMessage);
        return list;
    }

    public Phone searcNumberInServer(Contact contact) {


        return findTheNumberIsExistInServer.searcNumber(contact);
    }

    String getReceivedTextPhoneNumber() {
        if (receiveMessagePhone != null)
            return receiveMessagePhone.getNumber();
        return "(Unknown Number) " + contact.getPhoneNumber();

    }
}
