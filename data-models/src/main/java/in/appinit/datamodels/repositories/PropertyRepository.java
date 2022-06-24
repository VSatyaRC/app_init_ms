package in.appinit.datamodels.repositories;

import in.appinit.datamodels.models.Property;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PropertyRepository extends MongoRepository<Property, String> {
    @Query(fields = "{appId:0}")
    List<Property> findByNameIgnoreCaseStartsWithAndAppId(String startsWith, String appId);

    @Query(fields = "{appId:0}")
    List<Property> findByNameIgnoreCaseStartsWith(String startsWith, List<String> ids);

    @Query(fields = "{appId:0}")
    List<Property> findAllByAppId(String appId);

    @Query(fields = "{appId:0}")
    Optional<Property> findByIdAndAppId(String id, String appId);

    @Override
    void deleteById(String id);

    void deleteAllByAppId(String appId);

    List<Property> findByNameIgnoreCaseStartsWithAndAppIdAndModelName(String startsWith, String appId, String modelName);

    List<Property> findByModelNameIgnoreCaseAndAppId(String modelName, String appId);

    List<Property> findAllByAppIdAndModelNameIgnoreCaseIn(String appId, List<String> modelNames);
}
