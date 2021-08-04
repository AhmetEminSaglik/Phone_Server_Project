package server.findnumber;

import phone.Phone;
import phone.screen.registerednumbers.contact.Contact;
import server.Server;

public class FindTheNumberIsExistInServer { // IdentifyNumber
    Server server;

    public FindTheNumberIsExistInServer(Server server) {
        this.server = server;
    }

    public Phone searcNumber(Contact contact) {
        return findNumber(contact);
    }


    Phone findNumber(Contact contact) {
        return server.getServerController().findPhoneByNumber(contact.getPhoneNumber());
    }

}

