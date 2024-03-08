package phone.key;

import phone.ExceptionManagement;

public class IntegerFromString {
    String text;

    public IntegerFromString(String text) {
        this.text = text;
    }

    public String getIntegerInStringVariable() {
        int integerValue = 0;
        for (int i = 0; i < text.length(); i++) {
            integerValue = getValue(text.charAt(i) + "");
            if (integerValue != -1) {
                return Integer.toString(integerValue);
            }
        }
        return text.charAt(text.length() - 1) + "";
    }

    int getValue(String stringValue) {
        try {
            int integerValue = Integer.parseInt(stringValue);
            return integerValue;
        } catch (NumberFormatException ex) {
//            ExceptionManagement.printException(ex);
        }
        return -1;

    }
}
