package in.appinit.appinitpages.repositories;


import in.appinit.appinitpages.widgets.SimpleWidget;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SimpleWidgetRepository extends MongoRepository<SimpleWidget, String> {
    Optional<SimpleWidget> findBySimpleNameIgnoreCase(String simpleName);

}
