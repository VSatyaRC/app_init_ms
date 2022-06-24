package in.appinit.appinitpages.widgets;

import in.appinit.appinitpages.widget_config.style.StyleConfig;

public class ImageWidget extends SimpleWidget {
    /* @Id
     String id;*/
    public ImageWidget() {

    }

    @Override
    public String widgetName() {
        return "Image";
    }

    @Override
    public StyleConfig instanceWithConfig() {
        StyleConfig styleConfig = new StyleConfig("", "", "Image");
        styleConfig.appendConfig("url", "");
        return styleConfig;
    }

}
