package in.appinit.appinitpages.model;

import in.appinit.appinitpages.model.datamodel.Property;
import in.appinit.appinitpages.model.variable.Variable;

public class ExpressionItemValue {

    String txDataConfigType;
    Property simpleProperty;
    Variable variable;
    String textInput;
    String itemType;

    public ExpressionItemValue() {
    }

    public String getTxDataConfigType() {
        return txDataConfigType;
    }

    public void setTxDataConfigType(String txDataConfigType) {
        this.txDataConfigType = txDataConfigType;
    }

    public Property getSimpleProperty() {
        return simpleProperty;
    }

    public void setSimpleProperty(Property simpleProperty) {
        this.simpleProperty = simpleProperty;
    }

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    public String getTextInput() {
        return textInput;
    }

    public void setTextInput(String textInput) {
        this.textInput = textInput;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
}
