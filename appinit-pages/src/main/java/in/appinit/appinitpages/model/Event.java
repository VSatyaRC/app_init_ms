package in.appinit.appinitpages.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import in.appinit.appinitpages.model.task.CrUpTask;
import org.springframework.data.annotation.Id;

import java.util.List;

public class Event {
    @Id
    String id;
    String name;
    String type;

    @JsonIgnore
    String appId;

    List<CrUpTask> crUpTasks;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<CrUpTask> getTasks() {
        return crUpTasks;
    }

    public void setTasks(List<CrUpTask> crUpTasks) {
        this.crUpTasks = crUpTasks;
    }



    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}
