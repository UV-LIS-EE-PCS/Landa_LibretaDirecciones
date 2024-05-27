package ADDRESS;

import java.util.List;
import java.util.Scanner;
import ADDRESS_DATA.AddressBook;
import ADDRESS_DATA.AddressEntry;

public class Menu {
    private AddressBook addressBook;
    private Scanner scanner;

    public Menu() {
        addressBook = AddressBook.getInstance();
        scanner = new Scanner(System.in);
    }

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

    private void loadFromFile() {
        System.out.print("Ingrese el nombre del archivo a cargar: ");
        String fileName = scanner.nextLine();
        addressBook.readFromFile(fileName);
        System.out.println("Entradas cargadas desde " + fileName);
    }

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

    private void removeEntry() {
        System.out.print("Ingrese el nombre del usuario a eliminar: ");
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

    private void listEntries() {
        List<AddressEntry> entries = addressBook.listAlphabetically();
        for (AddressEntry entry : entries) {
            System.out.println(entry);
        }
    }
}