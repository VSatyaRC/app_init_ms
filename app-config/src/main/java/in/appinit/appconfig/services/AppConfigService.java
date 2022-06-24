package in.appinit.appconfig.services;

import in.appinit.appconfig.model.AppConfig;
import in.appinit.appconfig.repositories.AppConfigRepository;
import in.appinit.appconfig.repositories.AppsRepository;
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
    AppConfigRepository appConfigRepository;

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
}
