package wedding.eventplanner;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class FirebaseConfig {

    @Bean
    public Firestore getFirestore() throws IOException {
        if (FirebaseApp.getApps().isEmpty()) {
            // Load the service account key JSON file
            InputStream serviceAccount = getClass().getClassLoader()
                    .getResourceAsStream("firebaseServiceAccountKey.json");

            if (serviceAccount == null) {
                throw new IOException("Firebase service account key file not found.");
            }

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);
        }

        return FirestoreClient.getFirestore();
    }
}
