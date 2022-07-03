package in.appinit.appinitpages.model.variable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashMap;
import java.util.Map;

public class Variable {
    String id;
    String name;
    String type;
    String testValue;

    @JsonIgnore
    String appId;
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

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getTestValue() {
        return testValue;
    }

    public void setTestValue(String testValue) {
        this.testValue = testValue;
    }

    @Override
    public String toString() {
        return "Variable{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", varArgs=" + varArgs +
                ", varParams=" + varParams +
                '}';
    }
}