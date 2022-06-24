package in.appinit.appinitpages.model.task;

import in.appinit.appinitpages.model.ScreenInfo;
import in.appinit.appinitpages.model.variable.Variable;

import java.util.List;

public class PageTransitionTask extends SimpleTask {
    ScreenInfo transitionTo;
    List<Variable> variables;

    public ScreenInfo getTransitionTo() {
        return transitionTo;
    }

    public void setTransitionTo(ScreenInfo transitionTo) {
        this.transitionTo = transitionTo;
    }

    public List<Variable> getVariables() {
        return variables;
    }

    public void setVariables(List<Variable> variables) {
        this.variables = variables;
    }
}
