package in.appinit.appinitpages.widgets;

import in.appinit.appinitpages.widget_config.style.StyleConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class MultiChildWidget extends SimpleWidget {

    List<String> children = new ArrayList<>();

    public MultiChildWidget() {
    }

    public List<String> getChildren() {
        return children;
    }

    public void setChildren(List<String> children) {
        this.children = children;
    }

    public static StyleConfig multiChildConfig(String widgetName) {
        StyleConfig styleConfig = new StyleConfig("", "",  widgetName);
        Map<String, Object> configMap = new HashMap<>();
        styleConfig.appendConfig("mainAxisDetails", "LEFT");
        styleConfig.appendConfig("crossAxisDetails", "LEFT");
        styleConfig.appendConfig(configMap);
        return styleConfig;
    }
}
