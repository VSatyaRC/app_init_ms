package in.appinit.appconfig.model.access;

public class AccessDetails {
    AccessType accessType;
    String id;
    String name;
    String type;

    public AccessDetails() {

    }

    public AccessDetails(AccessType accessType, String name, String type) {
        this.accessType = accessType;
        this.name = name;
        this.type = type;
    }

    public AccessType getAccessType() {
        return accessType;
    }

    public void setAccessType(AccessType accessType) {
        this.accessType = accessType;
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
}
