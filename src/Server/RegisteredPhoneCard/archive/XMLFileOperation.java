package server.registeredphonecard.archive;

import phone.ExceptionManagement;
import server.Server;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class XMLFileOperation {
    Server server;
    MyJAXBManagement myJAXBManagement = new MyJAXBManagement();

    public XMLFileOperation(Server server) {
        this.server = server;
    }

    void createAndWriteFile(Class clazz, Object object, String fileName) {

        try {
            myJAXBManagement.writeObjectToXMLFile(clazz, object, fileName);
        } catch (JAXBException ex) {
            ExceptionManagement.printException(ex);
        } catch (FileNotFoundException ex) {
            ExceptionManagement.printException(ex);
        }
    }

    RecordServer readFile(Class clazz, String fileName) throws FileNotFoundException {
        try {
            return myJAXBManagement.readXMLFileAndConvertToObject(clazz, fileName); // return RecordServer
        } catch (JAXBException ex) {
            ExceptionManagement.printException(ex);
        }
        return null;
    }

    void updateFile(Class clazz, Object object, String fileName, List<IRecord> listInterface) throws FileNotFoundException {
        RecordServer recordServer = (RecordServer) object;
        for (IRecord temp : listInterface) {
            temp.addList(recordServer, readFile(clazz, fileName));
        }
        server.setRecordServer(recordServer);
//        server.getRecordServer().printRecordServerMessageList();

        createAndWriteFile(clazz, server.getRecordServer(), fileName);
    }

    public void appendFile(Class clazz, Object object, String fileName, IRecord iRecord) {
        try {
            updateFile(clazz, object, fileName, getInterfaceList());
        } catch (IllegalArgumentException ex) {
            createAndWriteFile(clazz, object, fileName);
        } catch (FileNotFoundException e) {
            createAndWriteFile(clazz, object, fileName);
        }
    }

    void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    List<IRecord> getInterfaceList() {
        List<IRecord> list = new ArrayList<>();
        list.add(new RecordMessageManagement());
        list.add(new RecordCallManagement());
        return list;
    }
}
