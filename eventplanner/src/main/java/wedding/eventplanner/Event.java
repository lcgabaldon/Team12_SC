package wedding.eventplanner;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private String id;
    private String name;
    private String description;
    private String location;
    private String dateTime;
    private User createdBy;
    private int maxAttendees;
    private List<User> attendees = new ArrayList<>();
    private List<User> waitlist = new ArrayList<>();

    // Default constructor
    public Event() {
    }

    // Constructor
    public Event(String id, String name, String description, String location, String dateTime,
            User createdBy, int maxAttendees) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.dateTime = dateTime;
        this.createdBy = createdBy;
        this.maxAttendees = maxAttendees;
    }

    // Getters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    // Method to add an attendee if there's room
    public boolean addAttendee(User user) {
        if (attendees.size() < maxAttendees) {
            attendees.add(user);
            return true;
        }
        return false;
    }

    // Method to add a user to the waitlist
    public void moveToWaitlist(User user) {
        waitlist.add(user);
    }

    // Get the list of users on the waitlist
    public List<User> getWaitlist() {
        return waitlist;
    }

    // Notify attendees (sample implementation)
    public void notifyUsers() {
        for (User user : attendees) {
            System.out.println("Notification sent to: " + user.getFullName());
        }
    }

    // Optional: Override toString for easy debugging
    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", date & time='" + dateTime + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
