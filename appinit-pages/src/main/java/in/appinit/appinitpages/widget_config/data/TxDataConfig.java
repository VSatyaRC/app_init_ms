package in.appinit.appinitpages.widget_config.data;

import in.appinit.appinitpages.widget_config.WidgetConfig;

public class TxDataConfig extends WidgetConfig {

    DataConfig dataConfig;

    public TxDataConfig() {
    }

    TxDataConfig(String widgetKey) {
        super(widgetKey);
    }

    @Override
    public String getType() {
        return "DATA";
    }



    public DataConfig getDataConfig() {
        return dataConfig;
    }

    public void setDataConfig(DataConfig dataConfig) {
        this.dataConfig = dataConfig;
    }
}
