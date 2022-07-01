package in.appinit.appinitpages.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import in.appinit.appinitpages.model.task.CrUpTask;
import in.appinit.appinitpages.model.task.SimpleTask;
import org.springframework.data.annotation.Id;

import java.util.List;

public class Event {
    @Id
    String id;
    String name;
    String type;

    @JsonIgnore
    String appId;

    List<SimpleTask> tasks;

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

    public List<SimpleTask> getTasks() {
        return tasks;
    }

    public void setTasks(List<SimpleTask> tasks) {
        this.tasks = tasks;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}
