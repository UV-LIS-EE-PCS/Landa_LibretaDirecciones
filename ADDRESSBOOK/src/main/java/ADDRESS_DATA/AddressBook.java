package ADDRESS_DATA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AddressBook {
    private static AddressBook instance;
    List<AddressEntry> addressEntries;

    public AddressBook() {
        addressEntries = new ArrayList<>();
    }

    public static AddressBook getInstance() {
        if (instance == null) {
            instance = new AddressBook();
        }
        return instance;
    }

    public void add(AddressEntry entry) {
        addressEntries.add(entry);
    }

    public void remove(AddressEntry entry) {
        addressEntries.remove(entry);
    }

    public List<AddressEntry> find(String lastName) {
        List<AddressEntry> results = new ArrayList<>();
        for (AddressEntry entry : addressEntries) {
            if (entry.getLastName().equalsIgnoreCase(lastName)) {
                results.add(entry);
            }
        }
        return results;
    }

    public void readFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 8) {
                    try {
                        AddressEntry entry = new AddressEntry(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]);
                        add(entry);
                    } catch (Exception e) {
                        System.err.println("Error al crear AddressEntry: " + e.getMessage());
                    }
                } else {
                    System.err.println("Formato de datos incorrecto: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public void printContactsAlphabetically() {
        Collections.sort(addressEntries, Comparator.comparing(AddressEntry::getLastName));
        for (AddressEntry entry : addressEntries) {
            System.out.println(entry);
        }
    }
}