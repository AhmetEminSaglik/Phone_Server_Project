package phone.screen.callingscreen.callingsomeone;

import phone.Phone;
import phone.screen.callingscreen.BaseCallScreenController;
import phone.screen.callingscreen.Call;
import phone.screen.registerednumbers.contact.Contact;

public class CallingScreenController extends BaseCallScreenController {
    Call call;

    public CallingScreenController(Phone phone, Contact contact) {
        super(phone, contact);
    }

    @Override
    public void executeProcess() {
        callContact();
    }

    public void callContact() {
        if (isNumberCallable(phone, contact)) {
            Phone callingPhone = findNumberInServer();
            if (callingPhone != null) {

                waitUntillPhoneIsPickUp(callingPhone);
            } else {
                setTextLblContactInfo(contact.getPerson().toString());
                setTextSituation("Wrong number");
            }
        }
    }

    Phone findNumberInServer() {
        call = new Call(phone);

        Phone callingPhone = null;
        if (isNumberCallable(phone, contact)) {
            callingPhone = call.searcNumberInServer(contact);
            if (callingPhone != null) {
                setTextLblContactInfo(contact.getPerson().toString());
            }
        } else {
            setTextSituation("You cant call yourself");
        }
        return callingPhone;
    }

    boolean isNumberCallable(Phone phone, Contact contact) {
        if (phone.getNumber().equals(contact.getPhoneNumber())) {
            setTextSituation("You cant call yourself");
            return false;
        }
        return true;
    }

    void setTextSituation(String text) {
        setTextLblSituation(text);
    }

    void waitUntillPhoneIsPickUp(Phone callPhone) {
        call.callNumber(callPhone);
    }
}
