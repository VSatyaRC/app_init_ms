package in.appinit.appinitpages.repositories;


import in.appinit.appinitpages.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends MongoRepository<Event, String> {

    Optional<Event> findById(String id);

    List<Event> findAllByAppId(String appId);


    @Query(fields = "{_id:1, name:1, type : 1}")
    List<Event> findAllByNameStartsWithIgnoreCaseAndAppId(String startsWith, String appId);


 /*   void deleteAllByAppId(String appId);
    
    List<Event> findAllByAppId(String appId);*/
}
