package com.company;

import java.util.Scanner;

/**
 * Address Book creates contact list, adds new contacts
 */
public class AddressBookMain {

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        PersonDetails contactPersons=new PersonDetails();
        System.out.println("Give details of contact person:");
        Scanner sc=new Scanner(System.in);
        System.out.println("Person First Name: ");
        contactPersons.setFirstName(sc.next());
        System.out.println("Person Last Name: ");
        contactPersons.setLastName(sc.next());
        System.out.println("Address: ");
        contactPersons.setAddress(sc.next());
        System.out.println("City: ");
        contactPersons.setCity(sc.next());
        System.out.println("State: ");
        contactPersons.setState(sc.next());
        System.out.println("ZipCode: ");
        contactPersons.setZipCode(sc.nextInt());
        System.out.println("Email: ");
        contactPersons.setEmail(sc.next());
        System.out.println("Phone Number: ");
        contactPersons.setPhoneNumber(sc.nextLong());
    }
}
