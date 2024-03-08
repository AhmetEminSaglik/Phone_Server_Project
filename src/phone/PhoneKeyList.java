package phone;

import phone.key.PhoneKey;

import java.util.ArrayList;
import java.util.List;

public class PhoneKeyList {
    List operatorKeyList = new ArrayList<PhoneKey>();
    List numberKeyList = new ArrayList<PhoneKey>();

    public List getOperatorKeyList() {
        return operatorKeyList;
    }

    public List getNumberKeyList() {
        return numberKeyList;
    }

}
