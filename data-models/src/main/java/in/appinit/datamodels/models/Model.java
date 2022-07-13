package in.appinit.datamodels.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class Model {

    @Id
    String id;

    @JsonIgnore
    String appId;
    String name;
    List<Property> properties = new ArrayList<>();

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Override
    public String toString() {
        return "DataModel{" + "id='" + id + '\'' + ", modelName='" + name + '\'' + ", properties=" + properties.toString() + '}';
    }
}
