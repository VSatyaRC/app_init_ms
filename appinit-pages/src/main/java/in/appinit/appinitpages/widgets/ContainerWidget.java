package in.appinit.appinitpages.widgets;

import in.appinit.appinitpages.widget_config.style.StyleConfig;

public class ContainerWidget extends SingleChildWidget {
    /* @Id
     String id;*/

    public ContainerWidget() {
    }

    @Override
    public String widgetName() {
        return "Container";
    }

    @Override
    public StyleConfig instanceWithConfig() {
        return new StyleConfig("","","Container");
    }


}
