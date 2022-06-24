package in.appinit.appinitpages.services;

import in.appinit.appinitpages.model.Event;
import in.appinit.appinitpages.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;


    public Event saveEvent(String appId, Event event) {
        Map<String, String> eventId = new HashMap<>();
        event.setAppId(appId);
        //ToDO create unique 'name' for property. Display name is different
        return eventRepository.save(event);

    }

    public Event getEvent(String id) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        return optionalEvent.orElseGet(Event::new);
    }

    public Map<String, List<Event>> getAllEvents(String appId) {
        Map<String, List<Event>> response = new HashMap<>();
        response.put("events", eventRepository.findAllByAppId(appId));
        return response;
    }

    public Map<String, List<Event>> saveAll(String appId, List<Event> events) {
        Map<String, List<Event>> response = new HashMap<>();
        response.put("events", eventRepository.saveAll(events));
        return response;
    }

    public void deleteAllEvents() {
        eventRepository.deleteAll();
    }

    public void deleteEvents(String appId) {
        eventRepository.deleteAll();
    }

    public void deleteEvent(String appId, Event event) {
        eventRepository.deleteById(event.getId());
    }
}
