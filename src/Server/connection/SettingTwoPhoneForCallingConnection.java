package server.connection;

import date.TimeAtThatMoment;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import mynote.MyNote;
import phone.Phone;
import phone.screen.callingscreen.BaseCallScreenController;
import phone.utility.IdentifyNumber;
import server.Server;
import server.registeredphonecard.archive.RecordManagement;
import server.registeredphonecard.archive.RecordServer;
import server.registeredphonecard.archive.recordclass.RecordCall;
import server.stopwatch.StopWatch;
import server.UpdationRegisteredPhoneCardSituation;
import server.registeredphonecard.situation.PhoneSituation;
import phone.key.PhoneKeyWanted;
import phone.key.ability.NumberKeyEvent;
import phone.key.ability.function.Function;
import phone.screen.registerednumbers.contact.Contact;
import server.registeredphonecard.RegisteredPhoneCard;
import server.registeredphonecard.situation.RegisteredPhoneCardUpdateSituation;

import java.util.ArrayList;
import java.util.List;

public class SettingTwoPhoneForCallingConnection { //ConnectionTwoPhone
    RecordCall recordCall = new RecordCall();

    Server server;
    Phone callerPhone;
    Phone dialedPhone;

    RegisteredPhoneCard callerRegisteredPhoneCard;
    RegisteredPhoneCard dialedRegisteredPhoneCard;

    final int connectionWaitingTimeMs = 10 * 1000;
    boolean isConnectionWaitingTimeOver = false;
    final boolean callBolleanVal = true;
    final boolean dialedBolleanVal = false;
    StopWatch stopWatch;
    boolean callIsAnswered = false;
    //    MusicPlayer musicPlayer;
    TimeAtThatMoment timeAtThatMoment;
    String communicationTime = "NULL";

    public SettingTwoPhoneForCallingConnection(RegisteredPhoneCard callerRegisteredPhoneCard, RegisteredPhoneCard dialedRegisteredPhoneCard) {

        this.callerRegisteredPhoneCard = callerRegisteredPhoneCard;
        this.dialedRegisteredPhoneCard = dialedRegisteredPhoneCard;
        callerPhone = callerRegisteredPhoneCard.getPhone();
        dialedPhone = dialedRegisteredPhoneCard.getPhone();
        server = callerPhone.getServer();
    }


    public void connectPhones() {


        timeAtThatMoment = new TimeAtThatMoment();

//        callerPhone.getCallHistory().addCall(callerPhone,dialedPhone.getNumber(),true,callIsAnswered);

        switch (dialedPhone.getSituation()) {
            case PhoneSituation._CLOSED:
                dialedPhoneIsClosed(callerPhone);
                //prepareRecordCall(callerPhone, dialedPhone, callIsAnswered, timeAtThatMoment.getCallTimeInString(), stopWatch.getTimeString());
                //ll(Phone caller, Phone dialed, boolean connected, String callTime, String communicationTime)

//                saveXMLFile();
                break;
            case PhoneSituation._AVAILABLE:

                MyNote.showinOutPut(getClass(),
                        "Burada telefon kapatildigi anda olan islemleri  burada eklemek yerine telefon setOnClose -->\n" +
                                "bir class acip\n" +
                                "liste olusturup\n" +
                                "liste icine event yukleyip\n" +
                                "sonrasinda bu eventi telefon kapatma ya da serverdaki telefon kapatma olayina ekleme \n" +
                                "boylece telefon kapattigimizda olan islemler ayni zamanda servendan telefonu kapattigimiz zamanda olacak\n" +
                                "!!! ===>>>  phone.SetOnClosRequest burada arama esnasinda degistirildigi icin bunu tekrardan duzeltmek gerekiyor. \n" +
                                "Bunu da ActionEvent Classi olusturuldugu vakit duzelticem");
                signalLost(callerRegisteredPhoneCard);
                signalLost(dialedRegisteredPhoneCard);
                connectionIsPossible(callerPhone, dialedPhone);
                waitToGetAnswerFromDialedPhone();
//                break;
//                addLastRecordsInXMLFile();
                return;
            case PhoneSituation.
                    _BUSY:

                dialedPhoneIsBusy(callerPhone);
                //      prepareRecordCall(callerPhone, dialedPhone, callIsAnswered, timeAtThatMoment.getCallTimeInString(), stopWatch.getTimeString());
//                endCall();
                break;

        }

        saveRecordForCallerPhone();
//        addCallHistory(callerPhone, dialedPhone.getNumber(), callBolleanVal, callIsAnswered);
//        addLastRecordsInXMLFile();
    }

    void connectionIsPossible(Phone callerPhone, Phone dialedPhone) {
        dialedPhoneIsAvailable(callerPhone);
        setSituationBusyPhonesWhichAreInCall();
        dialedPhone.getPhoneController().beingCalledByThisContact(new Contact(null, callerPhone.getNumber()));

        disableKey(callerPhone);
        activateCallerPhoneKeyToHangUpCall(callerPhone);

        disableKey(dialedPhone);
        activateKeyToPickUpCall(dialedPhone);
        activateDialedPhoneKeyToHangUpCall(dialedPhone);
    }

    void startPhoneCallSession() {
        disableKey(dialedPhone);
        /** just added this hangUpCall  func. because other parts are already added before */
        activateDialedPhoneKeyToHangUpCall(dialedPhone);
        stopWatch = new StopWatch(callerPhone, dialedPhone);


    }

    void playMusic(Phone dialedPhone) {
        dialedPhone.getMusicPlayer().playMusicRingTone();
//        musicPlayer = new MusicPlayer();
//        musicPlayer.playMusic(new MusicPath().getNokiaRingTone());
    }

    void stopMusic(Phone phone) {
        phone.getMusicPlayer().stopMusic();

    }

    void disableKey(Phone phone) {
        NumberKeyEvent numberKeyEvent = new NumberKeyEvent(phone);
        numberKeyEvent.clearEvent(phone.getPhoneController().getPhoneKeyList().getOperatorKeyList());
        numberKeyEvent.clearEvent(phone.getPhoneController().getPhoneKeyList().getNumberKeyList());

    }

    void activateKeyToPickUpCall(Phone phone) {
        new PhoneKeyWanted(phone).getPhoneKey(1, 0).setOnAction(pickUpEvent("Connected"));
    }

    void activateCallerPhoneKeyToHangUpCall(Phone phone) {
        new PhoneKeyWanted(phone).getPhoneKey(1, 2).setOnAction(hangUpEvent("Call is ended"));
    }

    void activateDialedPhoneKeyToHangUpCall(Phone phone) {
        new PhoneKeyWanted(phone).getPhoneKey(1, 2).setOnAction(hangUpEvent("The Number Is busy"));
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    void waitToGetAnswerFromDialedPhone() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    playMusic(dialedPhone);
                    Thread.sleep(connectionWaitingTimeMs);
                    if (isConnectionWaitingTimeOver == false && callIsAnswered == false) {
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {

                                setTextSituationPhone(callerPhone, "was not answered");
                                endCall();
                            }
                        });
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    void setSituationBusyPhonesWhichAreInCall() {
        UpdationRegisteredPhoneCardSituation.setColorRegisteredCardPhoneSituationColorBusy(callerRegisteredPhoneCard);
        UpdationRegisteredPhoneCardSituation.setColorRegisteredCardPhoneSituationColorBusy(dialedRegisteredPhoneCard);
    }

    void setSituationAvailablePhoneWhichAreEndedCall(RegisteredPhoneCard registeredPhoneCard) {
        int cardSituation = registeredPhoneCard.getPhone().getSituation();
        if (cardSituation != PhoneSituation._CLOSED) {
            UpdationRegisteredPhoneCardSituation.setColorRegisteredCardPhoneSituationColorAvailable(registeredPhoneCard);
        }
    }

    void endCall() {
        System.out.println("ARAMA BITTIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
        stopMusic(dialedPhone);
        isConnectionWaitingTimeOver = true;
        prepareRecordCall(callerPhone, dialedPhone, callIsAnswered, timeAtThatMoment.getCallTimeInString(), getStopWatchTime()); //"00:00:00"  stopWatch.getTimeString()

        setSituationAvailablePhoneWhichAreEndedCall(callerRegisteredPhoneCard);
        setSituationAvailablePhoneWhichAreEndedCall(dialedRegisteredPhoneCard);


        /**
         * first have to add stopWatch stoping code and then add to change screen,
         * Because stopwatch setText time in callerScreen, When we change the screen
         * then there will be match problem with screens
         *
         * And have to add after uppers because when call is connected then stopwatch starts and
         * when call is ended then it wont be like "was not answered" instead of "call is ended" */
        killStopWatch();

        new Function(callerPhone).activateKeyByLastScreenController(callerPhone);
        new Function(dialedPhone).changeScreenToLastScreen();
//        callerPhone.
//        new RegisteredPhoneCardUpdateSituation(callerRegisteredPhoneCard).phoneClose();
//        new RegisteredPhoneCardUpdateSituation(dialedRegisteredPhoneCard).phoneClose();

        addCloseRequestAfterEndedCall(callerRegisteredPhoneCard);
        addCloseRequestAfterEndedCall(dialedRegisteredPhoneCard);

//        callerRegisteredPhoneCard.getPhone().getStage().setOnCloseRequest(e -> {
//            new RegisteredPhoneCardUpdateSituation(callerRegisteredPhoneCard).phoneClose();
//
//        });
//        dialedRegisteredPhoneCard.getPhone().getStage().setOnCloseRequest(e -> {
//            new RegisteredPhoneCardUpdateSituation(dialedRegisteredPhoneCard).phoneClose();
//
//        });

        saveRecordForCallerPhone(); //addCallHistory(callerPhone, dialedPhone.getNumber(), callBolleanVal, callIsAnswered);
        saveRecordForDialedPhone(); //addCallHistory(dialedPhone, callerPhone.getNumber(), dialedBolleanVal, callIsAnswered);
//        addLastRecordsInXMLFile();
    }

    void saveRecordForCallerPhone() {
        saveXMLFile();
        addCallHistory(callerPhone, dialedPhone.getNumber(), callBolleanVal, callIsAnswered);

    }

    void saveRecordForDialedPhone() {

        addCallHistory(dialedPhone, callerPhone.getNumber(), dialedBolleanVal, callIsAnswered);

    }

    void addCallHistory(Phone phone, String contactNumber, boolean callSomeone, boolean answered) {
//        System.out.println("CONTACT : "+new IdentifyNumber(phone).identifyNumber(contactNumber));
//        Contact contact = new IdentifyNumber(phone).identifyNumber(contactNumber);
//        if (contact == null) {
//            contact = new Contact(null, contactNumber);
//        }

        System.out.println(" BIR KERE EKLENMIS OMASI LAZIMMMM ::::::::::::::::::::::::::::::::::::::::  saveXMLFile(); saveXMLFile();");

        if (stopWatch != null) {
            communicationTime = stopWatch.getTimeString();
            System.out.println("COMMUNUCAITON TYIME :" + communicationTime);
        } else {
            System.out.println("STOPWATH = NULLLLL");
        }
        phone.getCallHistory().addCall(new IdentifyNumber(phone).identifyNumber(contactNumber), callSomeone, answered, timeAtThatMoment, communicationTime);


//public void addCall(Contact contact, boolean callSomeone,  boolean answered,TimeAtThatMoment timeAtThatMoment, String communicationTime) {

    }

    /**
     * this func. is added because when call is started then phone Close Request is changed by adding   situation set info according to some situations. So if we dont change
     * it like old version than after if we try to close  phone we will get error by not finding caling screen situation
     */
    void addCloseRequestAfterEndedCall(RegisteredPhoneCard registeredPhoneCard) {
        registeredPhoneCard.getPhone().getStage().setOnCloseRequest(e -> {
            new RegisteredPhoneCardUpdateSituation(registeredPhoneCard).phoneClose();
        });

    }


    void dialedPhoneIsClosed(Phone callerPhone) {
        setTextSituationPhone(callerPhone, "The Number Is Not Reachable For Now");
    }

    void dialedPhoneIsBusy(Phone callerPhone) {
        setTextSituationPhone(callerPhone, "The Number Is Busy");
    }

    void dialedPhoneIsAvailable(Phone callerPhone) {
        setTextSituationPhone(callerPhone, "Is Calling");
//        System.out.println("IS CALLING YAZIYOR MU");
//        System.out.println("USTTEKI YAZIYOR MU ?");
    }

    void signalLost(RegisteredPhoneCard registeredPhoneCard) {

        registeredPhoneCard.getPhone().getStage().setOnCloseRequest((e) -> {

            setTextSituationPhone(callerPhone, "signal is lost");
            setTextSituationPhone(dialedPhone, "signal is lost");
            endCall();
            System.out.println("  <<<< End Call function seems like  unnecessery>>");
            new RegisteredPhoneCardUpdateSituation(registeredPhoneCard).phoneClose();
        });

    }

    void setTextSituationPhone(Phone phone, String text) {
        try {
            if (phone.getStage().isShowing()) {
                Label lblSituation = ((BaseCallScreenController) phone.getPhoneController().getScreen().getController()).getLblSituation();
                lblSituation.setText(text);
            }
        } catch (ClassCastException ex) {
            System.out.println("------------------------------------->>>> HATA " + ex.getMessage());
        }

    }


    public void killStopWatch() {
        if (stopWatch != null) {
            communicationTime = stopWatch.stopTime();
            setTextSituationPhone(callerPhone, "Call is ended");
            setTextSituationPhone(dialedPhone, "Call is ended");

        }
    }

    EventHandler<ActionEvent> hangUpEvent(String textWillSeeOnCallerSituation) {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                setTextSituationPhone(callerPhone, textWillSeeOnCallerSituation);
                endCall();

            }
        };
    }

    EventHandler<ActionEvent> pickUpEvent(String txtInfoConnectionIsSuccesfull) {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stopMusic(dialedPhone);
                callIsAnswered = true;
                System.out.println("ARAMA CEVAPLANDI TRU OLDU " + callIsAnswered);
                setTextSituationPhone(callerPhone, txtInfoConnectionIsSuccesfull);
                setTextSituationPhone(dialedPhone, txtInfoConnectionIsSuccesfull);
                startPhoneCallSession();
//                addLastRecordsInXMLFile();

            }
        };


    }

    void saveXMLFile() {
        RecordServer recordServer = new RecordServer();
        List<RecordCall> list = prepareRecordCall(callerPhone, dialedPhone, callIsAnswered, timeAtThatMoment.getCallTimeInString(), getStopWatchTime());

        recordServer.addListCallOpearations(list);
//        RecordManagement recordManagement = new RecordManagement(server);
        new RecordManagement(server).recordCall(recordServer);
//        recordManagement.recordCall(recordServer);

    }

    String getStopWatchTime() {
        if (stopWatch != null) {
            return stopWatch.getTimeString();
        }
        return "00:00:00";
    }

    List<RecordCall> prepareRecordCall(Phone caller, Phone dialed, boolean connected, String callTime, String communicationTime) {

        RecordServer recordServer = new RecordServer();
        recordCall.setPhoneCalled(caller.getNumber());
        recordCall.setPhoneDialed(dialed.getNumber());
        recordCall.setConnected(connected);
        recordCall.setCallTime(callTime);
        recordCall.setCommunicationTime(communicationTime);

        List list = new ArrayList<RecordCall>();
        list.add(recordCall);
        return list;


    }
//
//    RecordServer getRecordServerToSaveXML(Phone sentMessage, String phoneNumberReceivedMessage, String messageText, TimeAtThatMoment time) {
//        RecordServer recordServer = new RecordServer();
//        recordServer.addListMessageOpearations(prepareRecordCall(sentMessage, phoneNumberReceivedMessage, messageText, time));
//
//        return recordServer;
//
//    }



    /*
    *         RecordManagement recordManagement = new RecordManagement(sendMessagePhone.getServer());
//        System.out.println("sentMessage.getTimeAtThatMoment()  NULL MU BAKKKK"+sentMessage.getTimeAtThatMoment()) ;
        recordManagement.recordMessage(getRecordServerToSaveXML(sendMessagePhone, getReceivedTextPhoneNumber(), messageText, sentMessage.getTimeAtThatMoment()));

* */
//
//    void addLastRecordsInXMLFile() {
//        System.out.println("GELINDIIIIIIIIIIIIIIIIIII");
//        server.getArchive().getCallXMLFile().writeXMLFile(callerPhone, dialedPhone, "Call", callIsAnswered, timeAtThatMoment,communicationTime);
//
//
//    }
}
