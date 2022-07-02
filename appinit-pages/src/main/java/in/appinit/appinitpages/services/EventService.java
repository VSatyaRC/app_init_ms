package in.appinit.appinitpages.services;

import in.appinit.appinitpages.model.Event;
import in.appinit.appinitpages.model.task.SimpleTask;
import in.appinit.appinitpages.repositories.EventRepository;
import in.appinit.appinitpages.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    TaskRepository taskRepository;


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

    public Map<String, List<Event>> getAllFullEvents(String appId) {
        Map<String, List<Event>> response = new HashMap<>();
        List<Event> events = eventRepository.findAllByAppId(appId);

        events.forEach(e -> {
            List<SimpleTask> tasks = new ArrayList<>();

            if (null != e.getTasks()) {
                e.getTasks().forEach(simpleTask -> {
                    tasks.add((SimpleTask) taskRepository.findById(simpleTask.getId()).get());
                });
                e.setTasks(tasks);
            }
        });
        response.put("events", events);
        return response;
    }


    public Map<String, List<Event>> searchByName(String startsWith, String appId) {
        Map<String, List<Event>> results = new HashMap<>();
        results.put("events", eventRepository.findAllByNameStartsWithIgnoreCaseAndAppId(startsWith, appId));
        return results;
    }

    public Map<String, List<Event>> pageEvents(String screenId, String appId, Map<String, List<String>> events) {
        Map<String, List<Event>> results = new HashMap<>();
        results.put("events", eventRepository.findAllByIdIn(events.get("events")));
        return results;
    }
}
