package com;
public class RSVPManager {

    /**
     * Processes an RSVP request. Adds the user to attendees if space is available,
     * otherwise adds them to the waitlist.
     *
     * @param wedding The wedding instance.
     * @param userId The ID of the user.
     * @return A message indicating the result of the RSVP.
     */
    public String rsvpToEvent(Wedding wedding, int userId) {
        if (wedding.getAttendeeCount() < wedding.getMaxCapacity()) {
            wedding.getAttendees().add(userId);
            return "RSVP confirmed for user " + userId;
        } else {
            addToWaitlist(wedding, userId);
            return "Event is full. User " + userId + " has been added to the waitlist.";
        }
    }

    /**
     * Adds a user to the waitlist if the wedding is full.
     *
     * @param wedding The wedding instance.
     * @param userId The ID of the user.
     */
    public void addToWaitlist(Wedding wedding, int userId) {
        if (!wedding.getWaitlist().contains(userId)) {
            wedding.getWaitlist().add(userId);
            System.out.println("User " + userId + " has been added to the waitlist.");
        }
    }

    /**
     * Moves the next user from the waitlist to the attendees if space opens up.
     *
     * @param wedding The wedding instance.
     * @return A message indicating the result of the waitlist management.
     */
    public String processWaitlist(Wedding wedding) {
        if (!wedding.getWaitlist().isEmpty() && wedding.getAttendeeCount() < wedding.getMaxCapacity()) {
            int nextUser = wedding.getWaitlist().poll();
            wedding.getAttendees().add(nextUser);
            return "User " + nextUser + " has been moved from the waitlist to the attendee list.";
        }
        return "No available spots or waitlist is empty.";
    }
}
