package in.appinit.appconfig.services;


import in.appinit.appconfig.model.CustomApi;
import in.appinit.appconfig.repositories.CustomApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CustomApiService {

    @Autowired
    CustomApiRepository customApiRepository;

    public CustomApi saveCustomApi(String appId, CustomApi customApi) {
        customApi.setAppId(appId);
        return customApiRepository.save(customApi);
    }

    public CustomApi getCustomApi(String id) {
        Optional<CustomApi> optionalCustomApi = customApiRepository.findById(id);
        return optionalCustomApi.orElseGet(CustomApi::new);
    }

    public Map<String, List<CustomApi>> getAllCustomApis(String appId) {
        Map<String, List<CustomApi>> response = new HashMap<>();
        response.put("customApis", customApiRepository.findAllByAppId(appId));
        return response;
    }

    public Map<String, List<CustomApi>> saveAll(String appId, List<CustomApi> customApis) {
        Map<String, List<CustomApi>> response = new HashMap<>();
        response.put("customApis", customApiRepository.saveAll(customApis));
        return response;
    }

    public void deleteAllCustomApis() {
        customApiRepository.deleteAll();
    }

    public void deleteCustomApis(String appId) {
        customApiRepository.deleteAllByAppId(appId);
    }

    public void deleteCustomApi(CustomApi customApi) {
        customApiRepository.delete(customApi);
    }
}
