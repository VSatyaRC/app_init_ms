package in.appinit.appinitpages.widget_config.event;

import in.appinit.appinitpages.model.Event;
import in.appinit.appinitpages.widget_config.WidgetConfig;

public class TxEventConfig extends WidgetConfig {

    Event event;

    TxEventConfig(String widgetKey) {
        super(widgetKey);
    }

    @Override
    public String getType() {
        return "EVENT";
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
