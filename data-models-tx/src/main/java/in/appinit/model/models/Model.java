package in.appinit.model.models;

import java.util.List;

public class Model {
    String id;
    String name;
    List<Property> properties;

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

    @Override
    public String toString() {
        return "DataModel{" + "id='" + id + '\'' + ", modelName='" + name + '\'' + ", properties=" + properties.toString() + '}';
    }

    public Property getProperty(Property property) {
        for (Property modelProperty : this.getProperties()) {
            if (modelProperty.name.matches(property.name)) {
                return modelProperty;
            }
        }
        return new Property();
    }
}
