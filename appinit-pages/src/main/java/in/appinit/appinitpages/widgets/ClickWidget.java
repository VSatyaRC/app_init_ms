package in.appinit.appinitpages.widgets;

import in.appinit.appinitpages.widget_config.style.StyleConfig;

public class ClickWidget extends SingleChildWidget {

    @Override
    public String widgetName() {
        return "Click";
    }

    @Override
    public StyleConfig instanceWithConfig() {
        return new StyleConfig("","","Click");
    }
}
