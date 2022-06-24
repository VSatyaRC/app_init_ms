package in.appinit.appinitpages.widget_config.data;

import in.appinit.appinitpages.model.Query;
import in.appinit.appinitpages.model.datamodel.Property;

public class DataConfig {

    // key => key is the key in configMap of StyleConfig,
    // useful when there are multiple configurable items
    // that can accept dataConfig.
    String key;
    Query query;
    Property property;

    public DataConfig() {
    }

    public DataConfig(String key, Query query, Property property) {
        this.key = key;
        this.query = query;
        this.property = property;
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
