package ArrayList_challenge.mobilePhone;

import java.util.Scanner;

public class mobilePhoneMain {
    public static Scanner scan =  new Scanner(System.in);
    public static MobilePhone phone = new MobilePhone("0816 052 8316");

    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        printActions();

        while (!quit){
            System.out.println("Enter action: (6 to print out available actions)");
            int action = scan.nextInt();
            scan.nextLine();

            switch (action){
                case 0:
                    System.out.println("\n Phone is shutting down....");
                    quit = true;
                    break;
                case 1:
                    phone.printContact();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }
    }

    public static void addNewContact(){
        System.out.println("Enter new contact name");
        String name = scan.nextLine();
        System.out.println("Enter new contact phone number");
        String phoneNumber = scan.nextLine();
        Contact newContact = Contact.createContact(name, phoneNumber);
        if (phone.addContact(newContact)){
            System.out.println("New contact added: name = " + name + " phoneNumber = " + phoneNumber );
        }else {
            System.out.println("Cannot add " + name + "already on file");
        }
    }

    public static void updateContact(){
        System.out.println("Enter existing contact name:  ");
        String name = scan.nextLine();
        Contact existingContact = phone.queryContact(name);
        if (existingContact == null){
            System.out.println("Contact not found ");
        }
        System.out.println("Enter new contact name: ");
        String newName = scan.nextLine();
        System.out.println("Enter new contact phone number: ");
        String newPhoneNumber = scan.nextLine();
        Contact newContact = Contact.createContact(newName, newPhoneNumber);
        if (phone.updateContact(existingContact, newContact)){
            System.out.println("Contact successfully updated ");
        }else{
            System.out.println("Error updating contact");
        }
    }

    public static void removeContact(){
        System.out.println("Enter existing contact name:  ");
        String name = scan.nextLine();
        Contact existingContact = phone.queryContact(name);
        if (existingContact == null){
            System.out.println("Contact not found ");
        }
        if (phone.removeContact(existingContact)){
            System.out.println("Contact successfully deleted");
        }else {
            System.out.println("Error deleting contact");
        }

    }

    public static void queryContact(){
        System.out.println("Enter existing contact name:  ");
        String name = scan.nextLine();
        Contact existingContact = phone.queryContact(name);
        if (existingContact == null){
            System.out.println("Contact not found ");
        }
        System.out.println("Name: " + existingContact.getNames()+ "phoneNumber: " + existingContact.getPhoneNumber());
    }

    public static void startPhone(){
        System.out.println("Phone is starting .....");
    }
    public static void printActions(){
        System.out.println("\n Available actions: \n press");
        System.out.println("0 - to shutdown \n" +
                            " 1 - to print contact list\n" +
                            " 2 - to add new contact\n" +
                            " 3 - to update existing contact\n" +
                            " 4 - to remove contact\n" +
                            " 5 - to Query if a contact already exist\n" +
                            " 6 - to  print a list of available actions ");
        System.out.println("Choose your action");
    }

}
