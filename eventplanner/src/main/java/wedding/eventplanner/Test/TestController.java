package wedding.eventplanner.Test;

import com.google.firebase.auth.FirebaseAuth;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/api/test-firebase")
    public String testFirebaseConnection() {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        return "Firebase initialized: " + (auth != null);
    }
}
