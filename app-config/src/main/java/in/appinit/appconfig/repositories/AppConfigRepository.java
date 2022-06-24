package in.appinit.appconfig.repositories;

import in.appinit.appconfig.model.AppConfig;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AppConfigRepository extends MongoRepository<AppConfig, String> {

    @Query(value = "{}", fields = "{ 'accessConfig' : 0 }")
    List<AppConfig> findAll();
}
