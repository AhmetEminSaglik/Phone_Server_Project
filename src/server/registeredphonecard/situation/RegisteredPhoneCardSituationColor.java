package server.registeredphonecard.situation;

import javafx.scene.paint.Color;
import phone.Phone;

public class RegisteredPhoneCardSituationColor {
    Phone phone;

    public RegisteredPhoneCardSituationColor(Phone phone) {
        this.phone = phone;
    }

    public Color getOnLineColor() {
        phone.setSituation(PhoneSituation._AVAILABLE);
        return Color.LIMEGREEN;

    }

    public Color getOffLineColor() {
        phone.setSituation(PhoneSituation._CLOSED);
        return Color.BLACK;

    }

    public Color getBusyColor() {
        phone.setSituation(PhoneSituation._BUSY);
        return Color.RED;

    }
}
