package wedding.eventplanner;

import java.util.ArrayList;
import java.util.List;

public class EventPlanner {
    private List<User> users;
    private List<Event> events;

    public EventPlanner() {
        this.users = new ArrayList<>();
        this.events = new ArrayList<>();
    }

    // Method to create a new user
    public void createUser(String name, String email) {
        String userId = "user" + (users.size() + 1); // Example unique ID generation logic
        User newUser = new User(userId, name, email); // Adjusted to match the new User constructor
        users.add(newUser);
        System.out.println("User created: " + name);
    }

    // Method to create a new event
    public void createEvent(User user, String title, String description, String location, String dateTime,
            int maxAttendees) {
        String eventId = "ev" + (events.size() + 1); // Generate a unique event ID
        Event newEvent = new Event();
        newEvent.setId(eventId); // Set the event ID
        newEvent.setName(title); // Set the event title (name)
        newEvent.setDescription(description); // Set the event description
        newEvent.setLocation(location); // Set the event location
        newEvent.setDateTime(dateTime); // Set the event date (convert LocalDateTime to String if needed)
        events.add(newEvent); // Add the new event to the list
        user.addCreatedEvent(eventId); // Associate the event with the user
        System.out.println("Event created: " + title);
    }

    // Method to retrieve an event by its ID
    public Event getEvent(String eventId) {
        for (Event event : events) {
            if (event.getId().equals(eventId)) {
                return event;
            }
        }
        System.out.println("Event not found: " + eventId);
        return null;
    }

    public List<User> getAttendeesForEvent(String eventId) {
        List<User> attendees = new ArrayList<>();
        for (User user : users) {
            if (user.getEventsAttended().contains(eventId)) {
                attendees.add(user);
            }
        }
        return attendees;
    }

    // Method to RSVP a user to an event
    public void rsvpToEvent(User user, Event event) {
        if (event.addAttendee(user)) {
            user.addAttendedEvent(event.getId());
            System.out.println("RSVP successful for: " + user.getFullName());
        } else {
            event.moveToWaitlist(user);
            System.out.println("Event full. User added to waitlist: " + user.getFullName());
        }
    }

    // Method to get the waitlist for an event
    public List<User> getWaitlistForEvent(String eventId) {
        Event event = getEvent(eventId);
        if (event != null) {
            return event.getWaitlist();
        }
        return new ArrayList<>();
    }

    // Method to send notifications to attendees
    public void sendEventNotifications(String eventId) {
        Event event = getEvent(eventId);
        if (event != null) {
            event.notifyUsers();
            System.out.println("Notifications sent for event: " + event.getName());
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        EventPlanner planner = new EventPlanner();
        planner.createUser("John Doe", "john.doe@example.com");
        planner.createUser("Jane Smith", "jane.smith@example.com");

        User user1 = planner.users.get(0);
        User user2 = planner.users.get(1);

        planner.createEvent(user1, "Wedding Celebration", "A grand wedding event", "Central Park",
                "2024/12/15T15:30", 100);
        Event event1 = planner.events.get(0);

        planner.rsvpToEvent(user2, event1);
        planner.sendEventNotifications(event1.getId());
    }
}
