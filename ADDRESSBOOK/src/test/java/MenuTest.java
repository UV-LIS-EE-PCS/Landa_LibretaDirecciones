package ADDRESS;

import static org.junit.jupiter.api.Assertions.assertTrue;

import ADDRESS_DATA.AddressBook;
import ADDRESS_DATA.AddressEntry;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

public class MenuTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;
    private AddressBook addressBook;

    @BeforeEach
    public void setUp() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
        addressBook = AddressBook.getInstance();
        addressBook.add(new AddressEntry("John", "Doe", "123 Main St", "Springfield", "IL", "62701", "john.doe@example.com", "555-1234"));
        addressBook.add(new AddressEntry("Jane", "Smith", "456 Elm St", "Shelbyville", "IL", "62702", "jane.smith@example.com", "555-5678"));
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @Test
    public void testLoadFromFile() {
        provideInput("a\ntest_address_data.csv\nf\n");
        new Menu().displayMenu();
        String output = getOutput();
        assertTrue(output.contains("Entradas cargadas desde test_address_data.csv"));
    }

    @Test
    public void testAddEntry() {
        provideInput("b\nAlice\nJohnson\n789 Maple St\nMetropolis\nIL\n62703\nalice.johnson@example.com\n555-6789\nf\n");
        new Menu().displayMenu();
        List<AddressEntry> entries = addressBook.find("Johnson");
        assertTrue(entries.size() == 1);
        assertTrue(entries.get(0).getFirstName().equals("Alice"));
    }

    @Test
    public void testRemoveEntry() {
        provideInput("c\nDoe\n1\nf\n");
        new Menu().displayMenu();
        List<AddressEntry> entries = addressBook.find("Doe");
        assertTrue(entries.isEmpty());
    }

    @Test
    public void testFindEntry() {
        provideInput("d\nDoe\nf\n");
        new Menu().displayMenu();
        String output = getOutput();
        assertTrue(output.contains("John Doe"));
    }

    @Test
    public void testListEntries() {
        provideInput("e\nf\n");
        new Menu().displayMenu();
        String output = getOutput();
        assertTrue(output.contains("John Doe"));
        assertTrue(output.contains("Jane Smith"));
    }
}
