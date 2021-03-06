package in.appinit.appinitpages.widget_config.data;

import in.appinit.appinitpages.model.Query;
import in.appinit.appinitpages.model.datamodel.Property;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;


public class DataConfig {

    // key => key is the key in configMap of StyleConfig,
    // useful when there are multiple configurable items
    // that can accept dataConfig.
    @Id
    String id;
    String widgetKey;
    String configKey;
    String type;
    String testValue;
    Object value;

    String key;
    Query query;
    Property property;

    public DataConfig() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWidgetKey() {
        return widgetKey;
    }

    public void setWidgetKey(String widgetKey) {
        this.widgetKey = widgetKey;
    }

    public String getConfigKey() {
        return configKey;
    }

    public void setConfigKey(String configKey) {
        this.configKey = configKey;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTestValue() {
        return testValue;
    }

    public void setTestValue(String testValue) {
        this.testValue = testValue;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}
