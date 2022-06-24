package in.appinit.appinitpages.model;

import in.appinit.appinitpages.model.datamodel.Property;

import java.util.ArrayList;
import java.util.List;

public class PropertyTransformation {

    Property simpleProperty;
    List<ExpressionItem> expressionTree = new ArrayList<>();

    public Property getSimpleProperty() {
        return simpleProperty;
    }

    public void setSimpleProperty(Property simpleProperty) {
        this.simpleProperty = simpleProperty;
    }

    public List<ExpressionItem> getExpressionTree() {
        return expressionTree;
    }

    public void setExpressionTree(List<ExpressionItem> expressionTree) {
        this.expressionTree = expressionTree;
    }
}
