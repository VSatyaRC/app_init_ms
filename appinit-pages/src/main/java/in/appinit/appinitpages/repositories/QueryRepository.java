package in.appinit.appinitpages.repositories;

import in.appinit.appinitpages.model.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface QueryRepository extends MongoRepository<Query, String> {

    Optional<Query> findById(String id);

    void deleteAllByAppId(String appId);

    List<Query> findAllByAppId(String appId);

    void deleteByIdAndAppId(String id, String appId);

    List<Query> findAllByAppIdAndNameContainsIgnoreCase(String appId, String queryName);

    List<Query> findAllByAppIdAndNameStartsWithIgnoreCase(String appId, String queryName);
}
