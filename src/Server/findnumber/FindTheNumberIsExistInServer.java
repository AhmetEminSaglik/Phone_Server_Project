package server.findnumber;

import phone.Phone;
import phone.screen.registerednumbers.contact.Contact;
import server.Server;

public class FindTheNumberIsExistInServer { // IdentifyNumber
    Server server;
//    Phone phoneWhichWantToExecuteProcess;

    public FindTheNumberIsExistInServer(Server server) { //, Phone phoneWhichWantToExecuteProcess
        this.server = server;
//        this.phoneWhichWantToExecuteProcess = phoneWhichWantToExecuteProcess;
    }

    public Phone searcNumber(Contact contact) {
//        MyNote.showMessageDialog("call contacta numara bulunduktan sonra, o numaraya gelen arama adli ekran acilmasini istiyorum");

        return findNumber(contact);
    }


    Phone findNumber(Contact contact) {
        return server.getServerController().findPhoneByNumber(contact.getPhoneNumber());
    }

//    public void callNumber(Phone PhoneWhoIsDialed) {
//        server.getServerController().callNumber(new Contact(null, phoneWhichWantToExecuteProcess.getNumber()),
//                new Contact(null, PhoneWhoIsDialed.getNumber())
//        );

    }

