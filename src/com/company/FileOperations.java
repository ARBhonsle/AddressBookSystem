package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;

public class FileOperations {
    static String path = "src/resources/AddressBookContacts.txt";
    static File file = new File(path);
    static BufferedReader br = null;
    static BufferedWriter bw = null;

    public FileOperations() throws IOException {
    }

    public static void readFile() throws IOException {
        String line = null;
        try {
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ioE) {
            throw new IOException(ioE);
        } finally {
            br.close();
        }
    }

    public static void writeFile(Hashtable<String, ArrayList<PersonDetails>> dictionaryBook) throws Exception {
        try {
            bw = new BufferedWriter(new FileWriter(file));
            for (String key : dictionaryBook.keySet()) {
                for (PersonDetails person : dictionaryBook.get(key)) {
                    bw.append(person.getDetails());
                    bw.newLine();
                }
            }
        } catch (IOException exception) {
            throw new IOException(exception);
        } finally {
            bw.close();
        }
    }
}
