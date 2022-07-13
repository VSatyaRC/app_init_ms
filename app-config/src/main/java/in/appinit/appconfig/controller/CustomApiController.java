package in.appinit.appconfig.controller;

import com.google.gson.Gson;
import in.appinit.appconfig.model.CustomApi;
import in.appinit.appconfig.repositories.CustomApiRepository;
import in.appinit.appconfig.services.CustomApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CustomApiController {

    @Autowired
    CustomApiService customApiService;

    @Autowired
    CustomApiRepository customApiRepository;

    @Autowired
    Gson gson;

    @RequestMapping(value = "/{appId}/customApi", method = RequestMethod.POST)
    ResponseEntity<CustomApi> saveCustomApi(@PathVariable String appId, @RequestBody CustomApi customApi) {
        return ResponseEntity.ok(customApiService.saveCustomApi(appId, customApi));
    }

    @RequestMapping(value = "/{appId}/customApis", method = RequestMethod.POST)
    ResponseEntity<Map<String, List<CustomApi>>> saveAllCustomApis(@PathVariable String appId, @RequestBody Map<String, CustomApi> customApisMap) {
        return ResponseEntity.ok(customApiService.saveAll(appId, new ArrayList<>(customApisMap.values())));
    }


    @RequestMapping(value = "/{appId}/customApi/{id}", method = RequestMethod.GET)
    ResponseEntity<CustomApi> saveCustomApi(@PathVariable String appId, @PathVariable String id) {
        return ResponseEntity.ok(customApiService.getCustomApi(id));
    }

    @RequestMapping(value = "/{appId}/customApis", method = RequestMethod.GET)
    ResponseEntity<Map<String, List<CustomApi>>> getAllCustomApis(@PathVariable String appId) {
        return ResponseEntity.ok(customApiService.getAllCustomApis(appId));
    }

    @RequestMapping(value = "/{appId}/customApis", method = RequestMethod.DELETE)
    ResponseEntity<String> deleteCustomApis(@PathVariable String appId) {
        customApiService.deleteCustomApis(appId);
        return ResponseEntity.ok("Deleted all customApis");
    }

    @RequestMapping(value = "/{appId}/customApi", method = RequestMethod.DELETE)
    ResponseEntity<Map<String, Boolean>> deleteCustomApi(@RequestBody CustomApi customApi) {
        customApiService.deleteCustomApi(customApi);
        Map<String, Boolean> response = new HashMap<>();
        response.put("status", customApiRepository.findById(customApi.getId()).isPresent());
        return ResponseEntity.ok(response);
    }


  /*@RequestMapping(value = "/{appId}/customApis/search", method = RequestMethod.GET)
    public ResponseEntity<List<CustomApi>> allProperties(@PathVariable String appId, @RequestBody Map<String, List<String>> requestBody) {
        return ResponseEntity.ok(customApiService.propertyStartingWith(requestBody.get("startsWith").get(0), requestBody.get("ids")));
    }*/
}
