package phone.screen.registerednumbers.contact;

public class Contact {
    Person person;
    String phoneNumber;
    final int totalCharNumberToShow = 24;

    public Contact(Person person, String phoneNumber) {
        this.person = person;

        this.phoneNumber = phoneNumber;
    }

    public Person getPerson() {
        if (person == null) {
            person = new Person(phoneNumber + " ", "");
        }
        return person;

    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        if (phoneNumber != null) {
            if (person != null)
                return person.toString();//+ " " + phoneNumber; // +" "+phoneNumber
            return phoneNumber; // +" "+phoneNumber
        }

        return person.toString();
    }

    public void setContact(Contact contact) {
        this.person = contact.getPerson();
        this.phoneNumber = contact.getPhoneNumber();
    }

    public String getLimitedNameChracter(int lessSpace,int moreSpace) {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        String text = "";


        for (int i = 0; i < totalCharNumberToShow-2-lessSpace; i++) {

            if (getPerson().toString().length() > i) {
                text += getPerson().toString().charAt(i);
            } else {
                text += "  ";
            }

            if (i == totalCharNumberToShow -lessSpace- 5 && getPerson().toString().length() > i) {
                text += ". . .";
                break;
            }
        }
        for (int i = 0; i < moreSpace; i++) {
            text += "  ";

        }
        return text;
//        if (getPerson().toString().length() > totalCharNumberToShow) {
//            for (int i = 0; i < totalCharNumberToShow; i++) {
//                text += getPerson().toString().charAt(i);
//            }
//            text += "...";
//            return text;
//        } else {
//            text = getPerson().toString();
//            System.out.println("text : " + text);
//            System.out.println("getPerson().toString().length(): " + getPerson().toString().length());
//            for (int i = 25+moreSpace - getPerson().toString().length(); i > 0; i--) {
//                text += "  ";
//
//            }
//            return text;
//        }
    }

//    public String getNameByLimitingIt(int totalCharNumberToShow) {
//        return getLimitedName(totalCharNumberToShow);
//    }

//    int totalCharNumberToShow = 40;
//
//    public String getNameByLimitingIt() {
//        return getLimitedName(totalCharNumberToShow);
//    }

//    String getLimitedName(int totalCharNumberToShow) {
//        String text = "";
//        for (int i = 0; i < totalCharNumberToShow; i++) {
//            text += person.toString().charAt(i);
//        }
//        text += "...";
//        return text;
//    }

}
