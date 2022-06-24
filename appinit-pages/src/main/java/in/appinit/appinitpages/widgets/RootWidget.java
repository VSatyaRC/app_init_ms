package in.appinit.appinitpages.widgets;

import in.appinit.appinitpages.widget_config.style.StyleConfig;

public class RootWidget extends MultiChildWidget {
   /* @Id
    String id;*/

    public RootWidget() {
        super.key = "RootKey";
        super.parentKey = "RootKey";
    }


    @Override
    public String widgetName() {
        return "Root";
    }

    @Override
    public StyleConfig instanceWithConfig() {
       return multiChildConfig("Root");
    }
}
