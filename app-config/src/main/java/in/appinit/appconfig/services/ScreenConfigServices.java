package in.appinit.appconfig.services;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import in.appinit.appconfig.model.Variable;
import in.appinit.appconfig.model.events.Event;
import in.appinit.appconfig.model.screens.Layout;
import in.appinit.appconfig.model.screens.Query;
import in.appinit.appconfig.model.screens.ScreenInfo;
import in.appinit.appconfig.model.task.Task;
import in.appinit.appconfig.repositories.ScreenInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScreenConfigServices {

    @Autowired
    ScreenInfoRepository screenInfoRepository;

    @Autowired
    RestTemplate restTemplate;

    @Value(value = "${widgets.ms.url}")
    String initLayoutURL;

    @Autowired
    Gson gson;

    public List<ScreenInfo> findAllByAppId(String appId) {
        return screenInfoRepository.findAllByAppId(appId);
    }


    public ScreenInfo save(String appId, ScreenInfo screenInfo) {
        if (null == screenInfo.getLayout()) {
            initLayoutInScreen(appId, screenInfo);
        }
        screenInfo.setAppId(appId);
        return screenInfoRepository.save(screenInfo);
    }


    public ScreenInfo save(String appId, String screenId, String pageItem, String updateType, Object itemToUpdate) {

//        System.out.println(itemToUpdate.toString());
        ScreenInfo screenInfo = screenInfoRepository.findByIdAndAppId(screenId, appId).get();
//        System.out.println("Updating...");
//        System.out.println(gson.toJson(screenInfo));
        screenInfo.setAppId(appId);

        switch (pageItem.toUpperCase()) {
            case "QUERY":
                appendQueryInScreenInfo(updateType, screenInfo, gson.fromJson((String) itemToUpdate, Query.class));
                break;
            case "EVENT":
                appendEventInScreenInfo(updateType, screenInfo, gson.fromJson((String) itemToUpdate, Event.class));
                break;
            case "TASK":
                appendTaskInScreenInfo(updateType, screenInfo, gson.fromJson((String) itemToUpdate, Task.class));
                break;
            case "VARIABLE":
                appendVariableInScreenInfo(updateType, screenInfo, gson.fromJson((String) itemToUpdate, Variable.class));
                break;
        }

        return screenInfoRepository.save(screenInfo);
    }


    private void appendQueryInScreenInfo(String updateType, ScreenInfo screenInfo, Query query) {
        screenInfo.setPageQueries((null == screenInfo.getPageQueries()) ? new ArrayList<>() : screenInfo.getPageQueries());
        screenInfo.getPageQueries().removeIf(q -> null != q.getId() && q.getId().matches(query.getId()));
        if (!updateType.matches("DELETE")) {
            screenInfo.getPageQueries().add(query);
        }
    }

    private void appendVariableInScreenInfo(String updateType, ScreenInfo screenInfo, Variable variable) {
        screenInfo.setPageVariables((null == screenInfo.getPageVariables()) ? new ArrayList<>() : screenInfo.getPageVariables());
        screenInfo.getPageVariables().removeIf(q -> (q.getId().matches(variable.getId())));
        if (!updateType.matches("DELETE")) {
            screenInfo.getPageVariables().add(variable);
        }
    }

    private void appendEventInScreenInfo(String updateType, ScreenInfo screenInfo, Event event) {
        screenInfo.setPageEvents((null == screenInfo.getPageEvents()) ? new ArrayList<>() : screenInfo.getPageEvents());
        screenInfo.getPageEvents().removeIf(q -> (q.getId().matches(event.getId())));
        if (!updateType.matches("DELETE")) {
            screenInfo.getPageEvents().add(event);
        }
    }

    private void appendTaskInScreenInfo(String updateType, ScreenInfo screenInfo, Task task) {
        screenInfo.setPageTasks((null == screenInfo.getPageTasks()) ? new ArrayList<>() : screenInfo.getPageTasks());
        screenInfo.getPageTasks().removeIf(q -> (q.getId().matches(task.getId())));
        if (!updateType.matches("DELETE")) {
            screenInfo.getPageTasks().add(task);
        }
    }

    private void initLayoutInScreen(String appId, ScreenInfo screenInfo) {
        String url = initLayoutURL + appId + "/layout/init/" + screenInfo.getScreenName();
        String response = restTemplate.getForObject(url, String.class);
        JsonObject responseJson = gson.fromJson(response, JsonObject.class);
        Layout layout = gson.fromJson(responseJson.get("layout").getAsJsonObject(), Layout.class);
        screenInfo.setLayout(layout);
    }

    public ScreenInfo findById(String id) {
        return screenInfoRepository.findById(id).orElseGet(ScreenInfo::new);
    }


    public void deleteScreen(String screenInd) {
        screenInfoRepository.deleteById(screenInd);
    }

    public List<ScreenInfo> searchAllByAppId(String appId, String startsWith) {
        return screenInfoRepository.findAllByAppIdAndScreenNameIgnoreCaseStartsWith(appId, startsWith);
    }

}

