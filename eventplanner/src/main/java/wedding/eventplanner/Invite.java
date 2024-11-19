package wedding.eventplanner;

import java.util.UUID;

public class Invite {
    private Event event;
    private String inviteID;
    private String invitedUserID;
    private inviteStatus status;

    public enum inviteStatus {
        PENDING, CONFIRMED, DECLINED
    }

    // Simplified Constructor
    public Invite(Event event, String invitedUserID, inviteStatus status) {
        this.event = event;
        this.inviteID = UUID.randomUUID().toString().substring(0, 8); // Generate unique invite ID
        this.invitedUserID = invitedUserID;
        this.status = status;
    }

    // Method to check status
    public boolean checkStatus(String stat) {
        return status.toString().equalsIgnoreCase(stat);
    }

    // Getters and Setters
    public String getInviteID() {
        return inviteID;
    }

    public String getInvitedUserID() {
        return invitedUserID;
    }

    public inviteStatus getInviteStatus() {
        return status;
    }

    public void setStatus(inviteStatus status) {
        this.status = status;
    }

    // Method to retrieve the event ID associated with this invite
    public String getEventId() {
        return event.getId(); // Ensure getEventId is defined in Event and returns String
    }

    // Method to simulate sending an invite
    public boolean sendInvite() {
        System.out.println("Invite sent to user ID: " + invitedUserID + " for event ID: " + getEventId());
        return true; // Simulated return value
    }

    // Main method for testing
    public static void main(String[] args) {
        // Ensure Event and User constructors are defined to match these calls
        Event event = new Event();
        Invite invite = new Invite(event, "user456", inviteStatus.PENDING);

        invite.sendInvite();
        System.out.println("Invite ID: " + invite.getInviteID());
        System.out.println("Invite Status: " + invite.getInviteStatus());
    }
}