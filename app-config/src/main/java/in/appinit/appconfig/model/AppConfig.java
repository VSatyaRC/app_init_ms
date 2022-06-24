package in.appinit.appconfig.model;

import org.springframework.data.annotation.Id;

public class AppConfig {

    @Id
    private String id;
    private String name, icon;

    public AppConfig() {

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
