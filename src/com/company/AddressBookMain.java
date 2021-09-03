package com.company;

import java.util.*;

/**
 * Address Book creates contact list, adds new contacts, edits contact info, deletes contact info, add multiple contacts
 */
public class AddressBookMain {
    // variables
    static String city, state;
    static ArrayList<PersonDetails> contactList;
    static Hashtable<String, ArrayList<PersonDetails>> dictionaryBook;

    static Scanner sc = new Scanner(System.in);

    // add address book method
    public static void addAddressBook(String name) {
        contactList = new ArrayList<>();
        dictionaryBook.put(name, contactList);
    }

    // display address book
    static void displayAddressBook() {
        for (Map.Entry m : dictionaryBook.entrySet()) {
            System.out.println(m.getKey() + " : " + m.getValue());
        }
    }


    // method for menu operations
    public static void addContactList() {
        boolean exit = true;
        do {
            System.out.println("Choose: 1. Display all Address Book 2. Add new Address Book 3. Modify Address Book 4. 4. Find person by city or state 5. View person by city or state 6. Exit");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    displayAddressBook();
                    break;
                case 2:
                    System.out.println("Give address book name: ");
                    String name = sc.next();
                    addAddressBook(name);
                    break;
                case 3:
                    System.out.println("Choose: 1. Display all contacts 2. Add contact 3. Edit contact 4. Delete contact");
                    option = sc.nextInt();
                    System.out.println("Enter Address Book Name");
                    String nameAddr = sc.next();
                    contactList = dictionaryBook.get(nameAddr);
                    switch (option) {
                        case 1:
                            ContactListOperations.displayContact(contactList);
                            break;
                        case 2:
                            ContactListOperations.addContact(contactList);
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
                    System.out.println("Find people by city or state in address books");
                    System.out.println("Give city: ");
                    city = sc.next();
                    System.out.println("Give State: ");
                    state = sc.next();
                    if (ContactListOperations.findByCityOrState(city, state, dictionaryBook) == null) {
                        System.out.println("No people found matching search");
                    } else {
                        ContactListOperations.findByCityOrState(city, state, dictionaryBook);
                    }
                    break;
                case 5:
                    System.out.println("Find people by city or state in address books");
                    System.out.println("Give city: ");
                    city = sc.next();
                    System.out.println("Give State: ");
                    state = sc.next();
                    ContactListOperations.printPersonByCityOrState(city, state, dictionaryBook);
                    break;
                case 6:
                    exit = false;
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        } while (exit);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        addContactList();
    }
}
