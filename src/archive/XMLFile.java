package archive;


import date.TimeAtThatMoment;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import phone.Phone;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLFile {
    public static String xmlFilePath;

    public XMLFile(String xmlFilePath) {
        this.xmlFilePath = xmlFilePath+".xml";
    }

    public void writeXMLFile(Phone phone1, Phone phone2, String action, boolean connected, TimeAtThatMoment beginningTimeOfCall, String timeOfcommunication) {
        System.out.println("BURAYA GELINDI VE BILGILER connected : " + connected + " time : " + beginningTimeOfCall.getCallTimeInString());

        try {
            Attr attr;
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();


            Element root = document.createElement("Process");
            attr = document.createAttribute("Action");
            attr.setValue(action);
            root.setAttributeNode(attr);
            document.appendChild(root);

//            Element root = document.createElement("Phone");
//            attr = document.createAttribute("id");
//            attr.setValue(phone1.getNumber());
//            root.setAttributeNode(attr);

//            attr = document.createAttribute("Action");
//            attr.setValue(action);
//            root.setAttributeNode(attr);

            Element callerPhone = document.createElement("CallerPhone");
            attr = document.createAttribute("id");
            attr.setValue(phone1.getNumber());
            callerPhone.setAttributeNode(attr);
//
            root.appendChild(callerPhone);

            Element dialedPhone = document.createElement("DialedPhone");
            attr = document.createAttribute("id");
            attr.setValue(phone2.getNumber());
            dialedPhone.setAttributeNode(attr);
//
            root.appendChild(dialedPhone);

            Element beginingTimeOfCommunication = document.createElement("CallTime");
            beginingTimeOfCommunication.appendChild(document.createTextNode(beginningTimeOfCall.getCallTimeInString()));

            root.appendChild(beginingTimeOfCommunication);

            Element callIsAnswered = document.createElement("CallAnswered");
            callIsAnswered.appendChild(document.createTextNode(Boolean.toString(connected).toUpperCase() + ""));
            root.appendChild(callIsAnswered);

            Element communicationTime = document.createElement("CommunicationTime");
            communicationTime.appendChild(document.createTextNode(timeOfcommunication));
            root.appendChild(communicationTime);


//            attr = document.createAttribute("");
//            attr.setValue(phone2.getNumber());
//            dialedPhone.setAttributeNode(attr);
////


//            Element connectionStatus = document.createElement("connected");
//            attr.setValue(connected ? "true" : "false");
//            connectionStatus.setAttributeNode(attr);
//            root.appendChild(connectionStatus);
//
//
//            Element communicationTime = document.createElement("CommunicationTime");
//            attr.setValue(timeAtThatMoment.getCallTimeInString());
//            communicationTime.setAttributeNode(attr);
//            root.appendChild(communicationTime);


          /*  Element firstName = document.createElement("firstname");
            firstName.appendChild(document.createTextNode("Ahmet Emin"));
            employee.appendChild(firstName);


            Element lastName = document.createElement("lastname");
            lastName.appendChild(document.createTextNode("SAGLIK"));
            employee.appendChild(lastName);

            Element department = document.createElement("departmant");
            department.appendChild(document.createTextNode("Software engineer"));
            employee.appendChild(department);*/

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));

            transformer.transform(domSource, streamResult);

            System.out.println("Done creating XML File");


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
