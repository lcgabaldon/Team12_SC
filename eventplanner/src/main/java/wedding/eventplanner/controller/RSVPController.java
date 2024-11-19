package wedding.eventplanner.controller;

import wedding.eventplanner.RSVP;
import wedding.eventplanner.service.RSVPService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/rsvps")
public class RSVPController {

    private final RSVPService rsvpService;

    public RSVPController(RSVPService rsvpService) {
        this.rsvpService = rsvpService;
    }

    @PostMapping("/create")
    public String createRSVP(@RequestBody RSVP rsvp) throws ExecutionException, InterruptedException {
        return rsvpService.createRSVP(rsvp);
    }

    @GetMapping("/{id}")
    public RSVP getRSVPById(@PathVariable String id) throws ExecutionException, InterruptedException {
        return rsvpService.getRSVPById(id);
    }

    @GetMapping
    public List<RSVP> getAllRSVPs() throws ExecutionException, InterruptedException {
        return rsvpService.getAllRSVPs();
    }

    @PutMapping("/{id}/accept")
    public String acceptRSVP(@PathVariable String id) throws ExecutionException, InterruptedException {
        return rsvpService.acceptRSVP(id);
    }

    @PutMapping("/{id}/decline")
    public String declineRSVP(@PathVariable String id) throws ExecutionException, InterruptedException {
        return rsvpService.declineRSVP(id);
    }

    @DeleteMapping("/{id}")
    public String deleteRSVP(@PathVariable String id) throws ExecutionException, InterruptedException {
        return rsvpService.deleteRSVP(id);
    }
}
