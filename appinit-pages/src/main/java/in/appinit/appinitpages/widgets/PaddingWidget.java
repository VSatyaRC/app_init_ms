package in.appinit.appinitpages.widgets;

import in.appinit.appinitpages.widget_config.style.StyleConfig;

public class PaddingWidget extends SingleChildWidget {
    /* @Id
     String id;*/

    public PaddingWidget() {

    }

    @Override
    public String widgetName() {
        return "Padding";
    }

    @Override
    public StyleConfig instanceWithConfig() {
       return  paddingWidgetConfig();
    }


    private StyleConfig paddingWidgetConfig() {
        StyleConfig styleConfig = new StyleConfig("", "", "Padding");
        styleConfig.appendConfig("all", 8.0);
        return styleConfig;
    }

}
