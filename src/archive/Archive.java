package archive;

import java.io.File;

public class Archive {
    String archiveFolderName = "Server Archive";
    //    XMLFileArcive callArchive;
//    XMLFileArcive messageArchive;
    XMLFile callXMLFile;
    XMLFile messageXMLFile;


    public Archive() {
        new File(archiveFolderName).mkdirs();
        System.out.println("Archive CONSTRUCOTR GELINDI");

        callXMLFile = new XMLFile(archiveFolderName + "/Call Archive");
//        messageXMLFile = new XMLFile(archiveFolderName + "/Message Archive");
//        messageXMLFile = new XMLFile(archiveFolderName + "/Message Archive");
//        callArchive = new XMLFileArcive(archiveFolderName + "/call Archive.txt");
//        messageArchive = new XMLFileArcive(archiveFolderName + "/message Archive.txt");
    }

    public XMLFile getCallXMLFile() {
        return callXMLFile;
    }

    public XMLFile getMessageXMLFile() {
        return messageXMLFile;
    }
}
