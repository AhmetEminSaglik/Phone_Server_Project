package phone.screen.registerednumbers;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import phone.Phone;
import phone.screen.callhistoryscreen.CallHistoryScreen;
import phone.screen.contactpersonscreen.ContactPersonScreen;
import phone.screen.listviewscreen.ListViewScreenController;
import phone.screen.listviewscreen.listViewCard.Card;
import phone.screen.listviewscreen.listViewCard.ContactCard;
import phone.screen.registerednumbers.contact.Contact;
import phone.screen.registerednumbers.contact.Person;


public class RegisteredPhoneNumberScreenController extends ListViewScreenController {
    RegisteredPhoneNumberScreen registeredPhoneNumberScreen;
    @FXML
    protected ListView<ContactCard> menuListView;

    public RegisteredPhoneNumberScreenController(Phone phone) {
        super(phone);
    }
    @Override
    public void setSwitchScreenParamaters() {
        numberKeyEvent.setEventToSwitchScreen(getWantedPhoneKey(phone, 0, 0),
                menuListView.getSelectionModel().getSelectedItem().getPhoneScreen(),new RegisteredPhoneNumberScreen(phone));
    }
    @Override
    public void updateScreen() {
        preparePhoneScreenList();

        getMenuListView().setMouseTransparent(true);
        getMenuListView().getFocusModel().focus(0);
        getMenuListView().getSelectionModel().selectFirst();
    }
//
//    @Override
//    public void addActionToOperatorKeys() {
//        super.addActionToOperatorKeys();
//        numberKeyEvent.setEventToChangeScreen(getWantedPhoneKey(phone, 0, 0), menuListView.getSelectionModel().getSelectedItem().getPhoneScreen());
//    }

    @Override
    public void preparePhoneScreenList() {
        addContactsToScreenList();

    }

    void addContactsToScreenList() {
        if (phone.getRegisteredContact().getList().size() > 0) {
            for (int i = 0; i < phone.getRegisteredContact().getList().size(); i++) {
                Contact contact = (Contact) phone.getRegisteredContact().getList().get(i);
                ContactCard contactCard = new ContactCard(contact, new ContactPersonScreen(phone, contact));
                addItemtoMenuList((Card) contactCard);
            }
        } else {
            addItemtoMenuList(new ContactCard(new Contact(new Person("Has not been registered any number", null), null), registeredPhoneNumberScreen));
        }
//        phone.getRegisteredContact().getList().forEach((item) -> {
//           ContactCard contactCard = new ContactCard(item,new ContactPersonScreen(item,phone));
////            addItemtoMenuList(new ContactCard(item, new ContactPersonScreen(phone,(Contact)item)));
//
//        });
//        phone.getRegisteredContact().getList().forEach((e) -> {
//            addItemtoMenuList((Card) e);
//
//        });
    }

    @Override
    public void addActionToOperatorKeys() {

        super.addActionToOperatorKeys();
//        numberKeyEvent.setEventToCallNumberByContact(getWantedPhoneKey(phone, 0, 0), ((ContactCard) getMenuListView().getSelectionModel().getSelectedItem()).getContact());


        numberKeyEvent.setEventToCallNumberByContact(getWantedPhoneKey(phone, 1, 0), ((ContactCard) getMenuListView().getSelectionModel().getSelectedItem()).getContact());

    }

    public RegisteredPhoneNumberScreen getRegisteredPhoneNumberScreen() {
        return registeredPhoneNumberScreen;
    }

    public void setRegisteredPhoneNumberScreen(RegisteredPhoneNumberScreen registeredPhoneNumberScreen) {
        this.registeredPhoneNumberScreen = registeredPhoneNumberScreen;
    }
}

//    public List getPhoneNoList() {
//        return phoneNoList;
//    }
//
//    public void setPhoneNoList(List phoneNoList) {
//        this.phoneNoList = phoneNoList;
//    }

//    void addNewContact() {
//
////
////        phoneNoList.add(new ContactCard(new Contact(new Person("Ahmet Emin ", "SAGLIK"), "0510 123 24 0"),
////                new ContactPersonScreen(phone)));
////        phoneNoList.add(new ContactCard(new Contact(new Person("Alperen ", "TEKKEISNOGLU"), "0510 123 24 0"),
////                new ContactPersonScreen(phone)));
////        phoneNoList.add(new ContactCard(new Contact(new Person("Abdullah Ahmet", "ASKIN"), "0510 123 24 0"),
////                new ContactPersonScreen(phone)));
////        phoneNoList.add(new ContactCard(new Contact(new Person("Omer Sevval", "KORAMAZ"), "0510 123 24 0"),
////                new ContactPersonScreen(phone)));
////        phoneNoList.add(new ContactCard(new Contact(new Person("Eren", "CAN"), "0510 123 24 0"),
////                new ContactPersonScreen(phone)));
////        phoneNoList.add(new ContactCard(new Contact(new Person("Omer ", "AKKOCA"), "0510 123 24 0"),
////                new ContactPersonScreen(phone)));
//
//    }


//    void addContactsToScreenList() {
//        phoneNoList.forEach((e) -> {
//            addItemtoMenuList((Card) e);
//        });
//    }
