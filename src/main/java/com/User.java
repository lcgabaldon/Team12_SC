package src.main.java.com;

public class User{
    // Variables:
    private int userID;
    private String firstName;
    private String middleName;
    private String lastName;
    private String emailAddress;
    private String eventsCreated;
    private String eventsAttended;

    // Constructor
    public User(int userID, String firstName, String middleName, String lastName, String emailAddress) {
        this.userID = userID;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }

    // Getters and Setters:
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEventsCreated() {
        return eventsCreated;
    }

    public void setEventsCreated(String eventsCreated) {
        this.eventsCreated = eventsCreated;
    }

    public String getEventsAttended() {
        return eventsAttended;
    }

    public void setEventsAttended(String eventsAttended) {
        this.eventsAttended = eventsAttended;
    }

    // Method to return the full name
    public String getFullName() {
        // Handles cases where middleName might be null
        if (middleName == null || middleName.isEmpty()) {
            return firstName + " " + lastName;
        } else {
            return firstName + " " + middleName + " " + lastName;
        }
    }

    // toString method for easy display of user information
    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", fullName='" + getFullName() + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", eventsCreated='" + eventsCreated + '\'' +
                ", eventsAttended='" + eventsAttended + '\'' +
                '}';
    }
}