package server.registeredphonecard.archive;

public class RecordMessageManagement implements IRecord {

    @Override
    public void addList(RecordServer recordServer, RecordServer newRecord) {
        recordServer.addListMessageOpearations(newRecord.getMessageList());
    }
}
