package in.appinit.appinitpages.widgets;

import in.appinit.appinitpages.widget_config.style.StyleConfig;

public class ColumnWidget extends MultiChildWidget {
   /* @Id
    String id;*/

    public ColumnWidget() {

    }

    @Override
    public String widgetName() {
        return "Column";
    }

    @Override
    public StyleConfig instanceWithConfig() {
        return multiChildConfig("Column");
    }

}
