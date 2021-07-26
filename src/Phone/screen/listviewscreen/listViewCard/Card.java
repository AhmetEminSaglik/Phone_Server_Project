package phone.screen.listviewscreen.listViewCard;

import phone.screen.basescreen.BaseScreen;

public abstract class Card {
    protected String name;
    protected BaseScreen phoneScreen;
    int totalCharNumberToShow = 30;

    public Card(String name, BaseScreen phoneScreen) {
        this.name = name;
        this.phoneScreen = phoneScreen;
    }

//    public String limitTheNameWillBeShown(int totalCharNumberToShow) {
//        return getLimitedName(totalCharNumberToShow);
//    }
//
//    public String limitTheNameWillBeShown() {
//        return getLimitedName(totalCharNumberToShow);
//    }
//
//    String getLimitedName(int totalCharNumberToShow) {
//        String text = "";
//        for (int i = 0; i < totalCharNumberToShow; i++) {
//            text += name.charAt(i);
//        }
//        text += "...";
//        return text;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BaseScreen getPhoneScreen() {
        return phoneScreen;
    }

    public void setPhoneScreen(BaseScreen phoneScreen) {
        this.phoneScreen = phoneScreen;
    }

    @Override
    public String toString() {
        return name;
    }
}
