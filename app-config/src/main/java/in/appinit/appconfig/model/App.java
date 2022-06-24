package in.appinit.appconfig.model;

import in.appinit.appconfig.model.access.Role;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document
public class App {

    @Id
    String id;
    String name;

    Map<String, Role> accessConfig;

    AppData appData;
    AppConfig appConfig;

    public App() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Role> getAccessConfig() {
        return accessConfig;
    }

    public void setAccessConfig(Map<String, Role> accessConfig) {
        this.accessConfig = accessConfig;
    }

    public AppData getAppData() {
        return appData;
    }

    public void setAppData(AppData appData) {
        this.appData = appData;
    }

    public AppConfig getAppConfig() {
        return appConfig;
    }

    public void setAppConfig(AppConfig appConfig) {
        this.appConfig = appConfig;
    }
}
