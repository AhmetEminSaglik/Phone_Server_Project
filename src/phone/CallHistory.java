package phone;

import date.TimeAtThatMoment;
import phone.screen.listviewscreen.listViewCard.CallHistoryCard;
import phone.screen.registerednumbers.contact.Contact;
import phone.utility.IdentifyNumber;

import java.util.ArrayList;
import java.util.List;

public class CallHistory extends History<CallHistoryCard> {
    public CallHistory(Phone phone) {
        super(phone);
    }

    public void addCall(Contact contact, boolean callSomeone, boolean answered, TimeAtThatMoment timeAtThatMoment, String communicationTime) {

        String callExpression = callSomeone == true ? " >> " : " << ";
        String answeredExpression = answered == true ? " ✓ " : " X ";

        add(new CallHistoryCard(contact, callExpression, answeredExpression, timeAtThatMoment, communicationTime));//, null
    }

    @Override
    public void updateHistory() {
        updateCallHistory();
    }

    void updateCallHistory() {
        for (CallHistoryCard item : list) {
            item.setContact(new IdentifyNumber(phone).identifyNumber(item.getContact().getPhoneNumber()));
        }

    }
}
