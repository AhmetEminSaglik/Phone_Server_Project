package server;

import phone.Phone;
import server.registeredphonecard.RegisteredPhoneCard;

import java.util.ArrayList;
import java.util.List;

public class RegisteredPhoneInServer {

    List<RegisteredPhoneCard> list = new ArrayList<RegisteredPhoneCard>();

    public void add(RegisteredPhoneCard registeredPhoneCard) {
        list.add(registeredPhoneCard);

    }

    public int size() {
        return list.size();
    }

    public boolean isPhoneNumberExist(String phoneNo) {
        for (RegisteredPhoneCard item : list) {
            if (item.getPhone().getNumber().equals(phoneNo))
                return true;
        }
        return false;
    }

    public Phone searchNumberAndGetPhone(String number) {
        for (RegisteredPhoneCard item : list) {
            if (item.getPhone().getNumber().equals(number)) return item.getPhone();
        }
        return null;
    }

    public Phone get(int index) {
        return list.get(index).getPhone();
    }

}
