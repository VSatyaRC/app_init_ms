package in.appinit.appconfig.model.access;

import java.util.List;

public class DataModelAccess {

    String id;
    AccessType accessType;
    String modelName;
    List<ModelPropertyAccess> propertiesAccess;

    public DataModelAccess() {
    }

    public DataModelAccess(String id, AccessType accessType, String modelName, List<ModelPropertyAccess> propertiesAccess) {
        this.id = id;
        this.accessType = accessType;
        this.modelName = modelName;
        this.propertiesAccess = propertiesAccess;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AccessType getAccessType() {
        return accessType;
    }

    public void setAccessType(AccessType accessType) {
        this.accessType = accessType;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public List<ModelPropertyAccess> getPropertiesAccess() {
        return propertiesAccess;
    }

    public void setPropertiesAccess(List<ModelPropertyAccess> propertiesAccess) {
        this.propertiesAccess = propertiesAccess;
    }

    ;

}
