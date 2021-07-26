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
/*

package phone.screen.callingscreen;

        import mynote.MyNote;
        import phone.Phone;
        import phone.screen.registerednumbers.contact.Contact;
        import server.Server;

public class Call {
    Server server;
    Phone phoneWhoSendCallRequest;

    public Call(Phone phone) {
        this.phoneWhoSendCallRequest = phone;
        this.server = phone.getServer();
    }

    public Phone searcNumberInServer(Contact contact) {
//        MyNote.showMessageDialog("call contacta numara bulunduktan sonra, o numaraya gelen arama adli ekran acilmasini istiyorum");

        return findNumberInServer(contact);
    }


    Phone findNumberInServer(Contact contact) {
        return server.getServerController().findPhoneByNumber(contact.getPhoneNumber());
    }

    public void callNumber(Phone PhoneWhoIsDialed) {
        server.getServerController().callNumber(new Contact(null, phoneWhoSendCallRequest.getNumber()),
                new Contact(null, PhoneWhoIsDialed.getNumber())
        );

    }
}
*/
