package in.appinit.datamodels.controller;

import com.google.gson.Gson;
import com.netflix.discovery.converters.Auto;
import in.appinit.datamodels.models.Model;
import in.appinit.datamodels.services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class ModelController {

    @Autowired
    ModelService modelService;

    @Autowired
    Gson gson;

    @RequestMapping(value = "/{appId}/models", method = RequestMethod.POST)
    ResponseEntity<Map<String, List<Model>>> saveAllModels(@PathVariable String appId, @RequestBody Map<String, Model> dataModelsMap) {
        return ResponseEntity.ok(modelService.saveAll(appId, new ArrayList<>(dataModelsMap.values())));
    }

    @RequestMapping(value = "/{appId}/models", method = RequestMethod.GET)
    ResponseEntity<Map<String, List<Model>>> getAllModels(@PathVariable String appId) {
        return ResponseEntity.ok(modelService.getAllModels(appId));
    }

    @RequestMapping(value = "/{appId}/models", method = RequestMethod.DELETE)
    ResponseEntity<String> deleteModels(@PathVariable String appId) {
        modelService.deleteModels(appId);
        return ResponseEntity.ok("Deleted all models");
    }

    @RequestMapping(value = "/models", method = RequestMethod.DELETE)
    ResponseEntity<String> deleteAllModels() {
        modelService.deleteAllModels();
        return ResponseEntity.ok("Deleted all models");
    }

    @RequestMapping(value = "/{appId}/model", method = RequestMethod.DELETE)
    ResponseEntity<String> deleteModel(@PathVariable String appId, @RequestBody String modelString) {

        Model model = gson.fromJson(modelString, Model.class);
        System.out.println("Deleting: " + model.getName());
        modelService.deleteModel(appId, model);
        return ResponseEntity.ok("Deleted all models");
    }

    @RequestMapping(value = "/{appId}/model", method = RequestMethod.POST)
    ResponseEntity<Model> saveModel(@PathVariable String appId, @RequestBody Model model) {
        System.out.println("Saving model: " + model.getName());
        return ResponseEntity.ok(modelService.saveModel(appId, model));
    }

    @RequestMapping(value = "/{appId}/model/{id}", method = RequestMethod.GET)
    ResponseEntity<Model> saveModel(@PathVariable String appId, @PathVariable String id) {
        return ResponseEntity.ok(modelService.getDataModel(id));
    }

    @RequestMapping(value = "/{appId}/models/search/{startsWith}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, List<Model>>> searchModels(@PathVariable String appId, @PathVariable String startsWith) {
        System.out.println("Searching: " + startsWith);
        return ResponseEntity.ok(modelService.modelNameStartingWith(startsWith, appId));
    }

    @RequestMapping(value = "/{appId}/isPresent", method = RequestMethod.POST)
    public ResponseEntity<Model> isPresent(@PathVariable String appId, @RequestBody Model model) {
        return ResponseEntity.ok(modelService.isPresent(model, appId));
    }
}
