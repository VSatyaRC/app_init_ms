package in.appinit.appinitpages.model.variable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Map;

public class Variable {
    String id;

    @JsonIgnore
    String appId;
    String name;
    Map<String, Object> valueDetails;

    String type;

    String description;

    public Variable() {
    }

    public String getId() {
        return id;
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

    public Map<String, Object> getValueDetails() {
        return valueDetails;
    }

    public void setValueDetails(Map<String, Object> valueDetails) {
        this.valueDetails = valueDetails;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name + " " + this.description + " " + this.id;
    }
}
