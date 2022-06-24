package in.appinit.appinitpages.model;

import in.appinit.appinitpages.model.datamodel.Model;

import java.util.ArrayList;
import java.util.List;

public class ModelTransformation {

    Model simpleModel;
    List<PropertyTransformation> propertyTransformations = new ArrayList();

    public Model getSimpleModel() {
        return simpleModel;
    }

    public void setSimpleModel(Model simpleModel) {
        this.simpleModel = simpleModel;
    }

    public List<PropertyTransformation> getPropertyTransformations() {
        return propertyTransformations;
    }

    public void setPropertyTransformations(List<PropertyTransformation> propertyTransformations) {
        this.propertyTransformations = propertyTransformations;
    }
}
