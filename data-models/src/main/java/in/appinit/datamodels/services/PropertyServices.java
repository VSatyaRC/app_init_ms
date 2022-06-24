package in.appinit.datamodels.services;

import in.appinit.datamodels.models.Model;
import in.appinit.datamodels.models.Property;
import in.appinit.datamodels.repositories.DataModelRepository;
import in.appinit.datamodels.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PropertyServices {

    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    DataModelRepository dataModelRepository;

    public Property findById(String id) {
        return propertyRepository.findById(id).orElseGet(Property::new);
    }

    public List<Property> saveAll(String appId, List<Property> properties) {
        System.out.println("Saving properties");
        properties.forEach(property -> property.setAppId(appId));
        return propertyRepository.saveAll(properties);
    }

    public Property save(String appId, Property property) {
        property.setAppId(appId);
        return propertyRepository.save(property);
    }

    public void deleteAllByAppId(String appId) {
        propertyRepository.deleteAllByAppId(appId);
    }

    public void deleteAll() {
        propertyRepository.deleteAll();
    }

    public List<Property> findAll() {
        return propertyRepository.findAll();
    }

    public List<Property> propertyStartingWith(String appId, String startsWith) {
        //ToDO *Very important, remove this line and uncomment above line. Below line will fetch properties across all apps and models*
        return propertyRepository.findByNameIgnoreCaseStartsWithAndAppId(startsWith, appId);
    }

    public Map<String, List<Property>> propertiesInModel(String appId, String modelName) {
        Map<String, List<Property>> results = new HashMap<>();
        results.put("properties", propertyRepository.findByModelNameIgnoreCaseAndAppId(modelName, appId));
        //ToDO *Very important, remove this line and uncomment above line. Below line will fetch properties across all apps and models*
        return results;
    }


    public List<Property> propertyStartingWith(String appId, String startsWith, String modelName) {
        //ToDO *Very important, remove this line and uncomment above line. Below line will fetch properties across all apps and models*
        return propertyRepository.findByNameIgnoreCaseStartsWithAndAppIdAndModelName(startsWith, appId, modelName);
    }

    public List<Property> findAllByAppId(String appId) {
        return propertyRepository.findAllByAppId(appId);
    }

    public void deleteAllById(List<String> propertiesInModel) {
        propertyRepository.deleteAllById(propertiesInModel);
    }

    public List<String> propertiesInApp(String appId) {
        return findAllByAppId(appId).stream().map(Property::getId).collect(Collectors.toList());
    }

    public void deleteById(String appId, String modelId, Property modelProperty) {

        System.out.println("Deleting: " + propertyRepository.findById(modelProperty.getId()));

        Optional<Model> dataModelSaved = dataModelRepository.findById(modelId);
        if (dataModelSaved.isPresent()) {
            System.out.println("isPresent: " + modelProperty.getId().matches(modelProperty.getId()));

            Model model = dataModelSaved.get();
            model.getProperties().removeIf(property -> {
                System.out.println("Found: " + property.getId().matches(modelProperty.getId()));
                return property.getId().matches(modelProperty.getId());
            });
            dataModelRepository.save(model);
            propertyRepository.deleteById(modelProperty.getId());
        }
    }

    public Map<String, List<Property>> searchPropertiesInModels(String appId, List<String> modelNames) {
        Map<String, List<Property>> results = new HashMap<>();
        results.put("results", propertyRepository.findAllByAppIdAndModelNameIgnoreCaseIn(appId, modelNames));
        return results;
    }

  /*public Map<String, ModelProperty> getP ropertiesInApp(String appId) {
        return propertyRepository.findAllById(appId);
    }*/
}
