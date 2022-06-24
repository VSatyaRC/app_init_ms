package in.appinit.appconfig.model.access;

import com.fasterxml.jackson.annotation.JsonIgnore;
import in.appinit.appconfig.model.access.DataModelAccess;
import org.springframework.data.annotation.Id;

import java.util.List;

public class Role {

    @Id
    String id;

    @JsonIgnore
    String appId;
    String roleName;
    List<DataModelAccess> modelAccess;

    public Role() {
    }

    public String getId() {
        return id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<DataModelAccess> getModelAccess() {
        return modelAccess;
    }

    public void setModelAccess(List<DataModelAccess> modelAccess) {
        this.modelAccess = modelAccess;
    }
}
