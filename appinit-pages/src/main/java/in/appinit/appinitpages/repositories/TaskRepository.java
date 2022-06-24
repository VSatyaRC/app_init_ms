package in.appinit.appinitpages.repositories;

import in.appinit.appinitpages.model.task.SimpleTask;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository<T extends SimpleTask> extends MongoRepository<T, String> {

    Optional<T> findById(String id);

    List<T> findAll();

/*    void deleteAllByAppId(String appId);

    List<Task> findAllByAppId(String appId);*/
}
