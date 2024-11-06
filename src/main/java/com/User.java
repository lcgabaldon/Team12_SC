package com;

import java.util.ArrayList;
import java.util.List;

public class User {
    // Variables
    private int userID;
    private String firstName;
    private String middleName;
    private String lastName;
    private String emailAddress;
    private List<String> eventsCreated;
    private List<String> eventsAttended;

    // Default Constructor
    public User() {
        this.userID = 0;
        this.firstName = "";
        this.middleName = "";
        this.lastName = "";
        this.emailAddress = "";
        this.eventsCreated = new ArrayList<>();
        this.eventsAttended = new ArrayList<>();
    }

    // Original Constructor
    public User(int userID, String firstName, String middleName, String lastName, String emailAddress) {
        this.userID = userID;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.eventsCreated = new ArrayList<>();
        this.eventsAttended = new ArrayList<>();
    }

    // New Constructor for String ID, name, and email (as used in EventPlanner)
    public User(String userId, String name, String email) {
        this.userID = Integer.parseInt(userId.replace("U", "")); // Example conversion from String to int
        this.firstName = name;
        this.emailAddress = email;
        this.eventsCreated = new ArrayList<>();
        this.eventsAttended = new ArrayList<>();
    }

    // Getters and Setters
    public int getUserID() {
        return userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public List<String> getEventsCreated() {
        return eventsCreated;
    }

    public void setEventsCreated(List<String> eventsCreated) {
        this.eventsCreated = eventsCreated;
    }

    public List<String> getEventsAttended() {
        return eventsAttended;
    }

    public void setEventsAttended(List<String> eventsAttended) {
        this.eventsAttended = eventsAttended;
    }

    // Method to add an event to eventsCreated
    public void addCreatedEvent(String eventId) {
        eventsCreated.add(eventId);
    }

    // Method to add an event to eventsAttended
    public void addAttendedEvent(String eventId) {
        eventsAttended.add(eventId);
    }

    // Method to return the full name
    public String getFullName() {
        if (middleName == null || middleName.isEmpty()) {
            return firstName + " " + lastName;
        } else {
            return firstName + " " + middleName + " " + lastName;
        }
    }
}