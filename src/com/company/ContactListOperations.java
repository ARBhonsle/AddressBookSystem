package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactListOperations {
    static Scanner sc=new Scanner(System.in);

    // method adds contact of multiple people
    public static void addContact(ArrayList<PersonDetails> contactList){
        System.out.println("Number of contacts to be added");
        int number= sc.nextInt();
        for (int i=0;i<number;i++){
            PersonDetails person = new PersonDetails();
            System.out.println("Give details of contact person:");
            System.out.println("Person First Name: ");
            String firstName = sc.next();
            System.out.println("Person Last Name: ");
            String lastName = sc.next();
            if(findByName(firstName,lastName,contactList)){
                System.out.println("Person exists by this name, cannot create duplicate contact");
                break;
            }
            person.setFirstName(firstName);
            person.setLastName(lastName);
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
    public static void editContact(ArrayList<PersonDetails> contactList){
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
    public static void deleteContact(ArrayList<PersonDetails> contactList) {
        System.out.println("Enter the first name of contact you wish to delete");
        String delete = sc.next();
        contactList.removeIf(contact->contact.firstName.equals(delete));
    }

    public static boolean findByName(String fname, String lname, ArrayList<PersonDetails> contactList){
        for(PersonDetails person : contactList){
            if(person.getFirstName().equals(fname) && person.getLastName().equals(lname)){
                return true;
            }
        }
        return false;
    }
}
