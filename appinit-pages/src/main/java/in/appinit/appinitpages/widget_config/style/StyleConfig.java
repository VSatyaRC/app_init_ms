package in.appinit.appinitpages.widget_config.style;

import in.appinit.appinitpages.widget_config.WidgetConfig;
import org.springframework.data.annotation.Id;

import java.util.HashMap;
import java.util.Map;

public class StyleConfig extends WidgetConfig {

    @Id
    String id;
    private String txKey = "";
    //key => option_name

    private String widgetName;

    private Map<String, Object> configMap = new HashMap<>();

    public StyleConfig() {

    }

    public StyleConfig(String widgetKey) {
        super(widgetKey);
    }

    public StyleConfig(String widgetKey, String txKey, String widgetName) {
        super(widgetKey);
        this.txKey = txKey;
        this.widgetName = widgetName;
    }

    @Override
    public String getType() {
        return "STYLE";
    }

    public String getWidgetName() {
        return widgetName;
    }

    public void setWidgetName(String widgetName) {
        this.widgetName = widgetName;
    }

    public String getTxKey() {
        return txKey;
    }

    public void setTxKey(String txKey) {
        this.txKey = txKey;
    }

    public Map<String, Object> getConfigMap() {
        return configMap;
    }

    public Map<String, Object> setConfigMap(Map<String, Object> configMap) {
        return this.configMap = configMap;
    }

    public Object getTxValue() {
        if (txKey.matches("")) {
            return "NA";
        }
        return configMap.get(txKey);
    }

    public void appendConfig(String configName, Object configValue) {
        this.configMap.put(configName, configValue);
    }

    public void appendConfig(Map<String, Object> configMap) {
        this.configMap.putAll(configMap);
    }


}


