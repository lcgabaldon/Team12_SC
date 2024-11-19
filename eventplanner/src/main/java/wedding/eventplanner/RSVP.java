package wedding.eventplanner;

public class RSVP {
    // Identifier
    private String rsvpId;
    // User ID using the RSVP
    private String userId;
    // Id of the event which they are RSVPing to
    private String eventId;
    // Status of RSVP
    private String status;
    // timestamp
    private long timestamp;

    // Constructor
    public RSVP(String rsvpId, String userId, String eventId, String status, long timestamp) {
        this.rsvpId = rsvpId;
        this.userId = userId;
        this.eventId = eventId;
        this.status = status;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public String getRsvpId() {
        return rsvpId;
    }

    public void setRsvpId(String rsvpId) {
        this.rsvpId = rsvpId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    // Accepts the RSVP by setting the status to "attending"
    public void acceptRSVP() {
        this.status = "attending";
        System.out.println("RSVP accepted for user " + userId + " to event " + eventId);
    }

    // Declines the RSVP by setting the status to "not attending"
    public void declineRSVP() {
        this.status = "not attending";
        System.out.println("RSVP declined for user " + userId + " to event " + eventId);
    }

    // Adds the user to the waitlist
    public void addToWaitlist() {
        this.status = "waitlisted";
        System.out.println("User " + userId + " added to the waitlist for event " + eventId);
    }
}