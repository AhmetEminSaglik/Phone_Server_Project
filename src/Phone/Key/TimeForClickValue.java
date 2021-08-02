package phone.key;

import javafx.scene.control.Button;
import phone.Phone;
import phone.key.ability.function.Function;

import java.util.Timer;
import java.util.TimerTask;

public class TimeForClickValue {

    private int interval;
    Timer timer;
    final int waitingSecond =2;
    int clickValue = 0;
    final int delay = 1000;
    final int period = 1000;
    Button PhoneKeyButton;
    Phone phone;
    boolean canBeAddNewCharacter = true;

    public TimeForClickValue(Phone phone) {
        this.phone = phone;
    }

    public void startCountDownForClickedNumberPhonKey(Button PhoneKeyButton) {
        if (isSameButtonClicked(PhoneKeyButton) && interval > 0) {
            resetInterval();
//            new Function(phone).deleteLastLetter();
            canBeAddNewCharacter = false;

        } else {
            resetClickValue();
            changeButton(PhoneKeyButton);
            startTheCountdown(PhoneKeyButton);
            canBeAddNewCharacter = true;
        }


    }

    public void startTheCountdown(Button PhoneKeyButton) {
        resetInterval();
        try {
            timer.scheduleAtFixedRate(new TimerTask() {

                public void run() {
                    System.out.println(setInterval());
                    System.out.println("Interval : " + interval);
                }
            }, delay, period);
        } catch (NullPointerException ex) {
            createTimer();
            startTheCountdown(PhoneKeyButton);
        } catch (IllegalStateException ex) {
            createTimer();
            startTheCountdown(PhoneKeyButton);
        }
    }

    boolean isSameButtonClicked(Button PhoneKeyButton) {
        if (this.PhoneKeyButton == PhoneKeyButton)
            return true;
        return false;

    }

    void changeButton(Button PhoneKeyButton) {
        this.PhoneKeyButton = PhoneKeyButton;
    }

    private final int setInterval() {
        if (interval == 1) {
            resetClickValue();
            timer.cancel();

        }
        return --interval;
    }


    void resetInterval() {
        interval = Integer.parseInt(Integer.toString(waitingSecond));
    }

    public void resetClickValue() {
        clickValue = 0;
    }

    public void increaseClickValue() {
        clickValue++;
    }

    void createTimer() {
        timer = new Timer();
    }

    public int getInterval() {
        return interval;
    }

    public boolean isCanBeAddNewCharacter() {
        return canBeAddNewCharacter;
    }
}
