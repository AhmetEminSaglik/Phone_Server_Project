package server;

import server.registeredphonecard.RegisteredPhoneCard;
import server.registeredphonecard.situation.RegisteredPhoneCardUpdateSituation;

public class UpdationRegisteredPhoneCardSituation {

    /**
     * when phone is created, this function is called to set up its settings
     */

    public static void addProcessesOfRegisteringNewPhoneCard(RegisteredPhoneCard registeredPhoneCard) {
        setColorRegisteredCardPhoneSituationColorAtCreating(registeredPhoneCard);
        closeRequestChangeRegisteredCardPhoneSituationColor(registeredPhoneCard);
    }
//
//    void setRegisterPhoneCardAllSituationColors(RegisteredPhoneCard registeredPhoneCard) {
//        setColorRegisteredCardPhoneSituationColorAtCreating(registeredPhoneCard);
//        closeRequestChangeRegisteredCardPhoneSituationColor(registeredPhoneCard);
//    }

    /**
     * when phone is created, will have situation color also it will have quality with
     * activate-Unactivate button is activated in server phone Card
     */
    public static void setColorRegisteredCardPhoneSituationColorAtCreating(RegisteredPhoneCard registeredPhoneCard) {
        setColorRegisteredCardPhoneSituationColorAvailable(registeredPhoneCard);
    }

    /**
     * when phone call someone or is called then it will be busy
     */
    public static void setColorRegisteredCardPhoneSituationColorBusy(RegisteredPhoneCard registeredPhoneCard) {
        new RegisteredPhoneCardUpdateSituation(registeredPhoneCard).phoneBusy();

    }

    /**
     * if phone is available to call or can be reacheable then it will be available
     */
    public static void setColorRegisteredCardPhoneSituationColorAvailable(RegisteredPhoneCard registeredPhoneCard) {
        new RegisteredPhoneCardUpdateSituation(registeredPhoneCard).phoneAvailable();
    }

    /**
     * when close the phone window then situation color will be changed
     */
    public static void closeRequestChangeRegisteredCardPhoneSituationColor(RegisteredPhoneCard registeredPhoneCard) {
        registeredPhoneCard.getPhone().getStage().setOnCloseRequest(e -> {
            new RegisteredPhoneCardUpdateSituation(registeredPhoneCard).phoneClose();
        });

    }
}
