package server.registeredphonecard.archive.recordclass;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "call")
@XmlType(propOrder = {"phoneCalled",
        "phoneDialed",
        "callTime",
        "connected",
        "communicationTime"})

public class RecordCall {

    String phoneCalled;
    String phoneDialed;
    String callTime;
    boolean connected;
    String communicationTime;

    @XmlElement(name = "numberCalled")
    public String getPhoneCalled() {
        return phoneCalled;
    }

    public void setPhoneCalled(String phoneCalled) {
        this.phoneCalled = phoneCalled;
    }

    @XmlElement(name = "numberDialed")
    public String getPhoneDialed() {
        return phoneDialed;
    }

    public void setPhoneDialed(String phoneDialed) {
        this.phoneDialed = phoneDialed;
    }

    @XmlElement(name = "callTime")
    public String getCallTime() {
        return callTime;
    }

    public void setCallTime(String callTime) {
        this.callTime = callTime;
    }

    @XmlElement(name = "connected")
    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }


    @XmlElement(name = "communicationTime")
    public String getCommunicationTime() {
        return communicationTime;
    }

    public void setCommunicationTime(String communicationTime) {
        this.communicationTime = communicationTime;
    }
}
