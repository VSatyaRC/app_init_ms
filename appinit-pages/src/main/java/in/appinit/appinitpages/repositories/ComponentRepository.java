package in.appinit.appinitpages.repositories;


import in.appinit.appinitpages.widgets.widgettree.Component;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ComponentRepository extends MongoRepository<Component, String> {

    @Query(value = "{}", fields = "{componentName:1, layoutName:1, id:1, rootKey : 1}")
    List<Component> findAll();
}
