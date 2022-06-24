package in.appinit.appinitpages.repositories;


import in.appinit.appinitpages.widgets.widgettree.Layout;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LayoutRepository extends MongoRepository<Layout, String> {
    List<Layout> findAllByAppId(String appId);

    Layout findTopByAppId(String appId);

}
