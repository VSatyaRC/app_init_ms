package in.appinit.appinitpages;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import in.appinit.appinitpages.widgets.*;

/*This class is used during serialization*/
public class WidgetMapperUtil {

    public static SimpleWidget mapWidget(JsonObject simpleWidget) {
        System.out.println("*********************\n" + simpleWidget.toString());
        switch (simpleWidget.get("simpleName").getAsString()) {
            case "Root":
                return new Gson().fromJson(simpleWidget, RootWidget.class);
            case "Row":
                return new Gson().fromJson(simpleWidget, RowWidget.class);
            case "AppBar":
                return new Gson().fromJson(simpleWidget, AppBarWidget.class);
            case "Column":
                return new Gson().fromJson(simpleWidget, ColumnWidget.class);
            case "Text":
                return new Gson().fromJson(simpleWidget, TextWidget.class);
            case "TextField":
                return new Gson().fromJson(simpleWidget, TextFieldWidget.class);
            case "Image":
                return new Gson().fromJson(simpleWidget, ImageWidget.class);
            case "Expanded":
                return new Gson().fromJson(simpleWidget, ExpandedWidget.class);
            case "Container":
                return new Gson().fromJson(simpleWidget, ContainerWidget.class);
            case "Card":
                return new Gson().fromJson(simpleWidget, CardWidget.class);
            case "Padding":
                return new Gson().fromJson(simpleWidget, PaddingWidget.class);
            case "List":
                return new Gson().fromJson(simpleWidget, ListWidget.class);
            case "Click":
                return new Gson().fromJson(simpleWidget, ClickWidget.class);
            default:
                return new Gson().fromJson(simpleWidget, SimpleWidget.class);
        }
    }

    public static SimpleWidget widgetWithInitConfig(String simpleName) {

        switch (simpleName) {
            case "Root":
                return new RootWidget();
            case "Row":
                return new RowWidget();
            case "AppBar":
                return new AppBarWidget();
            case "Column":
                return new ColumnWidget();
            case "Text":
                return new TextWidget();
            case "TextField":
                return new TextFieldWidget();
            case "Image":
                return new ImageWidget();
            case "Expanded":
                return new ExpandedWidget();
            case "Container":
                return new ContainerWidget();
            case "Card":
                return new CardWidget();
            case "Padding":
                return new PaddingWidget();
            case "List":
                return new ListWidget();
            case "Click":
                return new ClickWidget();
            default:
                return new TextWidget();
        }
    }




/*

    public WidgetConfig textWidgetConfig() {
    */
/*
    String color;
    Color backgroundColor;
    String fontFamily;
    double fontSize;
    int fontWeight;
    String fontStyle;
    double letterSpacing;
    double wordSpacing;
    String textBaseline;
    String locale;
    Paint foreground;
    Paint background;
    String overflow;*//*


        WidgetConfig widgetConfig = new TextWidgetConfig();
        widgetConfig.appendConfig("color", "#757575");

        TextConfig valueOne = new TextConfig();
        valueOne.setValue("Click to edit");
        valueOne.setType("String");

        TextConfig valueTwo = new TextConfig();
        PropertyConfig propertyConfig = new PropertyConfig();
        propertyConfig.setPropertyId("property-id");
        propertyConfig.setPropertyName("propertyName");
        valueTwo.setValue(propertyConfig);
        valueTwo.setType("Property");

        List<TextConfig> dynamicText = new ArrayList<>();
        dynamicText.add(valueOne);
        dynamicText.add(valueTwo);

        widgetConfig.appendConfig("text", dynamicText);
        widgetConfig.appendConfig("fontWeight", 400);
        return widgetConfig;
    }
*/


}
