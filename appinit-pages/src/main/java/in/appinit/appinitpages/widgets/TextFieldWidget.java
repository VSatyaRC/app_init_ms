package in.appinit.appinitpages.widgets;


import in.appinit.appinitpages.widget_config.style.StyleConfig;

public class TextFieldWidget extends SimpleWidget {
   /* @Id
    String id;*/

    public TextFieldWidget() {
    }

    @Override
    public String widgetName() {
        return "TextField";
    }

    @Override
    public StyleConfig instanceWithConfig() {
        return textFieldWidgetConfig();
    }


    private static StyleConfig textFieldWidgetConfig() {
        StyleConfig styleConfig = new StyleConfig("","", "TextField");
        styleConfig.appendConfig("label", "Label");
        styleConfig.appendConfig("hint", "Hint text");
        return styleConfig;
    }
}