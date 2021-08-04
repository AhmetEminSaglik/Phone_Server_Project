package server.registeredphonecard.situation;

import phone.Phone;
import phone.key.ability.function.Function;
import server.registeredphonecard.RegisteredPhoneCard;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;

public class RegisteredPhoneCardUpdateSituation {
    RegisteredPhoneCard registeredPhoneCard;
    Phone phone;

    public RegisteredPhoneCardUpdateSituation(RegisteredPhoneCard registeredPhoneCard) {
        this.registeredPhoneCard = registeredPhoneCard;
        this.phone = registeredPhoneCard.getPhone();

    }

    public void phoneClose() {
        paintPhoneSituation(new RegisteredPhoneCardSituationColor(phone).getOffLineColor());
        new Function(phone).changeScreenToMainScreen();
        updateActivateCloseBtn("Activate Phone", btnActivateFunction());
    }

    public void phoneAvailable() {
        updateActivateCloseBtn("Unactivate Phone", btnUnActivateFunction());
        paintPhoneSituation(new RegisteredPhoneCardSituationColor(phone).getOnLineColor());

    }

    public void phoneBusy() {
        updateActivateCloseBtn("Unactivate Phone (Is Busy)", btnUnActivateFunction());
        paintPhoneSituation(new RegisteredPhoneCardSituationColor(phone).getBusyColor());

    }

    public void phoneIsOnCall() {
        paintPhoneSituation(new RegisteredPhoneCardSituationColor(phone).getBusyColor());
    }

    void paintPhoneSituation(Color color) {
        registeredPhoneCard.getPhoneSituation().setFill(color);
        registeredPhoneCard.getPhoneSituation().setStroke(color);
    }

    void updateActivateCloseBtn(String btnName, EventHandler<ActionEvent> event) {
        registeredPhoneCard.getBtnActivateOrUnActivate().setText(btnName);
        registeredPhoneCard.getBtnActivateOrUnActivate().setOnAction(event);

    }

    EventHandler<ActionEvent> btnActivateFunction() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                phone.getStage().show();
                phoneAvailable();
            }
        };
    }

    EventHandler<ActionEvent> btnUnActivateFunction() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                phone.getStage().close();
                phoneClose();

            }
        };
    }


}
