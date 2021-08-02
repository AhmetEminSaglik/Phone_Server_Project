package server.registeredphonecard.archive;


import server.registeredphonecard.archive.recordclass.RecordCall;
import server.registeredphonecard.archive.recordclass.RecordMessage;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(namespace = "Server")
@XmlAccessorType(XmlAccessType.FIELD)

public class RecordServer {


    @XmlElementWrapper(name = "CallList")
    @XmlElement(name = "CallInfo")
    private List<RecordCall> callList = new ArrayList<RecordCall>();


    @XmlElementWrapper(name = "MessageList")
    @XmlElement(name = "messageInfo")
    private List<RecordMessage> messageList = new ArrayList<RecordMessage>();


    public List<RecordCall> getCallList() {
        return callList;
    }

    public void setCallList(List<RecordCall> callList) {
        this.callList = callList;
    }

    public List<RecordMessage> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<RecordMessage> messagesList) {
        this.messageList = messagesList;
    }

    public void addListMessageOpearations(List list) {
        messageList.addAll(list);
    }

    public void addListCallOpearations(List list) {
        callList.addAll(list);
    }

    /*  public void unionMessageOperations(List firstList, List secondList) {

          getClass().cast(firstList);

          List<RecordMessage> recordMessageList = new ArrayList<RecordMessage>();
          recordMessageList.addAll(firstList);
          recordMessageList.addAll(secondList);
          setRecordMessagesList(recordMessageList);

      }*/
    public RecordServer getRecordServerByUnmarshalFile(Unmarshaller unmarshaller, String fileName) {
        RecordServer recordServer = null;
        try {
            recordServer = (RecordServer) unmarshaller.unmarshal(new File(fileName));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return recordServer;
    }


    public RecordServer getRecordServerAllObjectsByConvertingXMLToJavaObjectClass(Unmarshaller unmarshaller, String fileName) {
        return getRecordServerByUnmarshalFile(unmarshaller, fileName);
    }

    public void printRecordServerMessageList() {
        if (messageList.size() > 0) {
            for (RecordMessage temmp : messageList) {
                System.out.println("ELIMIZDEKI RECORDSERVER :" + temmp.getMessage());
            }
        } else {
            System.out.println("OKUNAN DOSYADAKI MESSAGE YOK");
        }
    }
}
