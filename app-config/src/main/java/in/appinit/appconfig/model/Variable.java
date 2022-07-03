package in.appinit.appconfig.model;

import java.util.HashMap;
import java.util.Map;

public class Variable {
    String id;
    String name;
    String type;

    String testValue;
    Map<String, Object> varArgs = new HashMap<>();
    Map<String, Object> varParams = new HashMap<>();

    public Variable() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTestValue() {
        return testValue;
    }

    public void setTestValue(String testValue) {
        this.testValue = testValue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Object> getVarArgs() {
        return varArgs;
    }

    public void setVarArgs(Map<String, Object> varArgs) {
        this.varArgs = varArgs;
    }

    public Map<String, Object> getVarParams() {
        return varParams;
    }

    public void setVarParams(Map<String, Object> varParams) {
        this.varParams = varParams;
    }
}
