package wedding.eventplanner.service;

import wedding.eventplanner.RSVP;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.WriteResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@Service
public class RSVPService {

    private final CollectionReference rsvpCollection;

    public RSVPService(Firestore db) {
        this.rsvpCollection = db.collection("rsvps");
    }

    public String createRSVP(RSVP rsvp) throws ExecutionException, InterruptedException {
        DocumentReference docRef = rsvpCollection.document();
        rsvp.setRsvpId(docRef.getId());
        WriteResult result = docRef.set(rsvp).get();
        return "RSVP created with ID: " + docRef.getId() + " at " + result.getUpdateTime();
    }

    public RSVP getRSVPById(String id) throws ExecutionException, InterruptedException {
        DocumentReference docRef = rsvpCollection.document(id);
        return docRef.get().get().toObject(RSVP.class);
    }

    public List<RSVP> getAllRSVPs() throws ExecutionException, InterruptedException {
        List<RSVP> rsvps = new ArrayList<>();
        rsvpCollection.get().get().forEach(document -> rsvps.add(document.toObject(RSVP.class)));
        return rsvps;
    }

    public String acceptRSVP(String id) throws ExecutionException, InterruptedException {
        DocumentReference docRef = rsvpCollection.document(id);
        WriteResult result = docRef.update("status", "Accepted").get();
        return "RSVP accepted at " + result.getUpdateTime();
    }

    public String declineRSVP(String id) throws ExecutionException, InterruptedException {
        DocumentReference docRef = rsvpCollection.document(id);
        WriteResult result = docRef.update("status", "Declined").get();
        return "RSVP declined at " + result.getUpdateTime();
    }

    public String deleteRSVP(String id) throws ExecutionException, InterruptedException {
        DocumentReference docRef = rsvpCollection.document(id);
        WriteResult result = docRef.delete().get();
        return "RSVP deleted at " + result.getUpdateTime();
    }
}
