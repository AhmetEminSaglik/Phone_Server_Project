package server;

import archive.Archive;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mynote.MyNote;

import java.io.File;

public class Server extends Application {
    private ServerController serverController = new ServerController(this);
    Archive archive= new Archive();

    @Override
    public void start(Stage primaryStage) throws Exception {


//        XMLFile xmlFile= new XMLFile();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Server.fxml"));
        fxmlLoader.setController(serverController);
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Phone Server");
        primaryStage.setWidth(500);
        primaryStage.setHeight(600);
//        primaryStage.setResizable(false);
        primaryStage.setOnCloseRequest(e -> {
            System.exit(0);
        });
        primaryStage.show();
//        notuGoster();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void notuGoster() {
        String text = " ";
        MyNote.showinOutPut(getClass(), text);


    }
    public Archive getArchive() {
        return archive;
    }
    public ServerController getServerController() {
        return serverController;
    }


}
