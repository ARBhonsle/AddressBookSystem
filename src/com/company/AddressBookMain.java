package com.company;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Address Book creates contact list, adds new contacts, edits contact info, deletes contact info, add multiple contacts
 */
public class AddressBookMain {
    // variables
    static ArrayList<PersonDetails> contactList = new ArrayList<>();
    static Scanner sc=new Scanner(System.in);

    // method adds contact of multiple people
    public static void addContact(PersonDetails person,ArrayList<PersonDetails> contactList){
        System.out.println("Number of contacts to be added");
        int number= sc.nextInt();
        for (int i=0;i<number;i++){
            person=new PersonDetails();
            System.out.println("Give details of contact person:");
            Scanner sc=new Scanner(System.in);
            System.out.println("Person First Name: ");
            person.setFirstName(sc.next());
            System.out.println("Person Last Name: ");
            person.setLastName(sc.next());
            System.out.println("Address: ");
            person.setAddress(sc.next());
            System.out.println("City: ");
            person.setCity(sc.next());
            System.out.println("State: ");
            person.setState(sc.next());
            System.out.println("ZipCode: ");
            person.setZipCode(sc.nextInt());
            System.out.println("Email: ");
            person.setEmail(sc.next());
            System.out.println("Phone Number: ");
            person.setPhoneNumber(sc.nextLong());
            contactList.add(person);
        }
    }
    // displays contact info
    public static void displayContact(ArrayList<PersonDetails> contactList)//Display Address book
    {
        for (PersonDetails contact : contactList)
        {
            System.out.println("Person First Name: "+contact.getFirstName());
            System.out.println("Person Last Name: "+contact.getLastName());
            System.out.println("Address: "+contact.getAddress());
            System.out.println("City: "+contact.getCity());
            System.out.println("State: "+contact.getState());
            System.out.println("ZipCode: "+contact.getZipCode());
            System.out.println("Email: "+contact.getEmail());
            System.out.println("Phone Number: "+contact.getPhoneNumber());

        }
    }
    // edits contact info
    public static void editContact(){
        System.out.println("Enter the first name of contact you wish to edit");
        String edit = sc.next();
        for (PersonDetails contactItems : contactList) {
            if (contactItems.firstName.equals(edit)) {
                System.out.println("Press 1. To edit first name 2. To edit last name 3. To edit address");
                System.out.println("Press 4. To edit city 5. To edit state 6. To edit zip code");
                System.out.println("Press 7. To edit phone number 8. To edit email");
                int choice = sc.nextInt();
                switch (choice){
                    case 1:
                        System.out.println("Enter new first name");
                        contactItems.setFirstName(sc.next());
                        break;
                    case 2:
                        System.out.println("Enter new last name");
                        contactItems.setLastName(sc.next());
                        break;
                    case 3:
                        System.out.println("Enter new address");
                        contactItems.setAddress(sc.next());
                        break;
                    case 4 :
                        System.out.println("Enter new city");
                        contactItems.setCity(sc.next());
                        break;
                    case 5:
                        System.out.println("Enter new state");
                        contactItems.setState(sc.next());
                        break;
                    case 6:
                        System.out.println("Enter new zip code");
                        contactItems.setZipCode(sc.nextInt());
                        break;
                    case 7:
                        System.out.println("Enter new phone number");
                        contactItems.setPhoneNumber(sc.nextLong());
                        break;
                    case 8:
                        System.out.println("Enter new email");
                        contactItems.setEmail(sc.next());
                        break;
                }
            }
        }
    }

    // deletes contact info
    public static void deleteContact() {
        System.out.println("Enter the first name of contact you wish to delete");
        String delete = sc.next();
        contactList.removeIf(contact->contact.firstName.equals(delete));
    }

    // method for contact list operations
    public static void addContactList(){
        boolean exit=true;
        do{
            System.out.println("Choose: 1. Display all contacts 2. Add contact 3. Edit contact 4. Delete contact 5. Exit");
            int option=sc.nextInt();
            switch(option){
                case 1:
                    displayContact(contactList);
                    break;
                case 2:
                    addContact(null,contactList);
                    break;
                case 3:
                    editContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
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
