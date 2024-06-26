package ADDRESS;

import java.util.List;
import java.util.Scanner;
import ADDRESS_DATA.AddressBook;
import ADDRESS_DATA.AddressEntry;

/**
 * La clase Menu proporciona una interfaz de usuario basada en texto para interactuar con el libro de direcciones.
 * Permite al usuario cargar datos desde un archivo, agregar, eliminar, buscar y mostrar entradas en el libro de direcciones.
 */
public class Menu {
    public AddressBook addressBook;
    private Scanner scanner;

    /**
     * Constructor que inicializa el libro de direcciones y el escáner para la entrada del usuario.
     */
    public Menu() {
        addressBook = AddressBook.getInstance();
        scanner = new Scanner(System.in);
    }

    /**
     * Muestra el menú principal y maneja las selecciones del usuario.
     * Permanece en un bucle hasta que el usuario elige salir.
     */
    public void displayMenu() {
        char choice;
        do {
            System.out.println("====================================");
            System.out.println("Elige una opción del menú");
            System.out.println("a) Cargar de archivo");
            System.out.println("b) Agregar");
            System.out.println("c) Eliminar");
            System.out.println("d) Buscar");
            System.out.println("e) Mostrar");
            System.out.println("f) Salir");
            System.out.println("====================================");
            choice = scanner.next().charAt(0);
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 'a':
                    loadFromFile();
                    break;
                case 'b':
                    addEntry();
                    break;
                case 'c':
                    removeEntry();
                    break;
                case 'd':
                    findEntry();
                    break;
                case 'e':
                    listEntries();
                    break;
                case 'f':
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (choice != 'f');
    }

    /**
     * Carga las entradas del libro de direcciones desde un archivo especificado por el usuario.
     */
    private void loadFromFile() {
        System.out.print("Ingrese el nombre del archivo a cargar: ");
        String fileName = scanner.nextLine();
        addressBook.readFromFile(fileName);
        System.out.println("Entradas cargadas desde " + fileName);
    }

    /**
     * Solicita al usuario que ingrese los detalles de una nueva entrada y la agrega al libro de direcciones.
     */
    private void addEntry() {
        System.out.println("Agregar nuevo usuario:");
        System.out.print("Nombre: ");
        String firstName = scanner.nextLine();
        System.out.print("Apellido: ");
        String lastName = scanner.nextLine();
        System.out.print("Calle: ");
        String street = scanner.nextLine();
        System.out.print("Ciudad: ");
        String city = scanner.nextLine();
        System.out.print("Estado: ");
        String state = scanner.nextLine();
        System.out.print("Código Postal: ");
        String postalCode = scanner.nextLine();
        System.out.print("Correo Electrónico: ");
        String email = scanner.nextLine();
        System.out.print("Teléfono: ");
        String phone = scanner.nextLine();

        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, postalCode, email, phone);
        addressBook.add(entry);
        System.out.println("Usuario agregado.");
    }

    /**
     * Solicita al usuario que ingrese el apellido de la entrada a eliminar, muestra las coincidencias
     * y permite al usuario seleccionar cuál eliminar.
     */
    private void removeEntry() {
        System.out.print("Ingrese el apellido del usuario a eliminar: ");
        String lastName = scanner.nextLine();
        List<AddressEntry> entries = addressBook.find(lastName);

        if (entries.isEmpty()) {
            System.out.println("No se encontraron usuarios.");
        } else {
            for (int i = 0; i < entries.size(); i++) {
                System.out.println((i + 1) + ": " + entries.get(i));
            }
            System.out.print("Seleccione el número del usuario a eliminar: ");
            int index = scanner.nextInt() - 1;
            scanner.nextLine();

            if (index >= 0 && index < entries.size()) {
                addressBook.remove(entries.get(index));
                System.out.println("Usuario eliminado.");
            } else {
                System.out.println("Selección no válida.");
            }
        }
    }

    /**
     * Solicita al usuario que ingrese el apellido de la entrada a buscar y muestra las coincidencias.
     */
    private void findEntry() {
        System.out.print("Ingrese el apellido del usuario a buscar: ");
        String lastName = scanner.nextLine();
        List<AddressEntry> entries = addressBook.find(lastName);

        if (entries.isEmpty()) {
            System.out.println("No se encontro el usuario.");
        } else {
            for (AddressEntry entry : entries) {
                System.out.println(entry);
            }
        }
    }

    /**
     * Muestra todas las entradas del libro de direcciones en orden alfabético.
     */
    private void listEntries() {
        List<AddressEntry> entries = addressBook.find("");
        if (entries.isEmpty()) {
            addressBook.printContactsAlphabetically();
        } else {
            System.out.println("No hay usuarios en la libreta de direcciones.");
        }
    }
}
