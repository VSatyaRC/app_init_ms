package in.appinit.appconfig.model.screens;

import com.fasterxml.jackson.annotation.JsonIgnore;
import in.appinit.appconfig.model.Variable;
import in.appinit.appconfig.model.access.Role;
import in.appinit.appconfig.model.events.Event;
import in.appinit.appconfig.model.task.Task;
import org.springframework.data.annotation.Id;

import java.util.List;

public class ScreenInfo {

    @Id
    String id;
    @JsonIgnore
    String appId;
    List<Role> roleList;

    Layout layout;
    String screenName;

    List<Event> pageEvents;
    List<Query> pageQueries;
    List<Task> pageTasks;
    List<Variable> pageVariables;

    public ScreenInfo() {
    }

    public ScreenInfo(String id, String appId, List<Role> roleList) {
        this.id = id;
        this.appId = appId;
        this.roleList = roleList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public List<Event> getPageEvents() {
        return pageEvents;
    }

    public void setPageEvents(List<Event> pageEvents) {
        this.pageEvents = pageEvents;
    }

    public List<Task> getPageTasks() {
        return pageTasks;
    }

    public void setPageTasks(List<Task> pageTasks) {
        this.pageTasks = pageTasks;
    }

    public List<Variable> getPageVariables() {
        return pageVariables;
    }

    public void setPageVariables(List<Variable> pageVariables) {
        this.pageVariables = pageVariables;
    }

    public List<Query> getPageQueries() {
        return pageQueries;
    }

    public void setPageQueries(List<Query> pageQueries) {
        this.pageQueries = pageQueries;
    }

    public Layout getLayout() {
        return layout;
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }
}
