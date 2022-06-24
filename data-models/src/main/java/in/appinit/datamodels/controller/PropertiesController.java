package in.appinit.datamodels.controller;

import in.appinit.datamodels.models.Property;
import in.appinit.datamodels.services.PropertyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PropertiesController {

    @Autowired
    PropertyServices propertyServices;

    @RequestMapping(value = "/{appId}/properties", method = RequestMethod.POST)
    public ResponseEntity<List<Property>> saveAllProperties(@PathVariable String appId, @RequestBody List<Property> propertiesList) {
        return ResponseEntity.ok(propertyServices.saveAll(appId, propertiesList));
    }

    @RequestMapping(value = "/{appId}/properties", method = RequestMethod.GET)
    public ResponseEntity<List<Property>> getAllProperties(@PathVariable String appId) {
        return ResponseEntity.ok(propertyServices.findAllByAppId(appId));
    }

    @RequestMapping(value = "/{appId}/property", method = RequestMethod.POST)
    public ResponseEntity<Property> saveProperty(@PathVariable String appId, @RequestBody Property property) {
        return ResponseEntity.ok(propertyServices.save(appId, property));
    }

    @RequestMapping(value = "/{appId}/property/{id}", method = RequestMethod.GET)
    public ResponseEntity<Property> saveProperty(@PathVariable String appId, @PathVariable String id) {
        return ResponseEntity.ok(propertyServices.findById(id));
    }

    @RequestMapping(value = "/{appId}/{modelId}/property", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteProperty(@PathVariable String appId,
                                                 @PathVariable String modelId,
                                                 @RequestBody Property property) {

        System.out.println("Deleting Property: " + property.getId());
        propertyServices.deleteById(appId, modelId, property);
        return ResponseEntity.ok("Deleted " + property.getName());
    }

    @RequestMapping(value = "/{appId}/properties", method = RequestMethod.DELETE)
    public ResponseEntity<String> allProperties(@PathVariable String appId) {
        propertyServices.deleteAllByAppId(appId);
        return ResponseEntity.ok("Deleted all properties");
    }


    @RequestMapping(value = "/properties", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAll() {
        propertyServices.deleteAll();
        return ResponseEntity.ok("Deleted all properties");
    }

    @RequestMapping(value = "/properties", method = RequestMethod.GET)
    public ResponseEntity<List<Property>> getAll() {
        return ResponseEntity.ok(propertyServices.findAll());
    }

    @RequestMapping(value = "/{appId}/properties/search/{startsWith}", method = RequestMethod.GET)
    public ResponseEntity<List<Property>> searchProperties(@PathVariable String appId, @PathVariable String startsWith) {
        return ResponseEntity.ok(propertyServices.propertyStartingWith(appId, startsWith));
    }

    @RequestMapping(value = "/{appId}/{modelName}/properties/search/{startsWith}", method = RequestMethod.GET)
    public ResponseEntity<List<Property>> searchModelProperties(@PathVariable String appId, @PathVariable String startsWith, @PathVariable String modelName) {
        return ResponseEntity.ok(propertyServices.propertyStartingWith(appId, startsWith, modelName));
    }

    @RequestMapping(value = "/{appId}/{modelName}/properties", method = RequestMethod.GET)
    public ResponseEntity<Map<String, List<Property>>> allPropertiesInModel(@PathVariable String appId, @PathVariable String modelName) {
        return ResponseEntity.ok(propertyServices.propertiesInModel(appId, modelName));
    }

    @RequestMapping(value = "/{appId}/search/properties", method = RequestMethod.POST)
    public ResponseEntity<Map<String, List<Property>>> allPropertiesInModelsWithName(@PathVariable String appId, @RequestBody List<String> modelNames) {
        System.out.println(modelNames.toString());
        return ResponseEntity.ok(propertyServices.searchPropertiesInModels(appId, modelNames));
    }

   /* @RequestMapping(value = "/{appId}/{modelId}/properties/search/{startsWith}", method = RequestMethod.GET)
    public ResponseEntity<List<Property>> searchPropertiesInModel(@PathVariable String appId, @PathVariable String startsWith, @PathVariable String modelId) {
        return ResponseEntity.ok(propertyServices.propertyStartingWith(appId, startsWith, modelId));
    }*/
}
