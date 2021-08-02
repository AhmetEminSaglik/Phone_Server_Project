
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
//        catch (NoClassDefFoundError e){
//            System.out.println(" HATA : "+e.getMessage());
//        }
    }

    RecordServer readFile(Class clazz, String fileName) throws FileNotFoundException {
        try {
            return myJAXBManagement.readXMLFileAndConvertToObject(clazz, fileName); // return RecordServer


        } catch (JAXBException e) {
//            e.printStackTrace();
            System.out.println("BURAYA GIRDIKTEN SONRA NULL DONUYORRRRRRRRRRRRRRRRRR");
            printError(e);
        }
        return null;
    }

    void updateFile(Class clazz, Object object, String fileName, List<IRecord> listInterface) throws FileNotFoundException {
        RecordServer recordServer = (RecordServer) object;
//        List<InterfaceDeneme> list;

//        recordServer.addListMessageOpearations(readFile(clazz, fileName).getMessageList());
//        interfaceDeneme.addList(recordServer, readFile(clazz, fileName));

        for (IRecord temp : listInterface) {
            temp.addList(recordServer, readFile(clazz, fileName));
        }


        server.setRecordServer(recordServer);
        server.getRecordServer().printRecordServerMessageList();


//        int i = 0;
//        for (RecordMessage temp : server.getRecordServer().getMessageList()) {
//            System.out.println(i + "-) " + temp);
//        }
     /*   i = 1;
        for (RecordCallOperation temp : RecordServer.getRecordServer().getCallOperationsList()) {
            System.out.println(i + "-) TOPLAM DEGER temp : " + temp);
            i++;
        }*/

        createAndWriteFile(clazz, server.getRecordServer(), fileName);
//        (RecordServer) object).

    }

    public void appendFile(Class clazz, Object object, String fileName, IRecord iRecord) {
        try {
//            createAndWriteFile(clazz, object, fileName);

            updateFile(clazz, object, fileName, getInterfaceList());
            System.out.println("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ DOSYA BULUNDUUUU");
        } catch (IllegalArgumentException ex) {
            System.out.println("ERROR : " + ex.getMessage());
//            System.out.println("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ DOSYA OLUSTURULDU");
            System.out.println("22222222222222222222222222222222222222222222222222222222 DOSYA BASTAN OLUSTURULDU");
            createAndWriteFile(clazz, object, fileName);
        } catch (FileNotFoundException e) {
            System.out.println("11111111111111111111111111111111111111111111111111111 DOSYA BASTAN OLUSTURULDU");
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
