package ADDRESS_DATA;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AddressBookTest {
    private AddressBook addressBook;

    //Nombres y demas datos generados aleatoriamente
    @BeforeEach
    public void setUp() {
        addressBook = AddressBook.getInstance();
        addressBook.add(new AddressEntry("John", "Doe", "123 Main St", "Springfield", "IL", "62701", "john.doe@example.com", "555-1234"));
        addressBook.add(new AddressEntry("Jane", "Smith", "456 Elm St", "Shelbyville", "IL", "62702", "jane.smith@example.com", "555-5678"));
    }

    @Test
    public void testSingleton() {
        AddressBook anotherInstance = AddressBook.getInstance();
        assertSame(addressBook, anotherInstance, "Ambas instancias deben ser iguales.");
    }

    @Test
    public void testAdd() {
        AddressEntry entry = new AddressEntry("Alice", "Johnson", "789 Maple St", "Metropolis", "IL", "62703", "alice.johnson@example.com", "555-6789");
        addressBook.add(entry);

        List<AddressEntry> results = addressBook.find("Johnson");
        assertEquals(1, results.size(), "Debería haber una entrada con el apellido 'Johnson'");
        assertEquals(entry, results.get(0), "La entrada debe coincidir con la entrada agregada.");
    }

    @Test
    public void testRemove() {
        AddressEntry entry = new AddressEntry("Alice", "Johnson", "789 Maple St", "Metropolis", "IL", "62703", "alice.johnson@example.com", "555-6789");
        addressBook.add(entry);
        addressBook.remove(entry);

        List<AddressEntry> results = addressBook.find("Johnson");
        assertTrue(results.isEmpty(), "La entrada debe ser eliminada.");
    }

    @Test
    public void testFind() {
        List<AddressEntry> results = addressBook.find("Doe");
        assertEquals(1, results.size(), "Debería haber una entrada con el apellido 'Doe'");
        assertEquals("John", results.get(0).getFirstName(), "El primer nombre debería ser 'John'");
        assertEquals("Doe", results.get(0).getLastName(), "El apellido debería ser 'Doe'");
    }

    @Test
    public void testReadFromFile() {
        String fileName = "testAddressBook.txt";
        addressBook.readFromFile(fileName);
        assertEquals(2, addressBook.addressEntries.size());
        assertEquals("John", addressBook.addressEntries.get(0).getFirstName());
        assertEquals("Jane", addressBook.addressEntries.get(1).getFirstName());
    }

    @Test
    public void testPrintContactsAlphabetically() {
        AddressEntry entry1 = new AddressEntry("Charlie", "Brown", "123 Main St", "Anytown", "CA", "12345", "555-1234", "charlie@example.com");
        AddressEntry entry2 = new AddressEntry("Alice", "Anderson", "456 Elm St", "Othertown", "NY", "67890", "555-5678", "alice@example.com");
        addressBook.add(entry1);
        addressBook.add(entry2);
        addressBook.printContactsAlphabetically();

        assertEquals("Alice", addressBook.addressEntries.get(0).getFirstName());
        assertEquals("Charlie", addressBook.addressEntries.get(1).getFirstName());
    }
}
