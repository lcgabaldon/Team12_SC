package com;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.EventPlanner;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EventPlannerTest {
    private EventPlanner eventPlanner;
    private User user1;
    private User user2;

    @BeforeEach
    public void setUp() {
        eventPlanner = new EventPlanner();
        user1 = new User("U1", "John Doe", "john.doe@example.com");
        user2 = new User("U2", "Jane Smith", "jane.smith@example.com");

        eventPlanner.createUser("John Doe", "john.doe@example.com");
        eventPlanner.createUser("Jane Smith", "jane.smith@example.com");
    }

    @Test
    public void testCreateUserAddsUserToList() {
        List<User> users = eventPlanner.getUsers(); // Assuming you have a getter for users
        assertEquals(2, users.size());
        assertEquals("John Doe", users.get(0).getName());
        assertEquals("Jane Smith", users.get(1).getName());
    }

    @Test
    public void testCreateEventAddsEventToList() {
        LocalDateTime dateTime = LocalDateTime.of(2024, 12, 15, 15, 30);
        eventPlanner.createEvent(user1, "Wedding Celebration", "A grand wedding event", "Central Park", dateTime, 100);

        List<Event> events = eventPlanner.getEvents(); // Assuming you have a getter for events
        assertEquals(1, events.size());
        assertEquals("Wedding Celebration", events.get(0).getTitle());
    }

    @Test
    public void testGetEventById() {
        LocalDateTime dateTime = LocalDateTime.of(2024, 12, 15, 15, 30);
        eventPlanner.createEvent(user1, "Wedding Celebration", "A grand wedding event", "Central Park", dateTime, 100);
        Event event = eventPlanner.getEvent("E1");

        assertNotNull(event);
        assertEquals("E1", event.getEventId());
        assertEquals("Wedding Celebration", event.getTitle());
    }

    @Test
    public void testRSVPUserToEvent() {
        LocalDateTime dateTime = LocalDateTime.of(2024, 12, 15, 15, 30);
        eventPlanner.createEvent(user1, "Wedding Celebration", "A grand wedding event", "Central Park", dateTime, 1);
        Event event = eventPlanner.getEvent("E1");

        eventPlanner.rsvpToEvent(user2, event);
        List<User> attendees = eventPlanner.getAttendeesForEvent("E1");

        assertEquals(1, attendees.size());
        assertTrue(attendees.contains(user2));
    }

    @Test
    public void testGetWaitlistForFullEvent() {
        LocalDateTime dateTime = LocalDateTime.of(2024, 12, 15, 15, 30);
        eventPlanner.createEvent(user1, "Small Party", "An exclusive event", "Private Venue", dateTime, 1);
        Event event = eventPlanner.getEvent("E1");

        eventPlanner.rsvpToEvent(user2, event);
        User user3 = new User("U3", "Mark Lee", "mark.lee@example.com");
        eventPlanner.rsvpToEvent(user3, event);

        List<User> waitlist = eventPlanner.getWaitlistForEvent("E1");

        assertEquals(1, waitlist.size());
        assertEquals("Mark Lee", waitlist.get(0).getName());
    }
}
