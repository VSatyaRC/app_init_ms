package in.appinit.appinitpages.widgets;


import in.appinit.appinitpages.widget_config.style.StyleConfig;

public class CardWidget extends SingleChildWidget {
   /* @Id
    String id;*/

    public CardWidget() {

    }


    @Override
    public String widgetName() {
        return "Card";
    }

    @Override
    public StyleConfig instanceWithConfig() {
        StyleConfig styleConfig = new StyleConfig("", "", "Card");
        styleConfig.appendConfig("color", "#FFFFFF");
        styleConfig.appendConfig("elevation", 4);
        styleConfig.appendConfig("radius", 2);
       return  styleConfig;
    }
}