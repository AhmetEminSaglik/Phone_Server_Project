package phone.key;

public class StringValue {
    String text;

    public StringValue(String text) {
        this.text = text;
    }

    public String getCharacterInStringFormat(int clickValue) {
        return text.charAt(clickValue) + "";
    }

}
