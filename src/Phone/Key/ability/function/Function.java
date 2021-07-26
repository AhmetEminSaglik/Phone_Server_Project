package phone.key.ability.function;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.AnchorPane;
import phone.Phone;
import phone.key.IntegerFromString;
import phone.key.PhoneKey;
import phone.key.TimeForClickValue;
import phone.screen.basescreen.BaseScreen;
import phone.screen.basescreen.BaseScreenController;
import phone.screen.callingscreen.callingsomeone.CallingScreen;
import phone.screen.mainmenu.MainMenuScreen;
import phone.screen.registerednumbers.contact.Contact;
import phone.screen.textingscreen.MessageScreenController;
import phone.utility.IdentifyNumber;

import java.util.List;

public class Function<T> {
    Phone phone;
    T list;
    BaseScreenController baseScreenController;
    TimeForClickValue timeForClickValue;

    public Function(Phone phone, T list) { //, BaseScreenController baseScreenController
        this(phone);
        this.list = list;

    }

    public Function(Phone phone) {
        this.phone = phone;
        timeForClickValue = phone.getPhoneController().getTimeForClickValue();
    }

//    public void changeScreenToMainMenu(BaseScreen basePhoneScreen) {
//
//        AnchorPane phoneScreenAnchorPane = phone.getPhoneController().getScreenAnchorPane();
//        System.out.println("changeScreenToMainMenu ?????????? "+phoneScreenAnchorPane);
//
//        deleteScreenItem(phoneScreenAnchorPane);
//        updateAllPhone(basePhoneScreen);
//        addScreenItem(phoneScreenAnchorPane, basePhoneScreen);
//
//        phone.getScreenStack().clearScreenStack();
//
//    }

    public void changeScreenToMainScreen() {
        changeScreen(new MainMenuScreen(phone), null);
        phone.getScreenStack().clearScreenStack();
        System.out.println("Geri geldi ve liste silinecek");
    }

    public void changeScreen(BaseScreen newScreen, BaseScreen oldScreenNewInitialize) {
        AnchorPane phoneScreenAnchorPane = phone.getPhoneController().getScreenAnchorPane();
//        BaseScreen phoneScreen = ((BaseScreen) phone.getPhoneController().getScreenAnchorPane().getChildren().get(0));
        BaseScreen phoneScreen = phone.getPhoneController().getScreen();
        if (oldScreenNewInitialize != null) {
            addScreenToStack(oldScreenNewInitialize, newScreen);
        } else {
            addScreenToStack(phoneScreen, newScreen);
            System.out.println("Sistem burada kitleniyor. Cunku LastLocation icin BaseScreen Yenilenemiyor. Geri Adim Atildiginda eski basescreen gosterilecek");
        }
        deleteScreenItem(phoneScreenAnchorPane);
        addScreenItem(phoneScreenAnchorPane, newScreen);
        updateAllChanges();
//        updateAllPhone(newScreen);
    }

    void addScreenToStack(BaseScreen phoneScreen, BaseScreen newScreen) {

        System.out.println("Phone screen : " + phoneScreen.toString());
        System.out.println("newScreen : " + newScreen.toString());
        if (!phoneScreen.getClass().getSimpleName().equals(newScreen.getClass().getSimpleName()))
            phone.getScreenStack().addCurrentScreenToStack(phoneScreen);

    }


    void deleteScreenItem(AnchorPane screen) {
        screen.getChildren().remove(0);
    }

    void addScreenItem(AnchorPane screenPlace, BaseScreen newScreen) {
        screenPlace.getChildren().add(newScreen);
    }

    public void changeScreenToLastScreen() {
        if (!phone.getScreenStack().isScreenStackEmpty()) {
            AnchorPane oldScreen = phone.getPhoneController().getScreenAnchorPane();
            deleteScreenItem(oldScreen);
            BaseScreen newScreen = phone.getScreenStack().popLastScreenFromScreenStack();
            addScreenItem(oldScreen, newScreen);
//            updateAllPhone(newScreen);
            updateAllChanges();
        } else {
            System.out.println("Stack is empty : " + phone.getScreenStack().size());
        }

        /*if (!phone.getScreenStack().isScreenStackEmpty()) {
            AnchorPane oldScreen = phone.getPhoneController().getScreenAnchorPane();
            deleteScreenItem(oldScreen);
            BaseScreen newScreen = phone.getScreenStack().popLastScreenFromScreenStack();
            String screenName=newScreen.getClass().getSimpleName();
            try {
                 Class<BaseScreen> clazz= (Class<BaseScreen>) BaseScreen.class.forName(screenName);
//                addScreenItem(oldScreen, clazz.cast(newScreen));
                addScreenItem(oldScreen, clazz.newInstance());
                updateAllPhone(newScreen);
            } catch (ClassNotFoundException e) {

                System.out.println("HATA 1 ____________________________________________________________________________ HATA"+e.getMessage());
            } catch (InstantiationException e) {
                System.out.println("HATA 2 ____________________________________________________________________________ HATA"+e.getMessage());
            } catch (IllegalAccessException e) {
                System.out.println("HATA  3____________________________________________________________________________ HATA"+e.getMessage());
            }
        } else {
            System.out.println("Stack is empty : " + phone.getScreenStack().size());

        }*/

    }

    /**
     * When
     */
    public void activateKeyByLastScreenController(Phone phone) {
        BaseScreen lastScreen = phone.getScreenStack().peekLastScreenFromScreenStack();
        lastScreen.getController().updateAllPhone();


    }
//
//    public void activateBasicOperatorKeys(Phone phone, String phoneNumber) {
//        BaseScreen oldScreen = (BaseScreen) phone.getPhoneController().getScreenAnchorPane().getChildren().get(0);
////        oldScreen.getController().
//        NumberKeyEvent numberKeyEvent = new NumberKeyEvent(phone);
//        numberKeyEvent.setEventToGoBackScreen(new PhoneKeyWanted(phone).getPhoneKey(0, 2));
//        numberKeyEvent.setEventToCallNumberByPhoneNumber(new PhoneKeyWanted(phone).getPhoneKey(1, 0), phoneNumber);
//        numberKeyEvent.setEventToChangeScreenToMainMenuScreen(new PhoneKeyWanted(phone).getPhoneKey(1, 2));
//
//    }

    public void callPhoneNumber(Contact contact) {
        BaseScreen basePhoneScreen = new CallingScreen(phone, contact);
        AnchorPane phoneScreenAnchorPane = phone.getPhoneController().getScreenAnchorPane();
        deleteScreenItem(phoneScreenAnchorPane);
        addScreenItem(phoneScreenAnchorPane, basePhoneScreen);
//        updateAllPhone(basePhoneScreen);
        System.out.println(getClass().getSimpleName() + "Eger Numara aramada tuslarda ya da ekranda sorun olursa updateAllPhone lazim olursa o zaman buradaki komudu etkinlestir");
        basePhoneScreen.getController().executeProcess();


    }

    public void sendMessageToEveryOneInContactlist(List<Contact> contactList, String message) {
//        ((MessageScreenController) ((BaseScreen) phone.getPhoneController().getScreen()).getController()).sendMessage(contact, phone.message);

//        System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC contact : "+contactList.size());
//        System.out.println(" contact info : "+ contactList.get(0).toString());
        int a = 0;
        for (Contact item : contactList) {
            a++;
            System.out.println(a + "-) ________________________contact info : " + item + " " + item.getPhoneNumber() + " " + item.getPerson().toString());
            sendMessage(item, message);
        }
        if (contactList.size() > 0)
            changeScreenToLastScreen();
    }

    void sendMessage(Contact contact, String message) {
//        ((MessageScreenController) ((BaseScreen) phone.getPhoneController().getScreen()).getController()).sendMessage(contact, phone.message);
        System.out.println("ZZZZZZZZZZZZZZZZZ contact no : " + contact.getPhoneNumber());
        ((MessageScreenController) phone.getPhoneController().getScreenController()).sendMessage(contact, message);
    }

    public void updateScreenController(BaseScreenController baseScreenController) {
        baseScreenController.updateAllPhone();
    }

    public void printIntegerValueToTextInputControl(TextInputControl textInputControl, PhoneKey phoneKey) {

        if (!isNull(textInputControl)) {
            String newStringCharacter = getIntegerValue(phoneKey);

            String text = textInputControl.getText();
            text += newStringCharacter;
            textInputControl.setText(text);

            updateAllChanges();
        }


    }

    public void printStringValueToTextInputControl(TextInputControl textInputControl, PhoneKey phoneKey) {

        if (!isNull(textInputControl)) {

//            String text = textInputControl.getText();
            String newStringCharacter = getStringValue(phoneKey);

            if (!phoneKey.getController().isCanBeAddNewCharacter()) {
                deleteLastLetter(textInputControl);
            }

            String text = textInputControl.getText();
            text += newStringCharacter;
            textInputControl.setText(text);

            updateAllChanges();
        } else {
            System.out.println(">>>>>>>>>>>>>> text Field Null  ");
//            System.out.println("ama buttondan alinacak deger : " + getValueForNumberArea(btnName));
        }
    }

    public void scrollUpTextArea(TextArea textArea) {
        scrollTextArea(textArea, false);

    }

    public void scrollDownTextArea(TextArea textArea) {
        scrollTextArea(textArea, true);

    }

    public void scrollTextArea(TextArea textArea, boolean seeDownText) {
        System.out.println(" --------->>>> Uyari  textAreada kayarken  yer olmasa bile fazla bir sekilde asagiya inebiliyor siniri yok ");
        double scale = textArea.getScrollTop();
//        scale = seeDownText == true ? +textArea.getFont().getSize() : -textArea.getFont().getSize();
        if (seeDownText) {
            scale += textArea.getFont().getSize();
            System.out.println("NEW SCLAE ++++++++++ " + scale);
        } else {
            scale -= textArea.getFont().getSize();
            System.out.println("NEW SCLAE -------------- " + scale);
        }
        textArea.setScrollTop(scale);
        System.out.println("GELDIIIIIIIIIIIIIIIIIII UP");

    }

    boolean isNull(Object object) {
        if (object == null)
            return true;
        return false;

    }

    String getIntegerValue(PhoneKey phoneKey) {
        String value = phoneKey.getController().getIntegerValue();
        return value;
    }

    String getStringValue(PhoneKey phoneKey) {
        String value = phoneKey.getController().getStringValue();
        return value;
    }

    /**
     * this function is used to update all phone  after execution of an updation process like  texfield
     * or something that is added value like textfield to get last value of these editable value objects
     * -> this update is essential especial for texfield.
     */
    public void updateAllChanges() {
//        System.out.println(getClass().getName() + "  --->> updateAllPhone");
        ((BaseScreen) (phone.getPhoneController().getScreenAnchorPane().getChildren().get(0))).getController().updateAllPhone();
    }

    /**
     * this function is used to update all phone of given screen controller
     */

//    void updateAllPhone(BaseScreen basePhoneScreen) {
//        basePhoneScreen.getController().updateAllPhone();
//
//    }
    public Contact getRegisteredContactInPhoneByPhoneNumber(String phoneNumber) {
        Contact contact = new IdentifyNumber(phone).identifyNumber(phoneNumber);// phone.getRegisteredContact().getContactByPhoneNumber(phoneNumber);
        if (contact != null)
            return contact;

        return new Contact(null, phoneNumber);
    }

    public void deleteLastLetter(TextInputControl textInputControl) {
        String text = "";
        System.out.println("SILINMEDEN ONCE TextInputControl : " + textInputControl.getText());
        for (int i = 0; i < textInputControl.getText().length() - 1; i++) {
            text += textInputControl.getText().charAt(i);
        }
        textInputControl.setText(text);
        System.out.println("SILINDIKTEN SONRA TextInputControl : " + textInputControl.getText());
//        return  textInputControl;
    }
}
