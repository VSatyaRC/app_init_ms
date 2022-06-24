package in.appinit.datamodels.repositories;

import in.appinit.datamodels.models.Model;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface DataModelRepository extends MongoRepository<Model, String> {

    List<Model> findByPropertiesNameStartsWithAndPropertiesIdIn(String startsWith, List<String> ids);

    List<Model> findByPropertiesNameStartsWith(String startsWith, List<String> ids);

    Optional<Model> findById(String id);

    void deleteAllByAppId(String appId);

    void deleteByIdAndAppId(String id, String appId);

    List<Model> findAllByAppId(String appId);

    Optional<Model> findByNameIgnoreCaseAndAppId(String name, String appId);

    List<Model> findByNameStartsWithIgnoreCaseAndAppId(String startsWith, String appId);

    Optional<Model> findByNameAndAppId(String name, String appId);

}
