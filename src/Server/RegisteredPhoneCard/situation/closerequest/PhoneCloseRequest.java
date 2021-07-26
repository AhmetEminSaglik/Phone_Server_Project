//package server.registeredphonecard.situation.closerequest;
//
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.paint.Color;
//import phone.key.ability.function.Function;
//import server.registeredphonecard.RegisteredPhoneCard;
//import server.registeredphonecard.situation.RegisteredPhoneCardSituationColor;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class PhoneCloseRequest {
//    List<EventHandler<ActionEvent>> actionList = new ArrayList<>();
//    RegisteredPhoneCard registeredPhoneCard;
//
//    public PhoneCloseRequest(RegisteredPhoneCard registeredPhoneCard) {
//        this.registeredPhoneCard = registeredPhoneCard;
//
//        setBasicEvent();
////        paintPhoneSituation(new RegisteredPhoneCardSituationColor(registeredPhoneCard.getPhone()).getOffLineColor());
////        new Function(registeredPhoneCard.getPhone()).changeScreenToMainScreen();
////        updateActivateCloseBtn("Activate Phone", btnActivateFunction());
//
//    }
//
//    void setBasicEvent() {
//        actionList.add(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                phoneClose();
//                System.out.println("BUNU YAZDIRMALIIIIIIII");
//            }
//        });
//    }
//
//
//    public void phoneClose() {
//
//        paintPhoneSituation(new RegisteredPhoneCardSituationColor(registeredPhoneCard.getPhone()).getOffLineColor());
////        new KeyAbility(phone).changeScreenToMainMenu();
////        new Function(phone).changeScreen(new MainMenuScreen(phone));s
//        new Function(registeredPhoneCard.getPhone()).changeScreenToMainScreen();
//        updateActivateCloseBtn("Activate Phone", btnActivateFunction());
//    }
//
//
//    void paintPhoneSituation(Color color) {
//        registeredPhoneCard.getPhoneSituation().setFill(color);
//        registeredPhoneCard.getPhoneSituation().setStroke(color);
//    }
//
//    void updateActivateCloseBtn(String btnName, EventHandler<ActionEvent> event) {
//        registeredPhoneCard.getBtnActivateOrUnActivate().setText(btnName);
//        registeredPhoneCard.getBtnActivateOrUnActivate().setOnAction(event);
//    }
//
//    EventHandler<ActionEvent> btnActivateFunction() {
//        return new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                registeredPhoneCard.getPhone().getStage().show();
//                phoneAvailable();
//            }
//        };
//    }
//
//    EventHandler<ActionEvent> btnUnActivateFunction() {
//        return new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                registeredPhoneCard.getPhone().getStage().close();
//                phoneClose();
//            }
//        };
//    }
//
//    public void phoneAvailable() {
//        updateActivateCloseBtn("Unactivate Phone", btnUnActivateFunction());
//        paintPhoneSituation(new RegisteredPhoneCardSituationColor(registeredPhoneCard.getPhone()).getOnLineColor());
//
//    }
//
//    public EventHandler<ActionEvent> get(int index) {
//        return actionList.get(index);
//    }
//
//    public EventHandler<ActionEvent> getEvent(){}
//    public List<EventHandler<ActionEvent>> getActionList() {
//        return actionList;
//    }
//
//    public void setActionList(List<EventHandler<ActionEvent>> actionList) {
//        this.actionList = actionList;
//    }
//
//    public int size() {
//        return actionList.size();
//    }
//}
