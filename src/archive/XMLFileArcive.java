/*
package archive;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class XMLFileArcive {
    String fileName;


    public XMLFileArcive(String fileName) {
        this.fileName = fileName;
        createTxt(fileName);
    }

    public void createTxt(String fileName) {
        File txtArchive = new File(fileName);

        try {
            if (!txtArchive.createNewFile()) {
                System.out.println(fileName + " file is created");
            } else {
                System.out.println(fileName + " file is not created");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void write(String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(text);
            writer.newLine();


        } catch (IOException e) {
            e.printStackTrace();
        }
//        try {
//            FileWriter myWriter = new FileWriter(fileName);
//            myWriter.append(text);
//            myWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }
}
*/
