package phone;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import phone.key.TimeForClickValue;
import phone.message.MessageHistory;
import musicplayer.MusicPlayer;
import server.Server;

import java.io.IOException;

public class Phone extends Application {
    MusicPlayer musicPlayer = new MusicPlayer();
    private Server server;
    private String number;
    private Stage stage;
    private TimeForClickValue timeForClickValue = new TimeForClickValue(this);
    private PhoneController phoneController = new PhoneController(this, timeForClickValue);
    private ScreenStack screenStack = new ScreenStack();
    private int situation = -1;
    private CallHistory callHistory = new CallHistory(this);
    private Message message = new Message(this);
    private RegisteredContact registeredContact = new RegisteredContact(this);

    public Phone(Server server) {
        this.server = server;
    }

    @Override
    public void start(Stage primaryStage) {
        Parent root = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Phone.fxml")); //
            fxmlLoader.setController(phoneController);
            root = fxmlLoader.load(); //root = FXMLLoader.load(getClass().getResource("Phone.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);

            primaryStage.setResizable(false);
            primaryStage.setTitle(number);
            this.stage = primaryStage;

            primaryStage.show();

        } catch (IOException e) {
            System.out.println("Exception :" + e.getMessage());
            e.printStackTrace();

            System.exit(0);
        }
    }


    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PhoneController getPhoneController() {
        return phoneController;
    }

    public ScreenStack getScreenStack() {
        return screenStack;
    }

    public void setScreenStack(ScreenStack screenStack) {
        this.screenStack = screenStack;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public RegisteredContact getRegisteredContact() {
        return registeredContact;
    }

    public void setRegisteredContact(RegisteredContact registeredContact) {
        this.registeredContact = registeredContact;
    }

    public int getSituation() {
        return situation;
    }

    public void setSituation(int situation) {
        this.situation = situation;
    }

    public MusicPlayer getMusicPlayer() {
        return musicPlayer;
    }

    public void setMusicPlayer(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    public CallHistory getCallHistory() {
        return callHistory;
    }

    public void setCallHistory(CallHistory callHistory) {
        this.callHistory = callHistory;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "number='" + number + '\'' +
                '}';
    }
}
