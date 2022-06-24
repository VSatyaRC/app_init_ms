package in.appinit.appinitpages.widgets;


import in.appinit.appinitpages.widget_config.style.StyleConfig;

public class TextWidget extends SimpleWidget {
   /* @Id
    String id;*/

    public TextWidget() {
    }

    @Override
    public String widgetName() {
        return "Text";
    }

    @Override
    public StyleConfig instanceWithConfig() {
        return textWidgetConfig();
    }

    public static StyleConfig textWidgetConfig() {
        StyleConfig styleConfig = new StyleConfig("", "", "Text");
        styleConfig.appendConfig("text", "Click to edit");
        styleConfig.appendConfig("fontWeight", 4);
        styleConfig.appendConfig("fontSize", 14);
        styleConfig.appendConfig("color", "#000000");
        return styleConfig;
    }
}
