package phone.screen.listviewscreen.listViewCard;

import date.TimeAtThatMoment;
import phone.screen.basescreen.BaseScreen;
import phone.screen.registerednumbers.contact.Contact;

public class
CallHistoryCard extends Card {
    Contact contact;
    BaseScreen baseScreen;
    String callExpression;
    String answeredExpression;
    TimeAtThatMoment timeAtThatMoment;
    String communicationTime;

    public CallHistoryCard(Contact contact, String callExpression, String answeredExpression, TimeAtThatMoment timeAtThatMoment, String communicationTime) {
        this(contact.getLimitedNameChracter(1, 5) + " " + callExpression + " " + answeredExpression + timeAtThatMoment.getCallTimeInString(), null);

        this.contact = contact;
        this.baseScreen = baseScreen;
        this.callExpression = callExpression;
        this.answeredExpression = answeredExpression;
        this.timeAtThatMoment = timeAtThatMoment;
        this.communicationTime = communicationTime;
    }

    public CallHistoryCard(String name, BaseScreen phoneScreen) {
        super(name, phoneScreen);
    }

    /**
     * this phone call another number ==>  >>
     */

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getCallExpression() {
        return callExpression;
    }

    public void setCallExpression(String callExpression) {
        this.callExpression = callExpression;
    }

    public String getAnsweredExpression() {
        return answeredExpression;
    }

    public void setAnsweredExpression(String answeredExpression) {
        this.answeredExpression = answeredExpression;
    }
}
