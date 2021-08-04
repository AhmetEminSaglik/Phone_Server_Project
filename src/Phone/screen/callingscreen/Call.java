package phone.screen.callingscreen;

import phone.Phone;
import phone.screen.registerednumbers.contact.Contact;
import server.Server;
import server.findnumber.FindTheNumberIsExistInServer;

public class Call {
    Server server;
    Phone phoneWhoSendCallRequest;
    FindTheNumberIsExistInServer findTheNumberIsExistInServer;

    public Call(Phone phone) {
        server = phone.getServer();
        this.phoneWhoSendCallRequest = phone;
        findTheNumberIsExistInServer = new FindTheNumberIsExistInServer(server);//, phone
    }

    public Phone searcNumberInServer(Contact contact) {
        return findTheNumberIsExistInServer.searcNumber(contact);
    }

    public void callNumber(Phone PhoneWhoIsDialed) {
        server.getServerController().callNumber(new Contact(null, phoneWhoSendCallRequest.getNumber()),
                new Contact(null, PhoneWhoIsDialed.getNumber())
        );

    }
}