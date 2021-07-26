package phone.screen.contactpersonscreen;

import phone.Phone;
import phone.screen.callhistoryscreen.CallHistoryScreen;
import phone.screen.callingscreen.callingsomeone.CallingScreen;
import phone.screen.listviewscreen.ListViewScreenController;
import phone.screen.listviewscreen.listViewCard.OptionScreenCard;
import phone.screen.registerednumbers.contact.Contact;
import phone.screen.textingscreen.MessageScreen;

public class ContactPersonScreenController extends ListViewScreenController {
    Contact contact;

    public ContactPersonScreenController(Phone phone, Contact contact) {
        super(phone);
        this.contact = contact;

    }

    @Override
    public void setSwitchScreenParamaters() {
        numberKeyEvent.setEventToSwitchScreen(getWantedPhoneKey(phone, 0, 0),
                menuListView.getSelectionModel().getSelectedItem().getPhoneScreen(),new ContactPersonScreen(phone,contact));
    }
    @Override
    public void updateScreen() {
        preparePhoneScreenList();

        getMenuListView().setMouseTransparent(true);
        getMenuListView().getFocusModel().focus(0);
        getMenuListView().getSelectionModel().selectFirst();
    }


    @Override
    public void preparePhoneScreenList() {
        addItemtoMenuList(new OptionScreenCard("Call", new CallingScreen(phone, contact)));
        addItemtoMenuList(new OptionScreenCard("Text", new MessageScreen(phone, contact)));

    }

    @Override
    public void addActionToOperatorKeys() {
        super.addActionToOperatorKeys();
//        numberKeyEvent.setEventToSwitchScreen(getWantedPhoneKey(phone,0,0),getMenuListView().getSelectionModel().getSelectedItem().getPhoneScreen());
        updateSelectKeyByListViewMove();
        numberKeyEvent.setEventToCallNumberByContact(getWantedPhoneKey(phone, 1, 0), contact);

    }

//    @Override
//    public void updateKeysEvent() {
//        super.updateKeysEvent();
//        updateListViewMoving();
//    }

    /**
     * this func. is added because  just in this screen there are two different action just depends on the selection item from list,
     */
    void updateSelectKeyByListViewMove() {
        if (getMenuListView().getSelectionModel().getSelectedItem().getPhoneScreen().getClass().getSimpleName().equals(new CallingScreen(phone, contact).getClass().getSimpleName())) {
            numberKeyEvent.setEventToCallNumberByContact(getWantedPhoneKey(phone, 0, 0), contact);
        } else {
            numberKeyEvent.setEventToSwitchScreen(getWantedPhoneKey(phone, 0, 0), getMenuListView().getSelectionModel().getSelectedItem().getPhoneScreen()
                    , new ContactPersonScreen(phone, contact));
        }

//        phoneKey = getWantedPhoneKey(phone, 0, 0);
//        phoneKey.setOnAction(e -> {
//            if (getMenuListView().getSelectionModel().getSelectedItem().getPhoneScreen().getClass().getSimpleName().equals(new CallingScreen(phone, contact).getClass().getSimpleName())) {
//                new Function(phone).callPhoneNumber(contact);
//                System.out.println("AAAAAAAAAAAAAAAA");
//            } else {
//                numberKeyEvent.setEventToSwitchScreen(phoneKey, menuListView.getSelectionModel().getSelectedItem().getPhoneScreen());
//                new Function(phone).changeScreen(getMenuListView().getSelectionModel().getSelectedItem().getPhoneScreen());
//                System.out.println("AAAAAAAAAAAAAAAA");
//            }
//
//
//        });


    }
}
