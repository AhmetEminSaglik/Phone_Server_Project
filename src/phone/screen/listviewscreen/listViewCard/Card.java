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
