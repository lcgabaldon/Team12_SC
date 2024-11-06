package com;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User userCreation = new User(69, "Joey", "", "Caproni", "joeycaproni420@gmail.com");

        // Create lists for events created and attended
        List<String> eventsCreated = new ArrayList<>();
        eventsCreated.add("Joey and Girlie");

        List<String> eventsAttended = new ArrayList<>();
        eventsAttended.add("Bachelor Party");

        // Set the events created and attended
        userCreation.setEventsCreated(eventsCreated);
        userCreation.setEventsAttended(eventsAttended);

        // Display user's ID:
        System.out.println("User ID: " + userCreation.getUserID());

        // Display user's full name:
        System.out.println("Full Name: " + userCreation.getFullName());

        // Display user's email:
        System.out.println("Email: " + userCreation.getEmailAddress());

        // Display user's created events:
        System.out.println("Event history: " + userCreation.getEventsCreated());

        // Display user's events attended:
        System.out.println("Events attended: " + userCreation.getEventsAttended());

        // Display all of user's details:
        System.out.println("User details: " + userCreation.toString());
    }
}