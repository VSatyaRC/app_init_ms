package in.appinit.appconfig.model.access;

public class ModelPropertyAccess {
    String id;
    AccessType accessType;
    String propertyName;

    public ModelPropertyAccess() {
    }

    public ModelPropertyAccess(String id, AccessType accessType, String propertyName) {
        this.id = id;
        this.accessType = accessType;
        this.propertyName = propertyName;
    }

    public String getId() {
        return id;
    }

    public AccessType getAccessType() {
        return accessType;
    }

    public void setAccessType(AccessType accessType) {
        this.accessType = accessType;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
}
