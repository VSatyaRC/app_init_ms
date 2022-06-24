package in.appinit.appinitpages.widgets;


import in.appinit.appinitpages.widget_config.style.StyleConfig;

public abstract class SimpleWidget extends SuperWidget {


    protected SimpleWidget() {
        super.simpleName = widgetName();
        /*Danger do not uncomment this, do it  only if you want to save init config to db*/
        //this.styleConfig = instanceWithConfig();
    }

    StyleConfig styleConfig;

    abstract String widgetName();

    public abstract StyleConfig instanceWithConfig();

    public StyleConfig getStyleConfig() {
        return styleConfig;
    }

    public void setStyleConfig(StyleConfig styleConfig) {
        this.styleConfig = styleConfig;
    }
}








