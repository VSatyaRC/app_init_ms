package in.appinit.datamodels.services;

import in.appinit.datamodels.models.Model;
import in.appinit.datamodels.models.Property;
import in.appinit.datamodels.repositories.DataModelRepository;
import in.appinit.datamodels.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ModelService {

    @Autowired
    DataModelRepository dataModelRepository;

    @Autowired
    PropertyServices propertyServices;

    @Autowired
    PropertyRepository propertyRepository;

    @Value("${response.key.models}")
    private String models;


    public Model saveModel(String appId, Model model) {
        //ToDO create unique 'name' for property. Display name is different
        model.setAppId(appId);
        model.setProperties(propertyServices.saveAll(appId, model.getProperties()));
        Model dataModel = dataModelRepository.save(model);
        System.out.println(dataModel);
        return dataModel;
    }

    public Model getDataModel(String id) {
        Optional<Model> optionalDataModel = dataModelRepository.findById(id);
        return optionalDataModel.orElseGet(Model::new);
    }

    public Map<String, List<Model>> getAllModels(String appId) {
        Map<String, List<Model>> response = new HashMap<>();
        response.put(models, dataModelRepository.findAllByAppId(appId));
        return response;
    }

    public Map<String, List<Model>> saveAll(String appId, List<Model> models) {
//        deleteModels(appId);
        for (Model model : models) {
            model.setAppId(appId);
            propertyServices.saveAll(appId, model.getProperties());
        }

        Map<String, List<Model>> response = new HashMap<>();
        response.put(this.models, dataModelRepository.saveAll(models));
        return response;
    }

    public void deleteAllModels() {
        dataModelRepository.deleteAll();
        propertyServices.deleteAll();
    }

    public void deleteModels(String appId) {
        dataModelRepository.deleteAllByAppId(appId);
        propertyServices.deleteAllByAppId(appId);
    }

    public Map<String, List<Model>> modelNameStartingWith(String startsWith, String appId) {

        //return dataModelRepository.findByPropertiesPropertyNameStartsWithAndPropertiesIdIn(startsWith, ids);
        //ToDO *Very important, remove this line and uncomment above line, below line will fetch properties across all apps and models*

        Map<String, List<Model>> response = new HashMap<>();
        response.put(models, dataModelRepository.findByNameStartsWithIgnoreCaseAndAppId(startsWith, appId));
        return response;
    }

    public Model isPresent(Model model, String appId) {
        return dataModelRepository.findByNameIgnoreCaseAndAppId(model.getName(), appId).orElseGet(Model::new);
    }

    public void deleteModel(String appId, Model model) {
        List<String> propertiesInModel = dataModelRepository.findById(model.getId()).orElseGet(Model::new).getProperties().stream().map(Property::getId).collect(Collectors.toList());
        dataModelRepository.deleteById(model.getId());
        propertyServices.deleteAllById(propertiesInModel);
    }

    public List<String> modelsInApp(String appId) {
        return dataModelRepository.findAllByAppId(appId).stream().map(Model::getId).collect(Collectors.toList());
    }

    public List<String> propertiesInModel(Model model) {
        return model.getProperties().stream().map(Property::getId).collect(Collectors.toList());
    }

}