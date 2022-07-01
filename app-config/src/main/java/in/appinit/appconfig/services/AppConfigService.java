package in.appinit.appconfig.services;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import in.appinit.appconfig.model.AppConfig;
import in.appinit.appconfig.repositories.AppConfigRepository;
import in.appinit.appconfig.repositories.AppsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class AppConfigService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    AppsRepository appsRepository;

    @Autowired
    Gson gson;

    @Autowired
    AppConfigRepository appConfigRepository;

    @Autowired
    ScreenConfigServices screenConfigServices;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public AppConfig initApp(String appName, MultipartFile multipartFile) {
        AppConfig appConfig = new AppConfig();
        appConfig.setName(appName);
        appConfig.setIcon(uploadAppIcon(multipartFile));
        return appConfigRepository.save(appConfig);
    }

    public String uploadAppIcon(MultipartFile multipartFile) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body
                = new LinkedMultiValueMap<>();
        body.add("file", multipartFile.getResource());

        HttpEntity<MultiValueMap<String, Object>> requestEntity
                = new HttpEntity<>(body, headers);

        String serverUrl = "http://appinit-files/resource/upload";
        ResponseEntity<Map> response = restTemplate.postForEntity(serverUrl, requestEntity, Map.class);
        return response.getStatusCodeValue() == 200 ? (String) Objects.requireNonNull(response.getBody()).get("filename") : "";
    }

    public void deleteAll() {
        appConfigRepository.deleteAll();
    }

    public List<AppConfig> allApps() {
        return appConfigRepository.findAll();
    }

    public AppConfig updateAppName(String appId, String name) {
        AppConfig appConfig = appConfigRepository.findById(appId).get();
        appConfig.setName(name);
        return appConfigRepository.save(appConfig);
    }

    public AppConfig updateAppIcon(String appId, MultipartFile appLogo) {
        String newUrl = uploadAppIcon(appLogo);
        AppConfig appConfig = appConfigRepository.findById(appId).get();
        appConfig.setName(newUrl);
        return appConfigRepository.save(appConfig);
    }

    public void initAppData(MultipartFile data) {

    }

    public String exportAppConfig(String appId) {
        String appDetails = gson.toJson(appConfigRepository.findById(appId).orElse(new AppConfig()));

        JsonObject eventsJson = gson.fromJson(importEvents(appId), JsonObject.class);
        JsonObject tasksJson = gson.fromJson(importTasks(appId), JsonObject.class);
        JsonObject variablesJson = gson.fromJson(importVariables(appId), JsonObject.class);

        JsonObject response = new JsonObject();
        response.add("appDetails", gson.fromJson(appDetails, JsonObject.class));
        response.add("screens", gson.fromJson(gson.toJson(screenConfigServices.findAllByAppId(appId)), JsonArray.class));
        response.add("events", eventsJson.getAsJsonArray("events"));
        response.add("tasks", tasksJson.getAsJsonArray("tasks"));
        response.add("variables", variablesJson.getAsJsonArray("variables"));

        return gson.toJson(response);
    }

    public String importQueries(String appId) {
        String response = restTemplate.getForObject("http://appinit-pages/page-config/" + appId + "/queries", String.class);
        logger.debug("All Queries", response);
        return response;
    }

    public String importEvents(String appId) {
        String response = restTemplate.getForObject("http://appinit-pages/page-config/" + appId + "/events", String.class);
        logger.debug("All Events", response);
        return response;
    }

    public String importVariables(String appId) {
        String response = restTemplate.getForObject("http://appinit-pages/page-config/" + appId + "/variables", String.class);
        logger.debug("All Variables", response);
        return response;
    }

    public String importTasks(String appId) {
        String response = restTemplate.getForObject("http://appinit-pages/page-config/" + appId + "/tasks", String.class);
        logger.debug("All Tasks", response);
        return response;
    }
}
