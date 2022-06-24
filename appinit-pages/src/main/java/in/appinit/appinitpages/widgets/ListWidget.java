package in.appinit.appinitpages.widgets;

import in.appinit.appinitpages.widget_config.style.StyleConfig;

public class ListWidget extends SingleChildWidget {

    @Override
    public String widgetName() {
        return "List";
    }

    @Override
    public StyleConfig instanceWithConfig() {
        return new StyleConfig("", "", "List");
    }
}
