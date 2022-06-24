package in.appinit.appconfig.repositories;

import in.appinit.appconfig.model.access.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface RolesRepository extends MongoRepository<Role, String> {

    Optional<Role> findById(String id);

    void deleteAllByAppId(String appId);

    List<Role> findAllByAppId(String appId);

    List<Role> findAllByRoleNameStartsWithIgnoreCaseAndAppId(String roleName, String appId);
}
