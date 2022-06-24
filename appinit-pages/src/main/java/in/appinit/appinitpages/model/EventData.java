package in.appinit.appinitpages.model;

import in.appinit.appinitpages.model.datamodel.Model;
import in.appinit.appinitpages.model.datamodel.Property;

import java.util.List;
import java.util.Map;

public class EventData {


    Map<String, Model> models;
    Map<String, Property> properties;

    public Map<String, Model> getModels() {
        return models;
    }

    public void setModels(Map<String, Model> models) {
        this.models = models;
    }

    public Map<String, Property> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Property> properties) {
        this.properties = properties;
    }
}
