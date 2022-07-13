package in.appinit.appconfig.repositories;


import in.appinit.appconfig.model.CustomApi;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CustomApiRepository extends MongoRepository<CustomApi, String> {
    
    Optional<CustomApi> findById(String id);

    void deleteAllByAppId(String appId);
    
    List<CustomApi> findAllByAppId(String appId);
}
