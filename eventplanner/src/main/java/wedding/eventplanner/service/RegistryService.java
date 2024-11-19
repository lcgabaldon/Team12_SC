package wedding.eventplanner.service;

import wedding.eventplanner.RegistryItem;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.WriteResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@Service
public class RegistryService {

    private final CollectionReference registryCollection;

    public RegistryService(Firestore db) {
        this.registryCollection = db.collection("registry");
    }

    public String createRegistryItem(RegistryItem registryItem) throws ExecutionException, InterruptedException {
        DocumentReference docRef = registryCollection.document();
        registryItem.setId(docRef.getId());
        WriteResult result = docRef.set(registryItem).get();
        return "Registry item created with ID: " + docRef.getId() + " at " + result.getUpdateTime();
    }

    public RegistryItem getRegistryItemById(String id) throws ExecutionException, InterruptedException {
        DocumentReference docRef = registryCollection.document(id);
        return docRef.get().get().toObject(RegistryItem.class);
    }

    public List<RegistryItem> getAllRegistryItems() throws ExecutionException, InterruptedException {
        List<RegistryItem> registryItems = new ArrayList<>();
        registryCollection.get().get().forEach(document -> registryItems.add(document.toObject(RegistryItem.class)));
        return registryItems;
    }

    public String updateRegistryItem(String id, RegistryItem registryItem)
            throws ExecutionException, InterruptedException {
        DocumentReference docRef = registryCollection.document(id);
        WriteResult result = docRef.set(registryItem).get();
        return "Registry item updated at " + result.getUpdateTime();
    }

    public String deleteRegistryItem(String id) throws ExecutionException, InterruptedException {
        DocumentReference docRef = registryCollection.document(id);
        WriteResult result = docRef.delete().get();
        return "Registry item deleted at " + result.getUpdateTime();
    }
}
