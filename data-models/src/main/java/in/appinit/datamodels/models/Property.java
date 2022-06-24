package in.appinit.datamodels.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;

public class Property {

    @Id
    String id;

    @JsonIgnore
    String appId;
    String name;
    String type;
    String modelName;

    public String getId() {
        return id;
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

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Override
    public String toString() {
        return "ModelProperty{" +
                "id='" + id + '\'' +
                ", propertyName='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
