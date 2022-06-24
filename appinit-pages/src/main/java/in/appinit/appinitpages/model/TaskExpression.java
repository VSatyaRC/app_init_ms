package in.appinit.appinitpages.model;

import in.appinit.appinitpages.model.datamodel.Property;

import java.util.List;

public class TaskExpression {

    Property rhsProperty;
    List<ExpressionItem> expressionTree;

    public Property getRhsProperty() {
        return rhsProperty;
    }

    public void setRhsProperty(Property rhsProperty) {
        this.rhsProperty = rhsProperty;
    }

    public List<ExpressionItem> getExpressionTree() {
        return expressionTree;
    }

    public void setExpressionTree(List<ExpressionItem> expressionTree) {
        this.expressionTree = expressionTree;
    }
}
