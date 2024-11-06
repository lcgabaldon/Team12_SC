package com;
import java.util.UUID;

import java.util.HashMap;
import java.util.List;

/**
 * Invite class responsible for handling the invite system. This module sends real-time 
 * updates to users, including RSVP confirmations (rsvp) and invitation to events.
 */
public class Invite {
    private User guest;
    private String email;
    private int eventID;
    private String inviteID;
    private Event event;
    private String invitedUserID;
    private inviteStatus status;

    // We will be using enumerated values as these values will remain constant throughout the entire program
    public enum inviteStatus {
        PENDING, CONFIRMED, DECLINED
    } 

    public Invite(Event event, User guest, User email, int eventID, String inviteID, String invitedUserID, inviteStatus status) {
        this.event = new Event();
        this.guest = new User();
        this.email = guest.getEmailAddress();
        // this.eventID = UUID.randomUUID().toString().substring(0, 8);
        this.eventID = event.getEventId();
        this.inviteID = setInviteID();
        this.invitedUserID = setInvitedUserID();
        this.status = inviteStatus.PENDING;
    }

    public Invite(int eventID, User guest, User email) {
        this.eventID = event.getEventId();
        this.guest = guest;
        this.email = guest.getEmailAddress();
        // this.eventID = UUID.randomUUID().toString().substring(0, 8);
    }

    public Invite() {
    }

    public boolean checkStatus(String stat) {
        return status.toString().equalsIgnoreCase(stat);
    }   

    /*
     * SETTERS
     */
    public String setInviteID() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public String setInvitedUserID() {
        return UUID.randomUUID().toString().substring(0, 10);
    }

    public inviteStatus setStatus(inviteStatus status) {
        return this.status = status;
    }

    /*
     * GETTERS
    */
    public String getInviteID() {
        return inviteID;
    }

    public int getEventId() {
        return event.getEventId();
    }

    public String getInvitedUserID() {
        return invitedUserID;
    }

    public inviteStatus getInviteStatus() {
        return status;
    }

    // Should we send and record the response in this same method?
    public inviteStatus sendInvite(int eventID, String invitedUserID) {
        status = inviteStatus.PENDING;
        return status;
    }

    public Invite inviteResponse(boolean response) {
        if(response == true) {
            status = setStatus(inviteStatus.CONFIRMED);  
            // add the guest to the list of attendees
        } else if(response == false) {
            status = setStatus(inviteStatus.DECLINED);
        }
        return this;
    }


    

    // For testing purposes
    public static void main(String[] args) {

        // We are mapping an eventID with confirmed attendees (this should be in the rsvp class)
        HashMap<Integer, List<String>> invitedUser = new HashMap<>();
        HashMap<String, String> nameIDPair = new HashMap<>(); // Hash map to assign name with userID

        Invite newInvite = new Invite();
        Event event = new Event(); // creating a new event instance
        User guest = new User();

        int eventID = event.getEventId(); // assigning the instance of a unique ID that was generated in the Event class
        String name = guest.getFullName(); // get the full name for the user being invited to the wedding
        String invitedUID = UUID.randomUUID().toString().substring(0, 10); // generate a userID for that user
        nameIDPair.put(name, invitedUID); // adding to the list to store the paired values
        String email = guest.getEmailAddress();
        
        newInvite.sendInvite(eventID, invitedUID);        
    }
}
