package wedding.eventplanner;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Wedding {
    private String couple;
    private String weddingDate;
    private String location;
    private Registry registry;
    private HashSet<Integer> attendees; // Store attendee user IDs
    private Queue<Integer> waitlist; // Store waitlisted user IDs
    private final int maxCapacity; // Max number of attendees allowed

    public Wedding(String couple, String weddingDate, String location, int maxCapacity) {
        this.couple = couple;
        this.weddingDate = weddingDate;
        this.location = location;
        this.registry = new Registry(couple, weddingDate);
        this.attendees = new HashSet<>();
        this.waitlist = new LinkedList<>();
        this.maxCapacity = maxCapacity;
    }

    // Getters for Wedding properties
    public String getCouple() {
        return couple;
    }

    public String getWeddingDate() {
        return weddingDate;
    }

    public String getLocation() {
        return location;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public HashSet<Integer> getAttendees() {
        return attendees;
    }

    public Queue<Integer> getWaitlist() {
        return waitlist;
    }

    public Registry getRegistry() {
        return registry;
    }

    public int getAttendeeCount() {
        return attendees.size();
    }

    public int getWaitlistSize() {
        return waitlist.size();
    }

    // Displays the wedding details
    public void displayWeddingDetails() {
        System.out.println("Wedding Details:");
        System.out.println("Couple: " + couple);
        System.out.println("Date: " + weddingDate);
        System.out.println("Location: " + location);
        System.out.println("Attendees: " + attendees.size() + "/" + maxCapacity);
        System.out.println("Waitlist: " + waitlist.size());
        System.out.println("Registry Items:");
        registry.displayRegistry(); // Updated to call without arguments
    }
}
