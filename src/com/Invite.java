package com;
import java.util.UUID;
import java.net.SocketPermission;
import java.util.HashMap;
import java.util.List;

/**
 * Invite class responsible for handling the invite system. This module sends real-time 
 * updates to users, including RSVP confirmations (rsvp) and invitation to events.
 * THATS ALL IT DOES. WE DON'T MANAGE THE GUEST LIST THATS @RSVPMANAGER job. WE JUST SEND THE INVITE.
 */
public class Invite {
    private User guest;
    private String email;
    private int eventID;
    private String inviteID;
    private Event event;   // From Event class, should eventID come from event class? event.getEventID
    private String invitedUserID; // Does this mean every user gets an ID so we don't go by name. Do we randomize it?
    private inviteStatus status;

    // We will be using enumerated values as these valued will remain constant throughout the entire program
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

    public Invite(String eventID, User guest, User email) {
        this.eventID = event.getEventId();
        this.email = guest.getEmailAddress();
        this.guest = guest;
        // this.eventID = UUID.randomUUID().toString().substring(0, 8);
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

    public void setStatus(inviteStatus status) {
        this.status = status;
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

    public boolean sendInvite(int eventID, String invitedUserID) {
        Event e = event.getEventId(eventID);
        
        Invite newInvite = new Invite(eventID, invitedUserID);
        
    }

    public void inviteResponse() {

        if(getInviteStatus().equalsIgnoreCase("CONFIRMED")) {
            ArrayList<String> confirmed = new ArrayList<String>();
            confirmed.add(invitedUserID);

        }
        // if user selects confirm
        // accept = true;
        // add invitedUserID to rsvp manager list
        // else, accepts = false;

    }

    // For testing purposes
    public static void main(String[] args) {
        Event event = new Event();

        HashMap<Integer, List<String>> invitedUser = new HashMap<>();

        // we need an email attribute to send it to the user
        int eventID = event.getEventId();
        sendInvite(eventID, "Jane Doe", "janedoe@email.com");
        // Invite newInvite = new Invite(eventID, "Jane Doe", "janedoe@email.com");
        
    }
}