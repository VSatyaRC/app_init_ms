package in.appinit.model.models.tx;

import java.util.List;

public class TxModel {

    String modelId;
    String modelName;
    List<TxProperty> propertyValuesList;

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public List<TxProperty> getPropertyValuesList() {
        return propertyValuesList;
    }

    public void setPropertyValuesList(List<TxProperty> propertyValuesList) {
        this.propertyValuesList = propertyValuesList;
    }


}
