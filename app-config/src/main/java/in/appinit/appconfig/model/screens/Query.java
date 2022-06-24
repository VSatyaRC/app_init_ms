package in.appinit.appconfig.model.screens;

import org.springframework.data.annotation.Id;
import org.springframework.ui.Model;

public class Query {

    @Id
    String id;

    String name;
    Model modelToQuery;

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

    public Model getModelToQuery() {
        return modelToQuery;
    }

    public void setModelToQuery(Model modelToQuery) {
        this.modelToQuery = modelToQuery;
    }
}
