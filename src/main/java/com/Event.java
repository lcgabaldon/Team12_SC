package com;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

public class Event {
    private int eventId;
    private String title;
    private String description;
    private String location;
    private String dateTime;
    private String createdBy;
    private int maxAttendees;
    private List<User> attendees;
    private Queue<User> waitlist;
    private Boolean isPublic;

    public Event(int eventId, String title, String description, String location, String dateTime, String createdBy, int maxAttendees, Boolean isPublic) {
        this.eventId = eventId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.dateTime = dateTime;
        this.createdBy = createdBy;
        this.maxAttendees = maxAttendees;
        this.attendees = new ArrayList<>();
        this.waitlist = new LinkedList<>();
        this.isPublic = isPublic;
    }

    public Event() {
        this.attendees = new ArrayList<>();
        this.waitlist = new LinkedList<>();
    }

    public int getEventId() {
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

    public String getDateTime() {
        return dateTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public int getMaxAttendees() {
        return maxAttendees;
    }

    public List<User> getAttendees() {
        return attendees;
    }

    public Queue<User> getWaitlist() {
        return waitlist;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }

    public void displayEventDetails() {
        System.out.println("Event Details:");
        System.out.println("Event ID: " + eventId);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Location: " + location);
        System.out.println("Date and Time: " + dateTime);
        System.out.println("Created by: " + createdBy);
        System.out.println("Max attendees: " + maxAttendees);
        System.out.println("Current attendees: " + attendees);
        System.out.println("Waitlist: " + waitlist.size());
        System.out.println("Public: " + isPublic);
    }

    public void addAttendee(User user) {
        if (attendees.size() < maxAttendees) {
            attendees.add(user);
            System.out.println("User added to attendees list.");
        } else {
            moveToWaitlist(user);
        }
    }

    public void removeAttendee(User user) {
        if (attendees.contains(user)) {
            attendees.remove(user);
            System.out.println("User removed from list of attendees.");
            if (!waitlist.isEmpty()) {
                attendees.add(waitlist.poll());
                System.out.println("User from waitlist added to attendees.");
            }
        } else if (waitlist.contains(user)) {
            waitlist.remove(user);
            System.out.println("User removed from waitlist.");
        }
    }

    public void notifyUsers() {
        for (User attendee : attendees) {
            attendee.notify(); // Ensure User class has a notify method
        }
    }

    public void moveToWaitlist(User user) {
        waitlist.add(user);
        System.out.println("User added to the waitlist.");
    }
}