package com;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Event {
    private String eventId;
    private String title;
    private String description;
    private String location;
    private LocalDateTime dateTime;
    private User createdBy;
    private int maxAttendees;
    private List<User> attendees = new ArrayList<>();
    private List<User> waitlist = new ArrayList<>();

    // Constructor
    public Event(String eventId, String title, String description, String location, LocalDateTime dateTime, User createdBy, int maxAttendees) {
        this.eventId = eventId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.dateTime = dateTime;
        this.createdBy = createdBy;
        this.maxAttendees = maxAttendees;
    }

    // Getters
    public String getEventId() {
        return eventId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
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
}