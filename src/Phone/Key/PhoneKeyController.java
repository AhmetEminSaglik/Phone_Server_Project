package phone.key;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import mynote.MyNote;

import java.net.URL;
import java.util.ResourceBundle;

public class PhoneKeyController implements Initializable { //, INumberArea, IValues, IClickValue
    String btnText;
    TimeForClickValue timeForClickValue;
    StringValue stringValue;


    @FXML
    private Button PhoneKeyButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PhoneKeyButton.setText(btnText);
        stringValue = new StringValue(btnText);
    }

    public String getIntegerValue(){
        IntegerFromString integerFromString = new IntegerFromString(PhoneKeyButton.getText());
        return integerFromString.getIntegerInStringVariable();

    }

    public String getStringValue() {
        timeForClickValue.startCountDownForClickedNumberPhonKey(PhoneKeyButton);
        String value = stringValue.getCharacterInStringFormat(timeForClickValue.clickValue);
        timeForClickValue.increaseClickValue();
        refactorClickValueByTextLength();
        return value;
    }

    void refactorClickValueByTextLength() {
        if (timeForClickValue.clickValue == btnText.length())
            timeForClickValue.resetClickValue();
    }


    public String getBtnText() {
        return PhoneKeyButton.getText().trim();
    }

    public void setBtnText(String btnText) {
        this.btnText = btnText;
    }


    public void setAction(EventHandler<ActionEvent> action) {
        PhoneKeyButton.setOnAction(action);
    }

    public void setTimeForClickValue(TimeForClickValue timeForClickValue) {
        this.timeForClickValue = timeForClickValue;
    }

    public boolean isCanBeAddNewCharacter() {
        return timeForClickValue.isCanBeAddNewCharacter();
    }
}
