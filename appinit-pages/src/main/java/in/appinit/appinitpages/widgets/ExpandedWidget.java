package in.appinit.appinitpages.widgets;

import in.appinit.appinitpages.widget_config.style.StyleConfig;

public class ExpandedWidget extends SingleChildWidget {
    /* @Id
     String id;*/
    public ExpandedWidget() {
    }

    @Override
    public String widgetName() {
        return "Expanded";
    }

    @Override
    public StyleConfig instanceWithConfig() {
        StyleConfig styleConfig = new StyleConfig("", "", "Expanded");
        styleConfig.appendConfig("flex", 1);
        return styleConfig;
    }
}