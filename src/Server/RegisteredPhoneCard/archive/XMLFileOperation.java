package server.registeredphonecard.archive;

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
        } catch (JAXBException e) {
            printError(e);
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            printError(e);
        }
    }

    RecordServer readFile(Class clazz, String fileName) throws FileNotFoundException {
        try {
            return myJAXBManagement.readXMLFileAndConvertToObject(clazz, fileName); // return RecordServer
        } catch (JAXBException e) {
            printError(e);
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
            System.out.println("Exception : " + ex.getMessage());
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
