package in.appinit.appinitpages.repositories;

import in.appinit.appinitpages.model.task.SimpleTask;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TaskRepository<T extends SimpleTask> extends MongoRepository<T, String> {

    Optional<T> findById(String id);

    List<T> findAll();

    @Query(fields = "{_id:1, name:1, type : 1}")
    List<T> findAllByNameStartsWithIgnoreCaseAndAppId(String startsWith, String appId);

/*    void deleteAllByAppId(String appId);

    List<Task> findAllByAppId(String appId);*/
}
