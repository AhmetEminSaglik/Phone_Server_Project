package phone.key;

import phone.Phone;
import javafx.scene.layout.HBox;

public class PhoneKeyWanted {

    Phone phone;

    public PhoneKeyWanted(Phone phone) {
        this.phone = phone;
    }

    public PhoneKey getPhoneKey(int row, int column) {
        return (PhoneKey) ((HBox) phone.getPhoneController().getPhoneVBoxLayer().getChildren().get(row + 1)).getChildren().get(column);
    }

}

