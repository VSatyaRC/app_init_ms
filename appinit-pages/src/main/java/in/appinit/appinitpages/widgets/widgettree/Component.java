package in.appinit.appinitpages.widgets.widgettree;


import in.appinit.appinitpages.widgets.SimpleWidget;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class Component {

    @Id
    String id;

    String componentName;

    String rootKey;
    List<SimpleWidget> widgetsList = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRootKey() {
        return rootKey;
    }

    public void setRootKey(String rootKey) {
        this.rootKey = rootKey;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public List<SimpleWidget> getWidgetsList() {
        return widgetsList;
    }

    public void setWidgetsList(List<SimpleWidget> widgetsList) {
        this.widgetsList = widgetsList;
    }

}
