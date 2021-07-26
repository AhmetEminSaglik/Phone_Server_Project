package phone.key;

import phone.Phone;
import javafx.scene.layout.HBox;

public class PhoneKeyWanted {

    Phone phone;

    public PhoneKeyWanted(Phone phone) {
        this.phone = phone;
    }

    //    public List<PhoneKey> getPhoneKeyList(){
//
//        for (int i = 1; i < phone.getPhoneController().getPhoneVBoxLayer().getChildren().size(); i++) {
//            HBox floor = (HBox) phone.getPhoneController().getPhoneVBoxLayer().getChildren().get(i);
//            for (int j = 0; j < floor.getChildren().size(); j++) {
//
//
//            }
//
//        }
//    }
    public PhoneKey getPhoneKey(int row, int column) {

        return (PhoneKey) ((HBox) phone.getPhoneController().getPhoneVBoxLayer().getChildren().get(row + 1)).getChildren().get(column);
    }

}

