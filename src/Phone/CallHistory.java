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
//    Phone phone;
//    List<CallHistoryCard> list = new ArrayList<>();

//
//    public CallHistory(Phone phone) {
//        this.phone = phone;
//    }


    public void addCall(Contact contact, boolean callSomeone, boolean answered, TimeAtThatMoment timeAtThatMoment, String communicationTime) {

        String callExpression = callSomeone == true ? " >> " : " << ";
        String answeredExpression = answered == true ? " ✓ " : " X ";

        add(new CallHistoryCard(contact, callExpression, answeredExpression, timeAtThatMoment, communicationTime));//, null

//        System.out.println("gelen communication Time"+communicationTime );
    }


    @Override
    public void updateHistory() {
        updateCallHistory();
    }

    void updateCallHistory() {
        for (CallHistoryCard item : list) {
            item.setContact(new IdentifyNumber(phone).identifyNumber(item.getContact().getPhoneNumber()));
        }
//            System.out.println("ITEM contact ESKIIIIIIIIIIIIIIIIIIIIIII" +item.getContact());
//            System.out.println("------------->>>>"+item.toString());
//            System.out.println("-------------AAA>>>>"+item.getContact());

//            System.out.println("-------------AAA>>>>"+item.getContact());
//            Contact contact = new Contact((new IdentifyNumber(phone).identifyNumber(item.getContact().getPhoneNumber()).getPerson()),item.getContact().getPhoneNumber());
//            item = new CallHistoryCard(contact,item.getCallExpression(),item.getAnsweredExpression(),null);
//            System.out.println("ITEM contact YENIIIIIIIIIIIIIIIIIIIIIII" +item.getContact());
//            System.out.println("tanimlanan numara : "+new IdentifyNumber(phone).identifyNumber(item.getContact().getPhoneNumber()));


//
//        for (CallHistoryCard item : list) {
//            System.out.println("UPDATETEN SONRA Item : "+item);
//
//        }

    }
//
//    public List getList() {
//        return list;
//    }
//
//    public int size() {
//        return list.size();
//    }

}
