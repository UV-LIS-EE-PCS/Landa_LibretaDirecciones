package ADDRESS_DATA;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AddressEntryTest {

    @Test
    public void testAddressEntry() {
        AddressEntry entry = new AddressEntry("John", "Doe", "123 Main St", "Springfield", "IL", "62701", "john.doe@example.com", "555-1234");

        assertEquals("John", entry.getFirstName());
        assertEquals("Doe", entry.getLastName());
        assertEquals("123 Main St", entry.getStreet());
        assertEquals("Springfield", entry.getCity());
        assertEquals("IL", entry.getState());
        assertEquals("62701", entry.getPostalCode());
        assertEquals("john.doe@example.com", entry.getEmail());
        assertEquals("555-1234", entry.getPhone());
    }

    @Test
    public void testToString() {
        AddressEntry entry = new AddressEntry("John", "Doe", "123 Main St", "Springfield", "IL", "62701", "john.doe@example.com", "555-1234");

        String expected = "John Doe\n123 Main St\nSpringfield, IL 62701\njohn.doe@example.com\n555-1234";
        assertEquals(expected, entry.toString());
    }
}
