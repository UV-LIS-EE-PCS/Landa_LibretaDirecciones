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
    private List<AddressEntry> addressEntries;

    private AddressBook() {
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

    public List<AddressEntry> listAlphabetically() {
        List<AddressEntry> sortedEntries = new ArrayList<>(addressEntries);
        Collections.sort(sortedEntries, Comparator.comparing(AddressEntry::getLastName).thenComparing(AddressEntry::getFirstName));
        return sortedEntries;
    }

    public void readFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 8) {
                    AddressEntry entry = new AddressEntry(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]);
                    add(entry);
                }
            }
        } catch (IOException e) {
            System.err.println("Error leyendo el archivo: " + e.getMessage());
        }
    }
}
