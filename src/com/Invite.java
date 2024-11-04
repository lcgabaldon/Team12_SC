

/**
 * Invite class responsible for handling the invite system. This module sends real-time 
 * updates to users, including RSVP confirmations (rsvp) and invitation to events.
 */
public class Invite {
    private String inviteID;
    private String eventID;
    private String invitedUserID; // does this mean every user gets an ID so we don't recognize by name? So we randomize it?
                                 // does this mean this class has to be connected to the wedding as w
    private boolean inviteStatus; // PENDING or CONFIRMED

    public Invite(String inviteID, String eventID, String invitedUserID, boolean inviteStatus) {
        this.inviteID = inviteID;
        this.eventID = eventID;
        this. invitedUserID = invitedUserID;
        this.inviteStatus = inviteStatus;
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

    
}