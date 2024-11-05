// Class Name: EventPage (SOFIA)

// Responsibilities:
// Display a list of all upcoming public events.
// Provide details about events (location, time, attendee count, etc).

// Collaborators:
// EventManager (to fetch event data).
// Contracts:
// showPublicEvents(): Displays a list of all public events.
// showEventDetails(eventId): Displays detailed information about a specific event.

import java.util.LinkedList;
import java.util.Queue;

public class Event{
    private int eventId;
    private String title;
    private String description;
    private String location;
    private String dateTime;
    private String createdBy;
    private int maxAttendees; 
    private int attendees;
    private Queue<Integer> waitlist;
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
        this.attendees = attendees;
        this.waitlist= new LinkedList<>();
        this.isPublic = isPublic;
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

    public getAttendees(){
        return attendees;
    }

    public Queue<Integer> getWaitlist(){
        return waitlist;
    }

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
        System.out.println("Waitlist: " + waitlist.size());
        System.out.println("Public: " + isPublic);

    }

    // public void add_attendee(user, attendees){


    // }

//     add_attendee(user): Adds a user to the attendees list if space is available. 

// 	remove_attendee(user): Removes a user from the attendees or the waitlist. 

// 	notify_users(): Sends notifications to attendees about event updates. 

// 	move_to_waitlist(user): Adds a user to the waitlist if the event is full. 




}