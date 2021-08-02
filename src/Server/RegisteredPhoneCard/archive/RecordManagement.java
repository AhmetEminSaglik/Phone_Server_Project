package server.registeredphonecard.archive;

import server.Server;

public class RecordManagement {

    Server server;

    public RecordManagement(Server server) {
        this.server = server;

    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public void recordMessage(RecordServer recordServer) {


        appendToFile(recordServer, new RecordMessageManagement());
//        XMLFileOperation xmlFileOperation = new XMLFileOperation(server);
//        xmlFileOperation.appendFile(recordServer.getClass(), recordServer, getFileName(), interfaceDeneme);

    }

    public void recordCall(RecordServer recordServer) {


        appendToFile(recordServer, new RecordCallManagement());
//        XMLFileOperation xmlFileOperation = new XMLFileOperation(server);
//        xmlFileOperation.appendFile(recordServer.getClass(), recordServer, getFileName(), interfaceDeneme);

    }

    void appendToFile(RecordServer recordServer, IRecord iRecord) {
        XMLFileOperation xmlFileOperation = new XMLFileOperation(server);
        xmlFileOperation.appendFile(recordServer.getClass(), recordServer, getFileName(), iRecord);

    }


    String getFileName() {
        return "Server.xml";
    }
}
