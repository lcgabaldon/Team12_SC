package com;
import java.util.UUID;

public class Invite {
    private Event event;
    private String inviteID;
    private String invitedUserID;
    private inviteStatus status;

    public enum inviteStatus {
        PENDING, CONFIRMED, DECLINED
    }

    public Invite(Event event, User guest, String email, int eventID, String inviteID, String invitedUserID, inviteStatus status) {
        this.event = event;
        this.inviteID = inviteID;
        this.invitedUserID = invitedUserID;
        this.status = status;
    }

    public boolean checkStatus(String stat) {
        return status.toString().equalsIgnoreCase(stat);
    }

    public String setInviteID() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public String setInvitedUserID() {
        return UUID.randomUUID().toString().substring(0, 10);
    }

    public void setStatus(inviteStatus status) {
        this.status = status;
    }

    public String getInviteID() {
        return inviteID;
    }

    public int getEventId() {
        return event.getEventId(); // Ensure getEventId is defined in Event class
    }

    public String getInvitedUserID() {
        return invitedUserID;
    }

    public inviteStatus getInviteStatus() {
        return status;
    }

    public boolean sendInvite(int eventID, String invitedUserID) {
        return true; // Return true or false based on send status
    }

    public static void main(String[] args) {
        Event event = new Event();
        Invite invite = new Invite(event, new User(), "janedoe@email.com", 123, "invite123", "user456", inviteStatus.PENDING);
        invite.sendInvite(invite.getEventId(), invite.getInvitedUserID());
    }
}