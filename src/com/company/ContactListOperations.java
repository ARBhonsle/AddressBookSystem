package com.company;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ContactListOperations {
    static Scanner sc = new Scanner(System.in);
    static HashMap<String, List<PersonDetails>> CityDictionary, StateDictionary;
    static ArrayList<List<PersonDetails>> sortedList;
    static FileOperations fileOperations;

    static {
        try {
            fileOperations = new FileOperations();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // method adds contact of multiple people
    public static void addContact(ArrayList<PersonDetails> contactList) {
        System.out.println("Number of contacts to be added");
        int number = sc.nextInt();
        for (int i = 0; i < number; i++) {
            PersonDetails person = new PersonDetails();
            System.out.println("Give details of contact person:");
            System.out.println("Person First Name: ");
            String firstName = sc.next();
            System.out.println("Person Last Name: ");
            String lastName = sc.next();
            person.setFirstName(firstName);
            person.setLastName(lastName);
            if (findByName(person, contactList)) {
                System.out.println("Person exists by this name, cannot create duplicate contact");
                break;
            }
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
        for (PersonDetails contact : contactList) {
            System.out.println("Person First Name: " + contact.getFirstName());
            System.out.println("Person Last Name: " + contact.getLastName());
            System.out.println("Address: " + contact.getAddress());
            System.out.println("City: " + contact.getCity());
            System.out.println("State: " + contact.getState());
            System.out.println("ZipCode: " + contact.getZipCode());
            System.out.println("Email: " + contact.getEmail());
            System.out.println("Phone Number: " + contact.getPhoneNumber());

        }
    }

    // edits contact info
    public static void editContact(ArrayList<PersonDetails> contactList) {
        System.out.println("Enter the first name of contact you wish to edit");
        String edit = sc.next();
        for (PersonDetails contactItems : contactList) {
            if (contactItems.firstName.equals(edit)) {
                System.out.println("Press 1. To edit first name 2. To edit last name 3. To edit address");
                System.out.println("Press 4. To edit city 5. To edit state 6. To edit zip code");
                System.out.println("Press 7. To edit phone number 8. To edit email");
                int choice = sc.nextInt();
                switch (choice) {
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
                    case 4:
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
        contactList.removeIf(contact -> contact.firstName.equals(delete));
    }

    public static boolean findByName(PersonDetails personName, ArrayList<PersonDetails> contactList) {
        for (PersonDetails person : contactList) {
            if (person.getFirstName().equals(personName.getFirstName()) && person.getLastName().equals(personName.getLastName())) {
                return true;
            }
        }
        return false;
    }

    public static List<PersonDetails> findByCityOrState(String city, String state, Hashtable<String, ArrayList<PersonDetails>> dictionaryBook) {
        List<PersonDetails> persons = new ArrayList<>();
        for (List<PersonDetails> personlist : dictionaryBook.values()) {
            personlist = personlist.stream().filter(person -> person.getCity().equals(city) || person.getState().equals(state)).collect(Collectors.toList());
            persons.addAll(personlist);
        }
        return persons;
    }

    public static void printPersonByCityOrState(String city, String state, Hashtable<String, ArrayList<PersonDetails>> dictionaryBook) {
        CityDictionary.put(city, findByCityOrState(city, "", dictionaryBook));
        StateDictionary.put(state, findByCityOrState("", state, dictionaryBook));
        System.out.println("Persons by city:" + city);
        System.out.println(CityDictionary.values().stream().collect(Collectors.toList()));
        System.out.println("Persons by State:" + state);
        System.out.println(StateDictionary.values().stream().collect(Collectors.toList()));
    }

    public static void countPersonByCityOrState(String city, String state, Hashtable<String, ArrayList<PersonDetails>> dictionaryBook) {
        CityDictionary.put(city, findByCityOrState(city, "", dictionaryBook));
        StateDictionary.put(state, findByCityOrState("", state, dictionaryBook));
        System.out.println("Number of Persons by city:" + city);
        System.out.println(CityDictionary.values().stream().count());
        System.out.println("Number of Persons by State:" + state);
        System.out.println(StateDictionary.values().stream().count());
    }

    public static ArrayList<List<PersonDetails>> sortByFirstName(Hashtable<String, ArrayList<PersonDetails>> dictionaryBook) {
        sortedList = null;
        List<PersonDetails> list;
        for (String key : dictionaryBook.keySet()) {
            list = dictionaryBook.get(key).stream().sorted(Comparator.comparing(PersonDetails::getFirstName)).collect(Collectors.toList());
            sortedList.add(list);
        }
        return sortedList;
    }

    public static ArrayList<List<PersonDetails>> sortEntryByCityStateOrZipCode(Hashtable<String, ArrayList<PersonDetails>> dictionaryBook) throws Exception {
        sortedList = null;
        List<PersonDetails> list;
        Comparator compare;
        System.out.println("Sort by 1. City 2. State 3. ZipCode ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Sort by City: ");
                for (String key : dictionaryBook.keySet()) {
                    list = dictionaryBook.get(key).stream().sorted(Comparator.comparing(PersonDetails::getCity)).collect(Collectors.toList());
                    sortedList.add(list);
                }
                break;
            case 2:
                System.out.println("Sort by State: ");
                for (String key : dictionaryBook.keySet()) {
                    list = dictionaryBook.get(key).stream().sorted(Comparator.comparing(PersonDetails::getState)).collect(Collectors.toList());
                    sortedList.add(list);
                }
                break;
            case 3:
                System.out.println("Sort by ZipCode: ");
                for (String key : dictionaryBook.keySet()) {
                    list = dictionaryBook.get(key).stream().sorted(Comparator.comparing(PersonDetails::getZipCode)).collect(Collectors.toList());
                    sortedList.add(list);
                }
                break;
            default:
                throw new Exception("Incorrect input");
        }
        return sortedList;
    }

    public static void fileActivity(int choice, Hashtable<String, ArrayList<PersonDetails>> dictionaryBook) throws Exception {
        if (choice == 1) {
            System.out.println("Read Operation:");
            fileOperations.readFile();
        } else if (choice == 2) {
            System.out.println("Write Operation:");
            fileOperations.writeFile(dictionaryBook);
        } else {
            throw new Exception("Incorrect input");
        }
    }
}
