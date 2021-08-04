package server;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import server.registeredphonecard.archive.RecordServer;
import server.registeredphonecard.archive.XMLFileOperation;

public class Server extends Application {
    private server.ServerController serverController = new server.ServerController(this);

    XMLFileOperation xmlFileOperation = new XMLFileOperation(this);
    RecordServer recordServer;


    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Server.fxml"));
        fxmlLoader.setController(serverController);
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Phone Server");
        primaryStage.setWidth(500);
        primaryStage.setHeight(600);

        primaryStage.setOnCloseRequest(e -> {
            System.exit(0);
        });
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    public ServerController getServerController() {
        return serverController;
    }

    public XMLFileOperation getXmlFileOperation() {
        return xmlFileOperation;
    }

    public RecordServer getRecordServer() {
        if (recordServer == null)
            recordServer = new RecordServer();
        return recordServer;
    }

    public void setRecordServer(RecordServer recordServer) {
        this.recordServer = recordServer;
    }
}
