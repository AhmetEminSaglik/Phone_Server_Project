package server.connection;

import mynote.MyNote;
import phone.Phone;
import phone.message.BaseMessage;
import phone.message.ReceivedMessage;
import phone.message.SentMessage;
import phone.screen.registerednumbers.contact.Contact;
import phone.utility.IdentifyNumber;
import server.Server;
import server.findnumber.FindTheNumberIsExistInServer;

public class SettingTwoPhoneForSendingMessageConnection {
    Phone sendMessagePhone, receiveMessagePhone;
    Contact contact;
    BaseMessage baseMessage;
    FindTheNumberIsExistInServer findTheNumberIsExistInServer;
    String messageText;

    public SettingTwoPhoneForSendingMessageConnection(Server server, Phone sendMessagePhone, Contact contactReceiveMessage, String messageText) {
        findTheNumberIsExistInServer = new FindTheNumberIsExistInServer(server);
        receiveMessagePhone = searcNumberInServer(contactReceiveMessage);
        this.sendMessagePhone = sendMessagePhone;
//        this.receiveMessagePhone = receiveMessagePhone;
        this.messageText = messageText;
        this.contact = contactReceiveMessage;
//        buildMessage(messageText);
    }


    public void sendMessage() {
//        MyNote.showMessageDialog("Gonderenin Mesajini servere iletmeden telefonda halletmem gerekiyor sonra servere gondermem gerekiyor\n" +
//                "burada sadece mesaji alaninin hiistorisine eklenmesi lazim");
//        MyNote.showMessageDialog("Mesaj gonderirken ve alirken mesaj alma ve gonderme  kisminda sorun yasiyorum, ve bunlari daha  duzeltmedim");

//        MessageHistoryCard messageHistoryCardForSendMessagePhone = new MessageHistoryCard(receiveMessagePhone.getNumber(), new ReadMessageScreen(sendMessagePhone));


//        messageHistoryCardForSendMessagePhone.setMessage(baseMessage);
//        sendMessagePhone.getMessageHistory().getSentMessageHistory().add(messageHistoryCardForSendMessagePhone);


        if (receiveMessagePhone != null) {
//            MessageHistoryCard messageHistoryCardForReceiveMessagePhone = new MessageHistoryCard(sendMessagePhone.getNumber(), new ReadMessageScreen(receiveMessagePhone));
            
            System.out.println(getClass().getName() + "       ===>>>> BURADA SERVERDA OLMAYAN NUMARA GIRINCE HATA ALIYORUM");
            SentMessage sentMessage = new SentMessage(sendMessagePhone, new IdentifyNumber(sendMessagePhone).identifyNumber(receiveMessagePhone.getNumber()), messageText);
            sentMessage.setMessageSent(true);
//            System.out.println("sentMessage.setMessageSent : " + sentMessage.isMessageSent());
            sendMessagePhone.getMessage().getSentMessageHistory().addMessage(sentMessage);

//            System.out.println("MESAJ EKLENECEK AMA receiveMessagePhone ??????????? NULL MU ?????????????????????"+receiveMessagePhone);
            ReceivedMessage receivedMessage = new ReceivedMessage(receiveMessagePhone, new IdentifyNumber(receiveMessagePhone).identifyNumber(sendMessagePhone.getNumber()), messageText);
//            System.out.println("GONDERILECEK MESAJ BILGI : "+receivedMessage.toString());
            receiveMessagePhone.getMessage().getReceivedMessageHistory().addMessage(receivedMessage);
            if(receiveMessagePhone.getStage().isShowing())
            receiveMessagePhone.getMusicPlayer().playMusicTextNotification();


//            messageHistoryCardForReceiveMessagePhone.setMessage(baseMessage);
//            receiveMessagePhone.getMessageHistory().getReceivedMessageHistory().add(messageHistoryCardForReceiveMessagePhone);
//messageHistoryCardForSendMessagePhone.getMessage()
        } else {
            System.out.println(getClass().getName() + "       ===>>>> BURADA SERVERDA OLMAYAN NUMARA GIRINCE HATA ALIYORUM");
            SentMessage sentMessage = new SentMessage(sendMessagePhone, contact, messageText);
            sendMessagePhone.getMessage().getSentMessageHistory().addMessage(sentMessage);

        }
        System.out.println("MESAJLAR GONDERILDI");
    }

    public Phone searcNumberInServer(Contact contact) {


        return findTheNumberIsExistInServer.searcNumber(contact);
    }

}
