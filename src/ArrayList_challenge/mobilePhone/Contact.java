package ArrayList_challenge.mobilePhone;

public class Contact {
   private String names;
   private String phoneNumber;

    public Contact(String names, String phoneNumber) {
        this.names = names;
        this.phoneNumber = phoneNumber;
    }

    public String getNames() {
        return names;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static Contact createContact (String names, String phoneNumber){
        return new Contact(names, phoneNumber);
    }

}
