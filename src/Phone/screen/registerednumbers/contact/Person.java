package phone.screen.registerednumbers.contact;

public class Person {
    String name, surname;
    public final static String unKnownPerson = "Unknown Person";

    public Person(String name, String surname) {
        this.name = name.trim();
        if (surname != null) {
            this.surname = surname.trim();
        }

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        if (surname != null)
            return surname;
        return "";
    }

    @Override
    public String toString() {
        return name + " " + getSurname();
    }


}

