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
                return person.toString();
            return phoneNumber;
        }
        return person.toString();
    }

    public void setContact(Contact contact) {
        this.person = contact.getPerson();
        this.phoneNumber = contact.getPhoneNumber();
    }

    public String getLimitedNameChracter(int lessSpace) { //, int moreSpace
        String text = "";


        for (int i = 0; i < totalCharNumberToShow - 2 - lessSpace; i++) {

            if (getPerson().toString().length() > i) {
                text += getPerson().toString().charAt(i);
            } else {
                text += "  ";
            }

            if (i == totalCharNumberToShow - lessSpace - 5 && getPerson().toString().length() > i) {
                text += ". . .";
                break;
            }
        }

      for (int i = 0; i < 5; i++) {
            text += "  ";

        }
        return text;
    }
}
