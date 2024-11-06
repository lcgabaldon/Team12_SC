package com;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RSVPTest {
    
    private RSVP rsvp;

    @BeforeEach
    public void setUp() {
        // Initialize the RSVP object with sample data before each test
        rsvp = new RSVP("1", "user123", "event456", "pending", System.currentTimeMillis());
    }

    @Test
    public void testAcceptRSVP() {
        rsvp.acceptRSVP();
        assertEquals("attending", rsvp.getStatus(), "The status should be 'attending' after accepting the RSVP.");
    }

    @Test
    public void testDeclineRSVP() {
        rsvp.declineRSVP();
        assertEquals("not attending", rsvp.getStatus(), "The status should be 'not attending' after declining the RSVP.");
    }

    @Test
    public void testAddToWaitlist() {
        rsvp.addToWaitlist();
        assertEquals("waitlisted", rsvp.getStatus(), "The status should be 'waitlisted' after adding to the waitlist.");
    }

    @Test
    public void testGetters() {
        assertEquals("1", rsvp.getRsvpId(), "The RSVP ID should be '1'.");
        assertEquals("user123", rsvp.getUserId(), "The user ID should be 'user123'.");
        assertEquals("event456", rsvp.getEventId(), "The event ID should be 'event456'.");
        assertEquals("pending", rsvp.getStatus(), "The initial status should be 'pending'.");
    }

    @Test
    public void testSetters() {
        rsvp.setRsvpId("2");
        rsvp.setUserId("user789");
        rsvp.setEventId("event101112");
        rsvp.setStatus("attending");
        rsvp.setTimestamp(1234567890L);

        assertEquals("2", rsvp.getRsvpId(), "The RSVP ID should be updated to '2'.");
        assertEquals("user789", rsvp.getUserId(), "The user ID should be updated to 'user789'.");
        assertEquals("event101112", rsvp.getEventId(), "The event ID should be updated to 'event101112'.");
        assertEquals("attending", rsvp.getStatus(), "The status should be updated to 'attending'.");
        assertEquals(1234567890L, rsvp.getTimestamp(), "The timestamp should be updated to '1234567890'.");
    }

    @Test
    public void testToString() {
        String expected = "RSVP{rsvpId='1', userId='user123', eventId='event456', status='pending', timestamp=" + rsvp.getTimestamp() + "}";
        assertEquals(expected, rsvp.toString(), "The toString method should return the correct string representation of the RSVP.");
    }
}