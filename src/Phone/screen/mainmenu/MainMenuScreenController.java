package phone.screen.mainmenu;

import phone.Phone;
import phone.screen.callhistoryscreen.CallHistoryScreen;
import phone.screen.contactscreen.ContactScreen;
import phone.screen.listviewscreen.ListViewScreenController;
import phone.screen.listviewscreen.listViewCard.OptionScreenCard;
import phone.screen.messagehistoryscreen.MessageHistoryScreen;


public class MainMenuScreenController extends ListViewScreenController {

    public MainMenuScreenController(Phone phone) {
        super(phone);
    }

//    @Override
//    public void updateScreen() {
//        preparePhoneScreenList();
//
//        getMenuListView().setMouseTransparent(true);
//        getMenuListView().getFocusModel().focus(0);
//        getMenuListView().getSelectionModel().selectFirst();
//    }
@Override
public void setSwitchScreenParamaters() {
    numberKeyEvent.setEventToSwitchScreen(getWantedPhoneKey(phone, 0, 0),
            menuListView.getSelectionModel().getSelectedItem().getPhoneScreen(),new MainMenuScreen(phone));
}
    @Override
    public void preparePhoneScreenList() {
//        addItemtoMenuList(new OptionScreenCard("Kayitli Numaralar", new RegisteredPhoneNumberScreen(phone)));
//        addItemtoMenuList(new OptionScreenCard("Numara Ekle", new AddPhoneNumberScreen(phone)));

        getLblBack().setVisible(false);
        addItemtoMenuList(new OptionScreenCard("Contact", new ContactScreen(phone)));
        addItemtoMenuList(new OptionScreenCard("Call", new CallHistoryScreen(phone)));
        addItemtoMenuList(new OptionScreenCard("Message", new MessageHistoryScreen(phone)));
        //        addItemtoMenuList(new OptionScreenCard("Coming call 100", new ComingCallScreen(phone,new Contact(null,"100"))));
//        addItemtoMenuList(new OptionScreenCard("Coming call 111", new ComingCallScreen(phone,new Contact(null,"111"))));


//        getMenuListView().getItems().add(new OptionScreenCard("Kayitli Numaralar", new RegisteredPhoneNumberScreen(phone)));
//        getMenuListView().getItems().add(new OptionScreenCard("Numara Ekle", new AddPhoneNumberScreen(phone)));


    }

}
