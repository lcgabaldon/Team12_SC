package src.main.java.com;

public class main {
    public static void main(String[] args){
        User userCreation = new User(69, "Joey", "", "Caproni", "joeycaproni420@gmail.com");
        userCreation.setEventsCreated("Joey and Girlie");
        userCreation.setEventsAttended("Bachelor Party");
    
        // Display user's ID:
        System.out.println("User ID: " + userCreation.getUserID());

        // Display user's full name:
        System.out.println("Full Name: " + userCreation.getFullName());

        // Display user's email:
        System.out.println("Email: " + userCreation.getEmailAddress());

        // Display user's created events:
        System.out.println("Event history: " + userCreation.getEventsCreated());

        // Display user's events attended:
        System.out.println("Events attended: " + userCreation.getEventsAttended());

        // Display all of user's details:
        System.out.println("User details: " + userCreation.toString());
    }
}