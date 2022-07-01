package in.appinit.appinitpages.controller.events;


import in.appinit.appinitpages.model.Event;
import in.appinit.appinitpages.model.variable.Variable;
import in.appinit.appinitpages.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EventController {

    @Autowired
    EventService eventService;

    @RequestMapping(value = "/{appId}/event", method = RequestMethod.POST)
    ResponseEntity<Event> saveEvent(@PathVariable String appId, @RequestBody Event event) {
        return ResponseEntity.ok(eventService.saveEvent(appId, event));
    }

    @RequestMapping(value = "/{appId}/event", method = RequestMethod.DELETE)
    ResponseEntity<Map<String, String>> deleteEvent(@PathVariable String appId, @RequestBody Event event) {
        eventService.deleteEvent(appId, event);
        Map<String, String> response = new HashMap<>();
        response.put("status", "Deleted successfully");
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/{appId}/events", method = RequestMethod.POST)
    ResponseEntity<Map<String, List<Event>>> saveAllEvents(@PathVariable String appId, @RequestBody Map<String, Event> eventsMap) {
        return ResponseEntity.ok(eventService.saveAll(appId, new ArrayList<>(eventsMap.values())));
    }

    @RequestMapping(value = "/{appId}/events", method = RequestMethod.GET)
    ResponseEntity<Map<String, List<Event>>> getAllEvents(@PathVariable String appId) {
        return ResponseEntity.ok(eventService.getAllEvents(appId));
    }

    @RequestMapping(value = "/{appId}/events", method = RequestMethod.DELETE)
    ResponseEntity<String> deleteEvents(@PathVariable String appId) {
        eventService.deleteEvents(appId);
        return ResponseEntity.ok("Deleted all events");
    }
/*    @RequestMapping(value = "/{appId}/events", method = RequestMethod.DELETE)
    ResponseEntity<String> deleteAllEvents() {
        eventService.deleteAllEvents();
        return ResponseEntity.ok("Deleted all events");
    }*/

    @RequestMapping(value = "/{appId}/event/{id}", method = RequestMethod.GET)
    ResponseEntity<Event> saveEvent(@PathVariable String appId, @PathVariable String id) {
        return ResponseEntity.ok(eventService.getEvent(id));
    }

    @RequestMapping(value = "/{appId}/config/events")
    ResponseEntity<Map<String, List<Event>>> getScreenEventConfiguarations(@PathVariable String appId) {
        return ResponseEntity.ok(eventService.getAllFullEvents(appId));
    }

    @RequestMapping(value = "/{appId}/events/{startsWith}", method = RequestMethod.GET)
    ResponseEntity<Map<String, List<Event>>> searchEvents(@PathVariable String appId, @PathVariable String startsWith) {
        return ResponseEntity.ok(eventService.searchByName(startsWith, appId));
    }

}
