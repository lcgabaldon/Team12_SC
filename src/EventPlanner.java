import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class EventPlanner {
    private List<User> users;
    private List<Event> events;

    public EventPlanner() {
        this.users = new ArrayList<>(); //we need users to be able to create events, create user class
        this.events = new ArrayList<>(); //we need events to be able to RSVP users, create event class
    }

    // Method to create a new user
    public void createUser(String name, String email) {
        String userId = "U" + (users.size() + 1); // Example unique ID generation logic
        User newUser = new User(userId, name, email);
        users.add(newUser);
        System.out.println("User created: " + name);
    }

    // Method to create a new event
    public void createEvent(User user, String title, String description, String location, LocalDateTime dateTime, int maxAttendees) {
        String eventId = "E" + (events.size() + 1); // Example unique ID generation logic
        Event newEvent = new Event(eventId, title, description, location, dateTime, user, maxAttendees);
        events.add(newEvent);
        user.addCreatedEvent(eventId);
        System.out.println("Event created: " + title);
    }

    // Method to retrieve an event by its ID
    public Event getEvent(String eventId) {
        for (Event event : events) {
            if (event.getEventId().equals(eventId)) {
                return event;
            }
        }
        System.out.println("Event not found: " + eventId);
        return null;
    }

    // Method to RSVP a user to an event
    public void rsvpToEvent(User user, Event event) {
        if (event.addAttendee(user)) {
            user.addAttendedEvent(event.getEventId());
            System.out.println("RSVP successful for: " + user.getName());
        } else {
            event.moveToWaitlist(user);
            System.out.println("Event full. User added to waitlist: " + user.getName());
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
            System.out.println("Notifications sent for event: " + event.getTitle());
        }
    }

    // Main method for testing (optional)
    public static void main(String[] args) {
        EventPlanner planner = new EventPlanner();
        planner.createUser("John Doe", "john.doe@example.com");
        planner.createUser("Jane Smith", "jane.smith@example.com");

        User user1 = planner.users.get(0);
        User user2 = planner.users.get(1);

        planner.createEvent(user1, "Wedding Celebration", "A grand wedding event", "Central Park", LocalDateTime.of(2024, 12, 15, 15, 30), 100);
        Event event1 = planner.events.get(0);

        planner.rsvpToEvent(user2, event1);
        planner.sendEventNotifications(event1.getEventId());
    }
}
