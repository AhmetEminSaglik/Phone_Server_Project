package phone.key.ability;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import phone.Phone;
import phone.key.PhoneKey;
import phone.key.ability.function.Function;
import phone.key.ability.listview.ListViewEvent;
//import phone.screen.addPhoneNumber.mylist.TextFieldList;
import phone.screen.basescreen.BaseScreen;
import phone.screen.enterphonenumberscreen.EnterPhoneNumberScreen;
import phone.screen.registerednumbers.contact.Contact;
import phone.screen.registerednumbers.contact.Person;
import phone.screen.textingscreen.MessageScreenController;
import phone.utility.TextInputControlList;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class NumberKeyEvent {
    Phone phone;
    private ListViewEvent listViewEvent;

    public NumberKeyEvent(Phone phone) {
        this.phone = phone;
    }

    public NumberKeyEvent(Phone phone, ListView listView) {
        this.phone = phone;
        listViewEvent = new ListViewEvent(phone, listView);
    }

    public void setEventToOpenEnterPhoneNumberScreen(List<PhoneKey> keyList) {
        for (PhoneKey item : keyList) {
            setEventToOpenEnterPhoneNumberScreen(item);
        }
    }

    public void clearEvent(List<PhoneKey> keyList) {
        for (PhoneKey item : keyList) {
            item.setOnAction(actionEvent -> {
            });
        }
    }

    public void setEventToOpenEnterPhoneNumberScreen(PhoneKey phoneKey) {
        phoneKey.setOnAction(new KeyAbility(phone).changeScreen(new EnterPhoneNumberScreen(phone),null));
    }


    public void addEventToKey(PhoneKey phoneKey, EventHandler<ActionEvent> event) {
        phoneKey.setOnAction(event);
    }

//    public void setEventToGoMainMenuScreen(PhoneKey phoneKey) {//, BaseScreen baseScreen
//        //phoneKey.getController().setAction(new KeyAbility(phone).changeScreen(baseScreen));
//        phoneKey.setOnAction(new KeyAbility(phone).changeScreenToMainMenu(new MainMenuScreen(phone)));
//
//    }

    /**
     * this func. is used to change to new screen
     */
    public void setEventToSwitchScreen(PhoneKey phoneKey, BaseScreen baseScreen,BaseScreen oldBaseScreenNewInitialize) {


        phoneKey.setOnAction(new KeyAbility(phone).changeScreen(baseScreen,oldBaseScreenNewInitialize));
    }

    public void setEventToPrintInTextInputControl(List<PhoneKey> phoneKeyList, TextInputControl textInputControl) {
        for (PhoneKey item : phoneKeyList) {
            setEventToPrintStringInTextInputControl(item, textInputControl);
        }
    }
    public void setEventToPrintIntegerInTextInputControl(List<PhoneKey> keyList, TextInputControl textInputControl) {
        for (PhoneKey item : keyList) {
            item.setOnAction(
                    new KeyAbility(phone).printIntegerValueToTextInputControl(textInputControl, item)
            );
        }
    }

    public void setEventToPrintStringInTextInputControl(PhoneKey phoneKey, TextInputControl textInputControl) {
        phoneKey.setOnAction(new KeyAbility(phone).printStringValueToTextInputControl(textInputControl, phoneKey));
    }

    public void setEventToCallNumberByContact(PhoneKey phoneKey, Contact contact) {
//        setEventToCallNumberByPhoneNumber(phoneKey, contact.getPhoneNumber());
//        System.out.println("CallNumberByContact : " + phoneKey.getId());
        phoneKey.setOnAction(new KeyAbility(phone).callPhoneNumber(contact));

    }

    public void setEventToCallNumberByPhoneNumber(PhoneKey phoneKey, String phoneNumber) {
        Contact contact = new Function(phone).getRegisteredContactInPhoneByPhoneNumber(phoneNumber);
        setEventToCallNumberByContact(phoneKey, contact);
//        phoneKey.setOnAction(new KeyAbility(phone).callPhoneNumber(phoneNumber));
    }


    public void setEventToChangeScreenToMainMenuScreen(PhoneKey phoneKey) {
        phoneKey.setOnAction(new KeyAbility(phone).changeScreenToMainMenu());
        //        phoneKey.setOnAction(e -> {
//            new KeyAbility(phone).changeScreenToMainMenu();
////            phone.getScreenStack().clearScreenStack();
//
//        });
    }

    public void setEventToGoBackScreen(PhoneKey phoneKey) {
        phoneKey.setOnAction(new KeyAbility(phone).changeScreenToLastScreen());
    }

    public void setEventToSelectNextOnList(PhoneKey phoneKey, TextInputControlList list) {
        phoneKey.setOnAction((e) -> {
            list.selectNextIndex();
            updateAllChanges();
        });
    }

    /**
     * updateAllChanges is added in action because after move in list then we need to update Phone.
     */
    public void setEventToSelectPreviousOnList(PhoneKey phoneKey, TextInputControlList list) {
        phoneKey.setOnAction((e) -> {
            list.selectPreviousIndex();
            updateAllChanges();

        });
    }

    public void setEventToScrollDownTextArea(PhoneKey phoneKey, TextArea textArea) {
        phoneKey.setOnAction(new KeyAbility(phone).scrollDownTextArea(textArea));

    }    public void setEventToScrollUpTextArea(PhoneKey phoneKey, TextArea textArea) {
        phoneKey.setOnAction(new KeyAbility(phone).scrollUpTextArea(textArea));

    }
//
//    public void setEventToHangUpCall(PhoneKey phoneKey) {
//        phoneKey.setOnAction(new KeyAbility(phone).hangUpCall());
//
//    }
//
//    public void setEventToPickUpCall(PhoneKey phoneKey) {
//        phoneKey.setOnAction(new KeyAbility(phone).pickUpCall());
//
//    }

    public void setEventToSaveContact(PhoneKey phoneKey, TextInputControlList textInputControlList) { //TextFieldList list
        phoneKey.setOnAction((e) -> {
            updateAllChanges();

            Contact contact = new Contact(new Person(textInputControlList.get(0).getText(), textInputControlList.get(1).getText()), textInputControlList.get(2).getText());
            if (isNumberCanBeAdd(phone, contact)) {
                phone.getRegisteredContact().add(contact);

//                phone.getRegisteredContactList().add(new ContactCard(contact,
//                        new ContactPersonScreen(phone, contact)));
                if (isTextEmpty(contact.getPerson().getName()) && isTextEmpty(contact.getPerson().getSurname())) {
                    contact.setPerson(new Person(Person.unKnownPerson, null));
                }
                phone.getCallHistory().updateHistory();
                for (int i = 0; i < textInputControlList.size(); i++) {
                    textInputControlList.get(i).setText("");
                }


            }
        });
    }

//    public void setEventToHangUpCall(PhoneKey phoneKey) {
//        phoneKey.setOnAction(new KeyAbility(phone).hangUpCall());
//
//    }

    boolean isNumberCanBeAdd(Phone phone, Contact contact) {
        return (!isNumberRegistered(phone, contact) && !isTextEmpty(contact.getPhoneNumber()));
    }

    boolean isNumberRegistered(Phone phone, Contact contact) {
        return phone.getRegisteredContact().isExist(contact);
    }

    boolean isTextEmpty(String text) {
        if (text.trim().length() > 0)
            return false;
        return true;

    }

    public void setEventToDeleteLastLetter(PhoneKey phoneKey, TextInputControl TextInputControl) {

        phoneKey.setOnAction((e) -> {
            new Function(phone).deleteLastLetter(TextInputControl);
            updateAllChanges();
        });

    }

    boolean isNull(Object object) {
        if (object == null)
            return true;
        return false;

    }

    public void setEventToSendMessage(PhoneKey phonKey, MessageScreenController messageScreenController) {

        phonKey.setOnAction(new KeyAbility(phone).sendMessage(messageScreenController));
//            messageScreenController.getLastUpdationBeforeSendingMessage();
//            System.out.println("AAZAZAZZAKZAXAXKZKXAZAXZAZXXAZXAZXAZXAZXAZAZX 11111111111111111111" );

//            System.out.println("AAZAZAZZAKZAXAXKZKXAZAXZAZXXAZXAZXAZXAZXAZAZX 22222222222");

//            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA 1 ");
//            messageScreenController.getLastUpdationBeforeSendingMessage();

//            for(Contact item : contactList){}
//            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA 2 ");

//        phonKey.setOnAction(e -> {
////            for (int i = 0; i < contactList.size(); i++) {
////                setEventToSendMessage(contactList.get(i), phone.message);
////            }
//            new KeyAbility(phone).sendMessage(contactList, message);
////            phoneKey.setOnAction(new KeyAbility(phone).callPhoneNumber(contact));
//        });

    }


//    public void setEventToSendMessage(PhoneKey phonKey, Contact contact, String message) {
//
//////        phoneKey.setOnAction(new KeyAbility(phone).callPhoneNumber(contact));
////        List<Contact> contactList = new ArrayList<>();
////        contactList.add(contact);
////        setEventToSendMessage(phonKey, contactList, message);
//
//    }


    /**
     * this function is essential to update after moving on list on the screen
     */
    void updateAllChanges() {
//        System.out.println(getClass().getName() + "  --->> updateAllPhone");
        ((BaseScreen) (phone.getPhoneController().getScreenAnchorPane().getChildren().get(0))).getController().updateAllPhone();
    }

    public ListViewEvent getListViewEvent() {
        return listViewEvent;
    }

    public void setListViewEvent(ListViewEvent listViewEvent) {
        this.listViewEvent = listViewEvent;
    }
}
