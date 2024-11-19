package wedding.eventplanner.service;

import wedding.eventplanner.Event;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.WriteResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@Service
public class EventService {

    private final CollectionReference eventsCollection;

    public EventService(Firestore db) {
        this.eventsCollection = db.collection("events");
    }

    public String createEvent(Event event) throws ExecutionException, InterruptedException {
        DocumentReference docRef = eventsCollection.document();
        event.setId(docRef.getId());
        WriteResult result = docRef.set(event).get();
        return "Event created with ID: " + docRef.getId() + " at " + result.getUpdateTime();
    }

    public Event getEventById(String id) throws ExecutionException, InterruptedException {
        DocumentReference docRef = eventsCollection.document(id);
        return docRef.get().get().toObject(Event.class);
    }

    public List<Event> getAllEvents() throws ExecutionException, InterruptedException {
        List<Event> events = new ArrayList<>();
        eventsCollection.get().get().forEach(document -> events.add(document.toObject(Event.class)));
        return events;
    }

    public String updateEvent(String id, Event event) throws ExecutionException, InterruptedException {
        DocumentReference docRef = eventsCollection.document(id);
        WriteResult result = docRef.set(event).get();
        return "Event updated at " + result.getUpdateTime();
    }

    public String deleteEvent(String id) throws ExecutionException, InterruptedException {
        DocumentReference docRef = eventsCollection.document(id);
        WriteResult result = docRef.delete().get();
        return "Event deleted at " + result.getUpdateTime();
    }
}
