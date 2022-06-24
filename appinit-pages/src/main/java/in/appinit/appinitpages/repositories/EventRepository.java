package in.appinit.appinitpages.repositories;


import in.appinit.appinitpages.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends MongoRepository<Event, String> {
    
    Optional<Event> findById(String id);

    List<Event> findAllByAppId(String appId);

 /*   void deleteAllByAppId(String appId);
    
    List<Event> findAllByAppId(String appId);*/
}
