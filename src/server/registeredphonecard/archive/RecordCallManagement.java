package server.registeredphonecard.archive;

public class RecordCallManagement implements IRecord {
    @Override
    public void addList(RecordServer recordServer, RecordServer newRecord) {
        recordServer.addListCallOpearations(newRecord.getCallList());
    }

}
