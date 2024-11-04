import java.util.*;

/**
 * Invite class responsible for handling the invite system. This module sends real-time 
 * updates to users, including RSVP confirmations (rsvp) and invitation to events.
 * THATS ALL IT DOES. WE DONT MANAGE THE WAITLIST THATS @RSVPMANAGER job. WE JUST SEND THE INVITE.
 */
public class Invite {
    private String inviteID;
    private String eventID;
    private EventPlanner event; // ^^^ From Event class, should eventID come from event class? event.getEventID

    private String invitedUserID; // Does this mean every user gets an ID so we don't recognize by name. Do we randomize it?
                                  // does this mean this class has to be connected to the wedding and
    private boolean inviteStatus; // PENDING or CONFIRMED

    public Invite(String inviteID, String eventID, String invitedUserID, boolean inviteStatus) {
        this.inviteID = inviteID;
        this.eventID = eventID; // = Event.eventId();
        this.inviteStatus = inviteStatus;

        // sendInvite(eventId, inviteeList): This is from the User class. Sends invitations to invitees. 
    }

    public String getInviteID() {
        return inviteID;
    }

    public String getEventID() {
        return inviteID;
    }

    public String getInvitedUserID() {
        return invitedUserID;
    }

    public boolean getInviteStatus() {
        return inviteStatus;
    }

    public String generateInvitedUserID() { // this as an attribute instead?
        return invitedUserID = UUID.randomUUID().toString().substring(0, 10);
    }

    public boolean sendInvite(String eventID, String invitedUserID) { // or 

    }

    public void inviteResponse() {
        // if user selects confirm
        // accept = true;
        // add invitedUserID to rsvp manager list
        // else, accepts = false;

    }
}