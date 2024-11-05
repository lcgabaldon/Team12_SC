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
        user = new User(69, "Joey", "Adams", "Caproni", "joeycaproni420@gmail.com");
        user.setEventsCreated("Joey and Girlie");
        user.setEventsAttended("Bachelor Party");
    }

    @Test
    void testConstructor() {
        // Verify constructor initialization
        assertEquals(69, user.getUserID());
        assertEquals("Joey", user.getFirstName());
        assertEquals("Adams", user.getMiddleName());
        assertEquals("Caproni", user.getLastName());
        assertEquals("joeycaproni420@gmail.com", user.getEmailAddress());
    }

    @Test
    void testFullNameWithMiddleName() {
        // Verify full name construction when middle name is provided
        assertEquals("Joey Adams Caproni", user.getFullName());
    }

    @Test
    void testFullNameWithoutMiddleName() {
        // Set middle name to null and verify full name construction
        user.setMiddleName(null);
        assertEquals("Joey Caproni", user.getFullName());
    }

    @Test
    void testSettersAndGetters() {
        // Test setting and getting values
        user.setUserID(69);
        user.setFirstName("Joey");
        user.setMiddleName("Adams");
        user.setLastName("Caproni");
        user.setEmailAddress("joeycaproni420@gmail.com");
        user.setEventsCreated("Joey and Girlie");
        user.setEventsAttended("Bachelor Party");

        assertEquals(69, user.getUserID());
        assertEquals("Joey", user.getFirstName());
        assertEquals("Adams", user.getMiddleName());
        assertEquals("Caproni", user.getLastName());
        assertEquals("joeycaproni420@gmail.com", user.getEmailAddress());
        assertEquals("Joey and Girlie", user.getEventsCreated());
        assertEquals("Bachelor Party", user.getEventsAttended());
    }

    @Test
    void testToString() {
        // Verify the toString output includes important information
        String expectedOutput = "User{userID=69, fullName='Joey Adams Caproni', emailAddress='joeycaproni420@gmail.com', eventsCreated='Joey and Girlie', eventsAttended='Bachelor Party'}";
        assertEquals(expectedOutput, user.toString());
    }
}