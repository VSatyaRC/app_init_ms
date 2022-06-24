package in.appinit.appinitpages.widgets;

import in.appinit.appinitpages.widget_config.style.StyleConfig;

public class CopiedWidget extends SimpleWidget {
    /* @Id
     String id;*/
    String copyOf;

    public CopiedWidget() {

    }


    @Override
    public String widgetName() {
        return "Copy";
    }

    @Override
    public StyleConfig instanceWithConfig() {
        return new StyleConfig("","","Copy");
    }

    public String getCopyOf() {
        return copyOf;
    }

    public void setCopyOf(String copyOf) {
        this.copyOf = copyOf;
    }
}
