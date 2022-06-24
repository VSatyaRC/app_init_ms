package in.appinit.appinitpages.repositories;

import in.appinit.appinitpages.widget_config.style.StyleConfig;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StyleConfigRepository extends MongoRepository<StyleConfig, String> {


}
