package in.appinit.appinitpages.repositories;

import in.appinit.appinitpages.model.variable.Variable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface VariableRepository extends MongoRepository<Variable, String> {

    Optional<Variable> findById(String id);

    void deleteAllByAppId(String appId);

    List<Variable> findAllByAppId(String appId);
}
