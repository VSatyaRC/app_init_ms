package in.appinit.appinitpages.widget_config;

public abstract class WidgetConfig {
    String widgetKey;

    String type;

    public abstract String getType();

    public void setType(String type) {
        this.type = type;
    }

    public String getWidgetKey() {
        return widgetKey;
    }

    public void setWidgetKey(String widgetKey) {
        this.widgetKey = widgetKey;
    }

    public WidgetConfig() {
    }

    public WidgetConfig(String widgetKey) {
        this.widgetKey = widgetKey;
        this.type = getType();
    }
}
