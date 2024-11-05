package com;
import java.util.UUID;
import java.util.ArrayList;

/**
 * Invite class responsible for handling the invite system. This module sends real-time 
 * updates to users, including RSVP confirmations (rsvp) and invitation to events.
 * THATS ALL IT DOES. WE DON'T MANAGE THE GUEST LIST THATS @RSVPMANAGER job. WE JUST SEND THE INVITE.
 */
public class Invite {
    private user guest;
    private String eventID;
    private String inviteID;
    private EventPlanner events;   // From Event class, should eventID come from event class? event.getEventID
    private String invitedUserID; // Does this mean every user gets an ID so we don't go by name. Do we randomize it?
    private inviteStatus status;

    // We will be using enumerated values as these valued will remain constant throughout the entire program
    public enum inviteStatus {
        PENDING, CONFIRMED, DECLINED
    } 

    public Invite(user guest, String eventID, String inviteID, EventPlanner event, String invitedUserID, inviteStatus status) {
        this.guest = guest;
        this.eventID = UUID.randomUUID().toString().substring(0, 8); // EventPlanner.getEventId(); EventPlanner should have a getEventID class
        this.inviteID = setInviteID();
        this.events = event;
        this.invitedUserID = setInvitedUserID();
        this.status = inviteStatus.PENDING;
    }

    public Invite(user guest, String eventID) {
        this.guest = guest;
        this.eventID = UUID.randomUUID().toString().substring(0, 8);
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

    public String getEventID() {
        return eventID;
    }

    public String getInvitedUserID() {
        return invitedUserID;
    }

    public inviteStatus getInviteStatus() {
        return status;
    }

    public boolean sendInvite(String eventID, String invitedUserID) {
        EventPlanner event = getEventID(eventID);
        Invite newInvite = new Invite(guest, eventID, status.PENDING)
        
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

    // Sample usage
    public static void main(String[] args) {

        // we need an email attr to send it to the user
        Invite newInvite = new Invite();
        
    }
}