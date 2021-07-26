package phone.screen.callingscreen.comingcall;

import phone.Phone;
import phone.screen.callingscreen.BaseCallScreenController;
import phone.screen.registerednumbers.contact.Contact;
import phone.utility.IdentifyNumber;

public class ComingCallScreenController extends BaseCallScreenController {

    public ComingCallScreenController(Phone phone, Contact contact) {
        super(phone, contact);
    }


    @Override
    public void updateScreen() {
        identifyComingCall();
        setTextLblSituation("Coming Call");
        setTextLblContactInfo(contact.getPerson().toString());

    }

    void identifyComingCall() {

        Contact identifyContact = new IdentifyNumber(phone).identifyNumber(contact.getPhoneNumber());// phone.getRegisteredContact().getContactByPhoneNumber(contact.getPhoneNumber());
        if (identifyContact != null) {
            contact.setContact(identifyContact);
        }

    }
//
//    @Override
//    public void addActionToOperatorKeys() {
//        super.addActionToOperatorKeys();
//        System.out.println(getClass().getSimpleName()+"COMING CALL --->>>>>> BURADA ");
//    }
}

