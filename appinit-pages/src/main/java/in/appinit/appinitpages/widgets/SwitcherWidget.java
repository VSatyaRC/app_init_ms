package in.appinit.appinitpages.widgets;

import in.appinit.appinitpages.widget_config.style.StyleConfig;

import java.util.HashMap;
import java.util.Map;

public class SwitcherWidget extends MultiChildWidget {
   /* @Id
    String id;*/

    public SwitcherWidget() {

    }

    @Override
    public String widgetName() {
        return "Switcher";
    }

    @Override
    public StyleConfig instanceWithConfig() {
        StyleConfig styleConfig = new StyleConfig("", "", "Switcher");
        Map<String, Object> configMap = new HashMap<>();
        styleConfig.appendConfig(configMap);
        return styleConfig;
    }

    String activeChild;

    public String getActiveChild() {
        return activeChild;
    }

    public void setActiveChild(String activeChild) {
        this.activeChild = activeChild;
    }
}
