package phone.key.ability;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputControl;
import phone.Phone;
import phone.key.PhoneKey;
import phone.key.ability.function.Function;
import phone.screen.basescreen.BaseScreen;
import phone.screen.basescreen.BaseScreenController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import phone.screen.mainmenu.MainMenuScreen;
import phone.screen.registerednumbers.contact.Contact;
import phone.screen.textingscreen.MessageScreenController;

import java.util.List;

public class KeyAbility<T> {
    Phone phone;
    T list;
    BaseScreenController baseScreenController;

    public KeyAbility(Phone phone, T list) { //, BaseScreenController baseScreenController
        this.phone = phone;
        this.list = list;
    }

    public KeyAbility(Phone phone) {
        this.phone = phone;

    }

    public EventHandler<ActionEvent> scrollUpTextArea(TextArea textArea) {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                new Function(phone).scrollUpTextArea(textArea);

            }
        };
    }

    public EventHandler<ActionEvent> scrollDownTextArea(TextArea textArea) {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                new Function(phone).scrollDownTextArea(textArea);
            }
        };
    }


    public EventHandler<ActionEvent> changeScreen(BaseScreen newScreen,BaseScreen oldBaseScreenNewInitialize) { //Phone phone, ListView listView updateScreenAccordingToSelectedListViewItemScreen
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (newScreen != null)
                    new Function(phone).changeScreen(newScreen,oldBaseScreenNewInitialize);
                else {

                    System.out.println("EventHandler<ActionEvent>  changeScreen ELSE TIKLANDII screen : NULLLL  ");
                }
            }


        };
    }

    public EventHandler<ActionEvent> changeScreenToLastScreen() { //Phone phone, ListView listView updateScreenAccordingToSelectedListViewItemScreen
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                new Function(phone).changeScreenToLastScreen();
            }
        };
    }

    public EventHandler<ActionEvent> changeScreenToMainMenu() { //Phone phone, ListView listView updateScreenAccordingToSelectedListViewItemScreen
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//                new Function(phone).changeScreenToMainMenu(new MainMenuScreen(phone));
//                new Function(phone).changeScreen(new MainMenuScreen(phone));s
                new Function(phone).changeScreenToMainScreen();
//                phone.getScreenStack().clearScreenStack();
            }
        };
    }

//    public EventHandler<ActionEvent> updateScreenController(BaseScreenController baseScreenController) {
//        return new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                new Function(phone).updateScreenController(baseScreenController);
//            }
//        };
//    }

    public EventHandler<ActionEvent> printStringValueToTextInputControl(TextInputControl textInputControl, PhoneKey button) {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                new Function(phone).printStringValueToTextInputControl(textInputControl, button);
            }
        };
    } public EventHandler<ActionEvent> printIntegerValueToTextInputControl(TextInputControl textInputControl, PhoneKey button) {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                new Function(phone).printIntegerValueToTextInputControl(textInputControl, button);
            }
        };
    }

    public EventHandler<ActionEvent> callPhoneNumber(Contact contact) { //Phone phone, ListView listView updateScreenAccordingToSelectedListViewItemScreen
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                new Function(phone).callPhoneNumber(contact);
            }
        };
    }

    public EventHandler<ActionEvent> sendMessage(MessageScreenController messageScreenController) { //List<Contact> contactList, String message//Phone phone, ListView listView updateScreenAccordingToSelectedListViewItemScreen
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                messageScreenController.getLastUpdationBeforeSendingMessage();

                new Function(phone).sendMessageToEveryOneInContactlist(messageScreenController.getContactListToSendMessage(), messageScreenController.getMessage());
//                for (int i = 0; i < contactList.size(); i++) {
//                    new Function(phone).sendMessage(contactList.get(i), message);
//                }
            }
        };
    }

//    public EventHandler<ActionEvent> hangUpCall() { //Phone phone, ListView listView updateScreenAccordingToSelectedListViewItemScreen
//        return new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                BaseCallScreen baseCallScreen = (BaseCallScreen) phone.getPhoneController().getScreenAnchorPane().getChildren().get(0);
//
//            }
//        };
//    }

//    public EventHandler<ActionEvent> pickUpCall() { //Phone phone, ListView listView updateScreenAccordingToSelectedListViewItemScreen
//        return new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                BaseCallScreen baseCallScreen = (BaseCallScreen) phone.getPhoneController().getScreenAnchorPane().getChildren().get(0);
//
//            }
//        };
//    }

}
