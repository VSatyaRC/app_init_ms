package in.appinit.appinitpages.services;


import com.google.gson.Gson;
import in.appinit.appinitpages.model.variable.Variable;
import in.appinit.appinitpages.repositories.VariableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class VariableService {

    @Autowired
    VariableRepository variableRepository;

    @Autowired
    Gson gson;


    public Variable saveVariable(String appId, Variable variable) {
        variable.setAppId(appId);
        Logger.getLogger("VariableService").log(Level.INFO, gson.toJson(variable));
        return variableRepository.save(variable);
    }

    public Variable getVariable(String id) {
        Optional<Variable> optionalVariable = variableRepository.findById(id);
        return optionalVariable.orElseGet(Variable::new);
    }

    public Map<String, List<Variable>> getAllVariables(String appId) {
        Map<String, List<Variable>> response = new HashMap<>();
        response.put("variables", variableRepository.findAllByAppId(appId));
        return response;
    }

    public Map<String, List<Variable>> saveAll(String appId, List<Variable> variables) {
        Map<String, List<Variable>> response = new HashMap<>();
        response.put("variables", variableRepository.saveAll(variables));
        return response;
    }

    public void deleteAllVariables() {
        variableRepository.deleteAll();
    }

    public void deleteVariables(String appId) {
        variableRepository.deleteAllByAppId(appId);
    }

    public void deleteVariable(String id) {
        System.out.println("Deleting: " + id);
        variableRepository.deleteById(id);
    }
}
