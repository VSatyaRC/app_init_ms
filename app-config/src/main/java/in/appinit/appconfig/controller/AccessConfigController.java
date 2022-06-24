package in.appinit.appconfig.controller;

import in.appinit.appconfig.model.access.Role;
import in.appinit.appconfig.repositories.AppConfigRepository;
import in.appinit.appconfig.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AccessConfigController {

    @Autowired
    AppConfigRepository appConfigRepository;

    @Autowired
    RoleService roleService;

    @GetMapping(value = "/accessConfig")
    public ResponseEntity<Map<String, Role>> fetchAccessConfig() {
        return ResponseEntity.ok(new HashMap<>());
    }

    @PostMapping(value = "/{appId}/roles")
    ResponseEntity<Map<String, List<Role>>> saveAllRoles(@PathVariable String appId, @RequestBody Map<String, Role> rolesMap) {
        return ResponseEntity.ok(roleService.saveAll(appId, new ArrayList<>(rolesMap.values())));
    }

    @GetMapping(value = "/{appId}/roles")
    ResponseEntity<Map<String, List<Role>>> getAllRoles(@PathVariable String appId) {
        return ResponseEntity.ok(roleService.getAllRoles(appId));
    }

    @DeleteMapping(value = "/{appId}/roles")
    ResponseEntity<String> deleteRoles(@PathVariable String appId) {
        roleService.deleteRoles(appId);
        return ResponseEntity.ok("Deleted all roles");
    }

    @GetMapping(value = "/{appId}/roles/search/{startsWith}")
    ResponseEntity<Map<String, List<Role>>> searchRoles(@PathVariable String appId, @PathVariable String startsWith) {
        return ResponseEntity.ok(roleService.searchRoles(appId, startsWith));
    }

    @DeleteMapping(value = "/roles")
    ResponseEntity<String> deleteAllRoles() {
        roleService.deleteAllRoles();
        return ResponseEntity.ok("Deleted all roles");
    }

    @PostMapping(value = "/{appId}/role")
    ResponseEntity<Role> saveRole(@PathVariable String appId, @RequestBody Role role) {
        return ResponseEntity.ok(roleService.saveRole(appId, role));
    }

    @GetMapping(value = "/{appId}/role/{id}")
    ResponseEntity<Role> saveRole(@PathVariable String appId, @PathVariable String id) {
        return ResponseEntity.ok(roleService.getRole(id));
    }

}
