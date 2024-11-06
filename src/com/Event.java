package com;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

public class Event{
    private int eventId;
    private String title;
    private String description;
    private String location;
    private String dateTime;
    private String createdBy;
    private int maxAttendees; 
    private List<com.User> attendees;
    // private Queue<Integer> waitlist;
    private Boolean isPublic;

    // private String couple; //Should we include the couple in the event information?
    

    public Event(int eventId, String title, String description, String location, String dateTime, String createdBy, int maxAttendees, int attendees, Boolean isPublic){ 
        this.eventId = eventId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.dateTime = dateTime;
        this.createdBy = createdBy;
        this.maxAttendees = maxAttendees;
        this.attendees = new ArrayList<>();
        // this.waitlist= new LinkedList<>();
        this.isPublic = isPublic;
    }

    public Event() { // Itzel added this empty constructor
    }

    public int getEventId(){
        return eventId;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public String getLocation(){
        return location;
    }

    public String getDateTime(){
        return dateTime;
    }

    public String getCreatedBy(){
        return createdBy;
    }

    public int getMaxAttendees(){
        return maxAttendees;
    }

    public List<User> getAttendees(){
        return attendees;
    }

    // public Queue<Integer> getWaitlist(){
    //     return waitlist;
    // }

    public Boolean getIsPublic(){
        return isPublic;
    }

    public void displayEventDetails(){
        System.out.println("Event Details:");
        System.out.println("Event ID:" + eventId);
        System.out.println("Title:" + title);
        System.out.println("Description: " + description);
        System.out.println("Location: " + location);
        System.out.println("Date and Time:" + dateTime);
        System.out.println("Created by: " + createdBy);
        System.out.println("Max attendees: " + maxAttendees);
        System.out.println("Current attendees: " + attendees);
        // System.out.println("Waitlist: " + waitlist.size());
        System.out.println("Public: " + isPublic);

    }

    // Method to add a user to the attendees list
    // Adds a user to the attendees list if space is available. 
    public void add_attendee(User user){
        if (attendees.size() < maxAttendees){
            attendees.add(user);
        }
        System.out.println("Max attendee count reached");


    }

    // Removes a user from the attendees or the waitlist. 
    public void remove_attendee(User user){
        if (attendees.contains(user)){
            attendees.remove(user);
            System.out.println("User removed from list of attendees.");
        }
        // if (waitlist.contains(user)){
        //     waitlist.remove(user);
        //     System.out.println("User removed from waitlist");
        // }
    }

    // Sends notifications to attendees about event updates. 
    public void notify_users(){
        for (User attendee : attendees){
            attendee.notify();
        }

    }

    // Adds a user to the waitlist if the event is full. 
    // public void move_to_waitlist(User user){
    //     if (attendees.size() == maxAttendees){
    //         waitlist.add(user);
    //         System.out.println("User added to the waitlist.");
    //     }

    // }

}