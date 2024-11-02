package com;

public class user{
    private int userID; // userID.
    private String firstName; // user first name.
    private String middleName; // user middle name.
    private String lastName; // user last name.
    private String fullName = firstName + middleName + lastName; // user full name.
    private String emailAddress; 
    private String eventsCreated;
    private String eventsAttended;
}

/*
 * Variables: 
•	userId: Unique ID for the user. 
•	name: User’s full name. 
•	email: User’s email address. 
•	eventsCreated: List of event IDs the user has created. 
•	eventsAttended: List of event IDs the user has attended. 

Methods: 
•	create_event(event): Allows the user to create an event. 
•	attend_event(event): Adds the event to the user’s attended events list. 
•	cancel_attendance(event): Removes the event from the user’s attended events list. 
 * 
 */