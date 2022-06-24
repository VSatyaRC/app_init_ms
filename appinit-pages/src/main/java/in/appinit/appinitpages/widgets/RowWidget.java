package in.appinit.appinitpages.widgets;


import in.appinit.appinitpages.widget_config.style.StyleConfig;

public class RowWidget extends MultiChildWidget {
   /* @Id
    String id;*/

    public RowWidget() {

    }


    @Override
    String widgetName() {
        return "Row";
    }

    @Override
    public StyleConfig instanceWithConfig() {
        return multiChildConfig("Row");
    }

}
