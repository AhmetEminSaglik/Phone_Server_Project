
package server.registeredphonecard.archive;


import javax.xml.bind.*;
import java.io.File;
import java.io.FileNotFoundException;


public class MyJAXBManagement {

    JAXBContext getJAXBContent(Class clazz) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(clazz);
        return context;
    }

    Unmarshaller getUnmarshaller(Class clazz) throws JAXBException {
        return getJAXBContent(clazz).createUnmarshaller();
    }

    Marshaller getMarshaller(Class clazz) throws JAXBException {
        Marshaller marshaller = getJAXBContent(clazz).createMarshaller();
        setMarshallerProperty(marshaller);
        return marshaller;
    }

    void setMarshallerProperty(Marshaller marshaller) throws PropertyException {
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    }

    void writeToXMLFile(Marshaller marshaller, Object object, String fileName) throws JAXBException {
        marshaller.marshal(object, new File(fileName));
  }

    /**
     * @param clazz    <ns2:\\clazz is name of class which will be wrote here \\ xmlns:ns2="com.company.book">
     * @param object   is a class which variables will be wrote  as xmlElement
     * @param fileName
     * @throws JAXBException
     * @throws FileNotFoundException
     */
    public void writeObjectToXMLFile(Class clazz, Object object, String fileName) throws JAXBException, FileNotFoundException { //writeObjectInXMLFormatInXMLFile
        Marshaller marshaller = getMarshaller(clazz);
        writeToXMLFile(marshaller, object, fileName);
    }

    /**
     * Unmarshaler must convert by which class want to be reached in xml file
     */
    public RecordServer readXMLFileAndConvertToObject(Class clazz, String fileName) throws JAXBException {
        Unmarshaller unmarshaller = getUnmarshaller(clazz);
        RecordServer recordServer = (RecordServer) unmarshaller.unmarshal(new File(fileName));
        recordServer.getRecordServerAllObjectsByConvertingXMLToJavaObjectClass(unmarshaller, fileName);
        return recordServer;
    }

}
