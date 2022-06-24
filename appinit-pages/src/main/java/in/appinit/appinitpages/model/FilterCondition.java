package in.appinit.appinitpages.model;

public class FilterCondition {

    String key;
    String displayName;
    String description;

    public FilterCondition() {

    }

    public FilterCondition(String key, String paramsType, String displayName) {

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
