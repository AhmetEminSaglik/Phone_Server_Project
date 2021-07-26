package phone;

import phone.screen.registerednumbers.contact.Contact;

import java.util.ArrayList;
import java.util.List;

public class RegisteredContact {// extends RegisteredList<Contact>
    Phone phone;
    List list = new ArrayList<Contact>();

    public RegisteredContact(Phone phone) {
        this.phone = phone;
    }

    public void add(Contact contact) {
        list.add(contact);
    }

    public boolean isExist(Contact contact) {
        for (Object item : list) {
            if (((Contact) item).getPhoneNumber().equals(contact.getPhoneNumber())) {
                return true;
            }
        }
        return false;
    }

    public List getList() {
        return list;
    }

    public Contact getContactByPhoneNumber(String phoneNumber) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("TANIMLI NUMARALAR " +list.get(i));
            if (((Contact) list.get(i)).getPhoneNumber().equals(phoneNumber)) {
                System.out.println("TANIMLI NUMARALAR >>>>>>>>>>>>>>" +list.get(i));
                System.out.println(" RETURN ::: " + ((Contact) list.get(i)));
//                System.out.println("Coming nuber : " + phoneNumber);
//                System.out.println("bulunan contact : " + ((Contact) list.get(i)));
                return ((Contact) list.get(i));
            }

        }
        return null;
    }

    public void setList(List list) {
        this.list = list;
    }
}
