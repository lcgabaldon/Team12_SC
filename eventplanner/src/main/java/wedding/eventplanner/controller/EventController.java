package wedding.eventplanner.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import wedding.eventplanner.Event;
import wedding.eventplanner.service.EventService;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/create") // Full path will be /api/events/create
    public ResponseEntity<?> createEvent(@RequestBody Event event) {
        try {
            String createdEvent = eventService.createEvent(event);
            return ResponseEntity.ok(createdEvent);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error creating event");
        }
    }
}
