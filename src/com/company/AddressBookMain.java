package com.company;

import java.util.*;

/**
 * Address Book creates contact list, adds new contacts, edits contact info, deletes contact info, add multiple contacts
 */
public class AddressBookMain {
    // variables
    static ArrayList<PersonDetails> contactList = new ArrayList<>();
    static Hashtable<String,ArrayList<PersonDetails>> dictionaryBook=new Hashtable<>();

    static Scanner sc=new Scanner(System.in);

    // add address book method
    static void addAddressBook(){
        System.out.println("Address Book Name: ");
        String name=sc.next();
        ArrayList<PersonDetails> contact=new ArrayList<>();
        dictionaryBook.put(name,contact);
    }
    // display address book
    static void displayAddressBook(){
        for (Map.Entry m: dictionaryBook.entrySet()) {
            System.out.println(m.getKey() + " : "+m.getValue());
        }
    }


    // method for menu operations
    public static void addContactList(){
        boolean exit=true;
        do{
            System.out.println("Choose: 1. Display all Address Book 2. Add new Address Book 3. 3. Modify Address Book 4. Exit");
            int option=sc.nextInt();
            switch(option){
                case 1:
                    displayAddressBook();
                    break;
                case 2:
                    addAddressBook();
                    break;
                case 3:
                    System.out.println("Choose: 1. Display all contacts 2. Add contact 3. Edit contact 4. Delete contact");
                    option=sc.nextInt();
                    String name;
                    switch (option){
                        case 1:
                            ContactListOperations.displayContact(contactList);
                            break;
                        case 2:
                            ContactListOperations.addContact(null,contactList);
                            break;
                        case 3:
                            ContactListOperations.editContact(contactList);
                            break;
                        case 4:
                            ContactListOperations.deleteContact(contactList);
                            break;
                        default:
                            System.out.println("Wrong input");
                            break;
                    }
                    break;
                case 4:
                    exit=false;
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        }while(exit);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        addContactList();
    }
}
