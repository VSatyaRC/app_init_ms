package in.appinit.appconfig.services;

import in.appinit.appconfig.model.access.Role;
import in.appinit.appconfig.repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    RolesRepository rolesRepository;

    public Map<String, List<Role>> saveAll(String appId, List<Role> roles) {
        roles.forEach(r -> r.setAppId(appId));

        Map<String, List<Role>> response = new HashMap<>();
        response.put("roles", rolesRepository.saveAll(roles));
        return response;
    }

    public Role saveRole(String appId, Role role) {
        Map<String, Role> roleId = new HashMap<>();
        role.setAppId(appId);
        //ToDO create unique 'name' for property. Display name is different
        return rolesRepository.save(role);
    }

    public Role getRole(String id) {
        Optional<Role> optionalRole = rolesRepository.findById(id);
        return optionalRole.orElseGet(Role::new);
    }

    public Map<String, List<Role>> getAllRoles(String appId) {
        Map<String, List<Role>> response = new HashMap<>();
        response.put("roles", rolesRepository.findAllByAppId(appId));
        return response;
    }

    public void deleteAllRoles() {
        rolesRepository.deleteAll();
    }

    public void deleteRoles(String appId) {
        rolesRepository.deleteAllByAppId(appId);
    }

    public Map<String, List<Role>> searchRoles(String appId, String startsWith) {
        Map<String, List<Role>> rolesList = new HashMap<>();
        rolesList.put("roles", rolesRepository.findAllByRoleNameStartsWithIgnoreCaseAndAppId(startsWith,appId));
        return rolesList;
    }
}
