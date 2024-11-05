package src.test.java.com;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.com.User;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User user;

    @BeforeEach
    void setUp() {
        // Initialize a User object before each test
        user = new User(1, "John", "Michael", "Doe", "john.doe@example.com");
        user.setEventsCreated("Wedding Ceremony");
        user.setEventsAttended("Engagement Party");
    }

    @Test
    void testConstructor() {
        // Verify constructor initialization
        assertEquals(1, user.getUserID());
        assertEquals("John", user.getFirstName());
        assertEquals("Michael", user.getMiddleName());
        assertEquals("Doe", user.getLastName());
        assertEquals("john.doe@example.com", user.getEmailAddress());
    }

    @Test
    void testFullNameWithMiddleName() {
        // Verify full name construction when middle name is provided
        assertEquals("John Michael Doe", user.getFullName());
    }

    @Test
    void testFullNameWithoutMiddleName() {
        // Set middle name to null and verify full name construction
        user.setMiddleName(null);
        assertEquals("John Doe", user.getFullName());
    }

    @Test
    void testSettersAndGetters() {
        // Test setting and getting values
        user.setUserID(2);
        user.setFirstName("Jane");
        user.setMiddleName("Anne");
        user.setLastName("Smith");
        user.setEmailAddress("jane.smith@example.com");
        user.setEventsCreated("Bridal Shower");
        user.setEventsAttended("Bachelor Party");

        assertEquals(2, user.getUserID());
        assertEquals("Jane", user.getFirstName());
        assertEquals("Anne", user.getMiddleName());
        assertEquals("Smith", user.getLastName());
        assertEquals("jane.smith@example.com", user.getEmailAddress());
        assertEquals("Bridal Shower", user.getEventsCreated());
        assertEquals("Bachelor Party", user.getEventsAttended());
    }

    @Test
    void testToString() {
        // Verify the toString output includes important information
        String expectedOutput = "User{userID=1, fullName='John Michael Doe', emailAddress='john.doe@example.com', eventsCreated='Wedding Ceremony', eventsAttended='Engagement Party'}";
        assertEquals(expectedOutput, user.toString());
    }
}