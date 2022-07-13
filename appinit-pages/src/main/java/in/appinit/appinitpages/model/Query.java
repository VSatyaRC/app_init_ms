package in.appinit.appinitpages.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import in.appinit.appinitpages.model.datamodel.Model;
import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Query {

    @Id
    String id;

    @JsonIgnore
    String appId;
    String name;
    Model modelToQuery;
    Map<String, Filter> filters = new LinkedHashMap<>();
    Map<String, FilterGroup> filterGroups = new LinkedHashMap<>();

    Set<String> resultTypes = new HashSet<>();

    public Query() {

    }

    public void setId(String id) {
        this.id = id;
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

    public Model getModelToQuery() {
        return modelToQuery;
    }

    public void setModelToQuery(Model modelToQuery) {
        this.modelToQuery = modelToQuery;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Filter> getFilters() {
        return filters;
    }

    public void setFilters(Map<String, Filter> filters) {
        this.filters = filters;
    }

    public Map<String, FilterGroup> getFilterGroups() {
        return filterGroups;
    }

    public void setFilterGroups(Map<String, FilterGroup> filterGroups) {
        this.filterGroups = filterGroups;
    }

    public Set<String> getResultTypes() {
        return resultTypes;
    }

    public void setResultTypes(Set<String> resultTypes) {
        this.resultTypes = resultTypes;
    }
}