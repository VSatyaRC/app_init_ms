package in.appinit.appinitpages.model;

import in.appinit.appinitpages.model.variable.Variable;

import java.util.ArrayList;
import java.util.List;

public class ScreenInfo {
    String id;
    String screenName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    List<Variable> pageVariables = new ArrayList<>();

    public List<Variable> getPageVariables() {
        return pageVariables;
    }

    public void setPageVariables(List<Variable> pageVariables) {
        this.pageVariables = pageVariables;
    }
}
