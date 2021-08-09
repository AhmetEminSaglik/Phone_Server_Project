package server.registeredphonecard.archive.recordclass;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "message")
@XmlType(propOrder = {
        "phoneSentMessage",
        "phonerReceivedMessage",
        "message",
        "timeAtThatMoment"
})

public class RecordMessage {

    String phoneSentMessage;
    String phonerReceivedMessage;
    String message;
    String time;

    @XmlElement(name = "numberSentMessage")
    public String getPhoneSentMessage() {
        return phoneSentMessage;
    }

    public void setPhoneSentMessage(String phoneSentMessage) {
        this.phoneSentMessage = phoneSentMessage;
    }

    @XmlElement(name = "numberReceivedMessage")
    public String getPhonerReceivedMessage() {
        return phonerReceivedMessage;
    }

    public void setPhonerReceivedMessage(String phonerReceivedMessage) {
        this.phonerReceivedMessage = phonerReceivedMessage;
    }

    @XmlElement(name = "text")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @XmlElement(name = "time")
    public String getTimeAtThatMoment() {
        return time;
    }

    public void setTimeAtThatMoment(String time) {
        this.time = time;
    }
}

