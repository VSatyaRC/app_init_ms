package in.appinit.appconfig.repositories;


import in.appinit.appconfig.model.App;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AppsRepository extends MongoRepository<App, String> {

    App save(App app);

    Optional<App> findById(String id);



}
