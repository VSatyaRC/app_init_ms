package in.appinit.appinitpages.repositories;

import in.appinit.appinitpages.model.variable.Variable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface VariableRepository extends MongoRepository<Variable, String> {

    Optional<Variable> findById(String id);

    void deleteAllByAppId(String appId);

    List<Variable> findAllByAppId(String appId);


    @Query(fields = "{_id:1, name:1, type : 1}")
    List<Variable> findAllByNameStartsWithIgnoreCaseAndAppId(String startsWith, String appId);
}
