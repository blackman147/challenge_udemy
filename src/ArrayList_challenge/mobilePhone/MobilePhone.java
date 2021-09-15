package ArrayList_challenge.mobilePhone;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> contacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.contacts = new ArrayList<>();
    }

    public boolean addContact(Contact contact){
        if (findContact(contact.getNames()) >= 0){
            System.out.println("Contact is already on");
            return false;
        }
        contacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0){
            System.out.println("contact does not exist");
            return false;
        }else if (findContact(newContact) != -1){
            System.out.println("Contact with name " + newContact.getNames() + " already exists. Update not successful");
            return false;
        }
        contacts.set(foundPosition, newContact);
        System.out.println(oldContact.getNames() + " Was replaced with " + newContact.getNames());
        return true;
    }

    public boolean removeContact(Contact contact){
        int foundPosition = findContact(contact);
        if (foundPosition < 0){
            System.out.println("contact does not exist");
            return false;
        }
        contacts.remove(foundPosition);
        System.out.println(contact.getNames() + " was deleted");
        return true;
    }

    private int findContact(Contact contact){
        return this.contacts.indexOf(contact);
    }
    
    private int findContact(String contactName){
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact.getNames().equals(contactName)){
                return i;
            }
        }
        return -1;
    }

    public String queryContact(Contact contact){
        if (findContact(contact) > 0){
            return contact.getNames();
        }
        return null;
    }

    public Contact queryContact(String name){
        int position = findContact(name);
        if (position >= 0){
            return contacts.get(position);
        }
        return null;
    }


    public void printContact() {
        System.out.println("Contact List");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i).getNames() + " " +
                                contacts.get(i).getPhoneNumber());
        }
    }
}
