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
                menuListView.getSelectionModel().getSelectedItem().getPhoneScreen(), new RegisteredPhoneNumberScreen(phone));
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
    }

    @Override
    public void addActionToOperatorKeys() {
        super.addActionToOperatorKeys();
        numberKeyEvent.setEventToCallNumberByContact(getWantedPhoneKey(phone, 1, 0), ((ContactCard) getMenuListView().getSelectionModel().getSelectedItem()).getContact());
    }

    public RegisteredPhoneNumberScreen getRegisteredPhoneNumberScreen() {
        return registeredPhoneNumberScreen;
    }

    public void setRegisteredPhoneNumberScreen(RegisteredPhoneNumberScreen registeredPhoneNumberScreen) {
        this.registeredPhoneNumberScreen = registeredPhoneNumberScreen;
    }
}

