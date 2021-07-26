package server.stopwatch;


import javafx.application.Platform;
import phone.Phone;
import phone.screen.callingscreen.BaseCallScreenController;

import javax.swing.*;

public class StopWatch {
    int second = 0;
    int minute = 0;
    int hour = 0;
    Timer timer;
    boolean secondPassed = false;

    public StopWatch(Phone callerPhone, Phone dialedPhone) {

        timer = new Timer(1000, (e) -> {
            second++;
            if (second == 60) {
                minute++;
                second = 0;
            }
            if (minute == 60) {
                minute = 0;
                hour++;
            }
//            secondPassed = true;
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    setPassedTimePhoneInCommunication(callerPhone, getTimeString());
                    setPassedTimePhoneInCommunication(dialedPhone, getTimeString());
                }
            });

        });

        timer.start();
    }

    void setPassedTimePhoneInCommunication(Phone phone, String text) {
        if (phone.getStage().isShowing())
            ((BaseCallScreenController) phone.getPhoneController().getScreen().getController()).setTextLblTime(text);

    }

    public void startTime() {
        timer.start();
    }

    public String stopTime() {

        timer.stop();
        return getTimeString();
    }

    String integerToString(int value) {
        String text = "";
        if (value < 10) {
            text += "0";
        }
        text += Integer.toString(value);
        return text;
    }

    public String getTimeString() {
        return integerToString(hour) + " : " + integerToString(minute) + " : " + integerToString(second);
    }

    public boolean isSecondPassed() {
        return secondPassed;
    }

    public void setSecondPassed(boolean secondPassed) {
        this.secondPassed = secondPassed;
    }

}