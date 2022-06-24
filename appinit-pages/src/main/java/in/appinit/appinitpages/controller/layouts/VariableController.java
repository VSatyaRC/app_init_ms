package in.appinit.appinitpages.controller.layouts;

import in.appinit.appinitpages.model.variable.Variable;
import in.appinit.appinitpages.services.VariableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class VariableController {

    @Autowired
    VariableService variableService;


    @RequestMapping(value = "/{appId}/variable", method = RequestMethod.POST)
    ResponseEntity<Variable> saveVariable(@PathVariable String appId, @RequestBody Variable variable) {
        return ResponseEntity.ok(variableService.saveVariable(appId, variable));
    }

    @RequestMapping(value = "/{appId}/variables", method = RequestMethod.POST)
    ResponseEntity<Map<String, List<Variable>>> saveAllVariables(@PathVariable String appId, @RequestBody Map<String, Variable> variablesMap) {
        return ResponseEntity.ok(variableService.saveAll(appId, new ArrayList<>(variablesMap.values())));
    }


    @RequestMapping(value = "/{appId}/variable/{id}", method = RequestMethod.GET)
    ResponseEntity<Variable> saveVariable(@PathVariable String appId, @PathVariable String id) {
        return ResponseEntity.ok(variableService.getVariable(id));
    }

    @RequestMapping(value = "/{appId}/variables", method = RequestMethod.GET)
    ResponseEntity<Map<String, List<Variable>>> getAllVariables(@PathVariable String appId) {
        return ResponseEntity.ok(variableService.getAllVariables(appId));
    }

    @RequestMapping(value = "/{appId}/variables", method = RequestMethod.DELETE)
    ResponseEntity<String> deleteVariables(@PathVariable String appId) {
        variableService.deleteVariables(appId);
        return ResponseEntity.ok("Deleted all variables");
    }

    @RequestMapping(value = "/{appId}/variable/{id}", method = RequestMethod.DELETE)
    ResponseEntity<String> deleteVariable(@PathVariable String appId, @PathVariable String id) {
        variableService.deleteVariable(id);
        return ResponseEntity.ok("Deleted all variables");
    }


  /*@RequestMapping(value = "/{appId}/variables/search", method = RequestMethod.GET)
    public ResponseEntity<List<Variable>> allProperties(@PathVariable String appId, @RequestBody Map<String, List<String>> requestBody) {
        return ResponseEntity.ok(variableService.propertyStartingWith(requestBody.get("startsWith").get(0), requestBody.get("ids")));
    }*/
}
