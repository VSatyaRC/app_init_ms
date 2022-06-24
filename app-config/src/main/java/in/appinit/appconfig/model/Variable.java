package in.appinit.appconfig.model;

import java.util.HashMap;
import java.util.Map;

public class Variable {
    String id;
    String name;
    String type;
    Map<String, Object> valueDetails = new HashMap<>();

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Object> getValueDetails() {
        return valueDetails;
    }

    public void setValueDetails(Map<String, Object> valueDetails) {
        this.valueDetails = valueDetails;
    }
}
