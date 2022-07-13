package in.appinit.appconfig.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CustomApi {
    @Id
    String id;
    String name;
    String url;
    String requestMethod; //request method
    Map<String, String> headers;
    Set<String> params;
    String payloadType;

    Set<String> responseKeys = new HashSet<>();


    @JsonIgnore
    String appId;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Set<String> getParams() {
        return params;
    }

    public void setParams(Set<String> params) {
        this.params = params;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getPayloadType() {
        return payloadType;
    }

    public void setPayloadType(String payloadType) {
        this.payloadType = payloadType;
    }

    public Set<String> getResponseKeys() {
        return responseKeys;
    }

    public void setResponseKeys(Set<String> responseKeys) {
        this.responseKeys = responseKeys;
    }
}
