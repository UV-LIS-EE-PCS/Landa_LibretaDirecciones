package ADDRESS_DATA;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class AddressEntryTest {

    private AddressEntry addressEntry;

    @BeforeEach
    public void setUp() {
        addressEntry = new AddressEntry("John", "Doe", "123 Main St", "Springfield", "IL", "12345", "john.doe@example.com", "555-123-4567");
    }

    @Test
    public void testConstructorAndGetters() {
        assertThat(addressEntry.getFirstName()).isEqualTo("John");
        assertThat(addressEntry.getLastName()).isEqualTo("Doe");
        assertThat(addressEntry.getStreet()).isEqualTo("123 Main St");
        assertThat(addressEntry.getCity()).isEqualTo("Springfield");
        assertThat(addressEntry.getState()).isEqualTo("IL");
        assertThat(addressEntry.getPostalCode()).isEqualTo("12345");
        assertThat(addressEntry.getEmail()).isEqualTo("john.doe@example.com");
        assertThat(addressEntry.getPhone()).isEqualTo("555-123-4567");
    }

    @Test
    public void testSetters() {
        addressEntry.setFirstName("Jane");
        addressEntry.setLastName("Smith");
        addressEntry.setStreet("456 Oak Ave");
        addressEntry.setCity("Anytown");
        addressEntry.setState("NY");
        addressEntry.setPostalCode("54321");
        addressEntry.setEmail("jane.smith@example.com");
        addressEntry.setPhone("555-987-6543");

        assertThat(addressEntry.getFirstName()).isEqualTo("Jane");
        assertThat(addressEntry.getLastName()).isEqualTo("Smith");
        assertThat(addressEntry.getStreet()).isEqualTo("456 Oak Ave");
        assertThat(addressEntry.getCity()).isEqualTo("Anytown");
        assertThat(addressEntry.getState()).isEqualTo("NY");
        assertThat(addressEntry.getPostalCode()).isEqualTo("54321");
        assertThat(addressEntry.getEmail()).isEqualTo("jane.smith@example.com");
        assertThat(addressEntry.getPhone()).isEqualTo("555-987-6543");
    }

    @Test
    public void testToString() {
        String expected = "John Doe, 123 Main St, Springfield, IL, 12345, 555-123-4567, john.doe@example.com";
        assertThat(addressEntry.toString()).isEqualTo(expected);
    }
}
