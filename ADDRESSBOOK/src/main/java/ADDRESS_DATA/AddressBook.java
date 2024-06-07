package ADDRESS_DATA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * La clase AddressBook representa un libro de direcciones que almacena y gestiona entradas de direcciones.
 * Permite agregar, eliminar, buscar entradas por apellido, cargar datos desde un archivo y mostrar las entradas ordenadas alfabéticamente.
 */
public class AddressBook {
    private static AddressBook instance;
    public List<AddressEntry> addressEntries;

    /**
     * Constructor privado que inicializa la lista de entradas de direcciones.
     */
    private AddressBook() {
        addressEntries = new ArrayList<>();
    }

    /**
     * Método estático que devuelve la instancia única de AddressBook utilizando el patrón Singleton.
     *
     * @return La instancia única de AddressBook.
     */
    public static AddressBook getInstance() {
        if (instance == null) {
            instance = new AddressBook();
        }
        return instance;
    }

    /**
     * Agrega una nueva entrada de dirección al libro de direcciones.
     *
     * @param entry La entrada de dirección a agregar.
     */
    public void add(AddressEntry entry) {
        addressEntries.add(entry);
    }

    /**
     * Elimina una entrada de dirección del libro de direcciones.
     *
     * @param entry La entrada de dirección a eliminar.
     */
    public void remove(AddressEntry entry) {
        addressEntries.remove(entry);
    }

    /**
     * Busca y devuelve todas las entradas de dirección cuyo apellido coincida con el proporcionado.
     *
     * @param lastName El apellido para buscar las entradas de dirección.
     * @return Una lista de entradas de dirección que coinciden con el apellido proporcionado.
     */
    public List<AddressEntry> find(String lastName) {
        List<AddressEntry> results = new ArrayList<>();
        for (AddressEntry entry : addressEntries) {
            if (entry.getLastName().equalsIgnoreCase(lastName)) {
                results.add(entry);
            }
        }
        return results;
    }

    /**
     * Lee las entradas de dirección desde un archivo CSV (comma-separated values) y las agrega al libro de direcciones.
     *
     * @param fileName El nombre del archivo desde el cual cargar las entradas de dirección.
     */
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
    /**
     * Imprime todas las entradas de dirección en orden alfabético basado en el apellido.
     */
    public void printContactsAlphabetically() {
        Collections.sort(addressEntries, Comparator.comparing(AddressEntry::getLastName));
        for (AddressEntry entry : addressEntries) {
            System.out.println(entry);
        }
    }
}
