package com.company;

/**
 * Address Book creates contact list
 */
public class AddressBookMain {

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        PersonDetails contactPersons=new PersonDetails("Helen","Carl","London,UK","London","UK","helenCarl@mail.com",2354322,8902347889L);
        System.out.println("Person Name: "+ contactPersons.getFirstName()+ " "+contactPersons.getLastName());
        System.out.println("Address: "+contactPersons.getAddress());
        System.out.println("City: "+contactPersons.getCity());
        System.out.println("State: "+contactPersons.getState());
        System.out.println("ZipCode: "+contactPersons.getZipCode());
        System.out.println("Email: "+contactPersons.getEmail());
        System.out.println("Phone Number: "+contactPersons.getPhoneNumber());
    }
}
