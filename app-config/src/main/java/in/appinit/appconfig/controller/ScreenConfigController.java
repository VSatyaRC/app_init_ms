package in.appinit.appconfig.controller;

import in.appinit.appconfig.model.screens.ScreenInfo;
import in.appinit.appconfig.services.ScreenConfigServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ScreenConfigController {

    @Autowired
    ScreenConfigServices screenConfigServices;

    @RequestMapping(value = "/{appId}/screen/{id}", method = RequestMethod.GET)
    public ResponseEntity<ScreenInfo> getScreenConfig(@PathVariable String appId, @PathVariable String id) {
        return ResponseEntity.ok(screenConfigServices.findById(id));
    }

    @RequestMapping(value = "/{appId}/screen/editor/{id}", method = RequestMethod.GET)
    public ResponseEntity<ScreenInfo> getScreenInEditor(@PathVariable String appId, @PathVariable String id) {
        return ResponseEntity.ok(screenConfigServices.findById(id));
    }

    @RequestMapping(value = "/{appId}/screens", method = RequestMethod.GET)
    public ResponseEntity<Map<String, List<ScreenInfo>>> getAppScreens(@PathVariable String appId) {
        Map<String, List<ScreenInfo>> screenInfoList = new HashMap<>();
        screenInfoList.put("screens", screenConfigServices.findAllByAppId(appId));
        return ResponseEntity.ok(screenInfoList);
    }


    @RequestMapping(value = "/{appId}/search/screens/{startsWith}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, List<ScreenInfo>>> searchAppScreens(@PathVariable String appId, @PathVariable String startsWith) {
        Map<String, List<ScreenInfo>> screenInfoList = new HashMap<>();
        System.out.println("Searching for " + startsWith);
        screenInfoList.put("screens", screenConfigServices.searchAllByAppId(appId, startsWith));
        return ResponseEntity.ok(screenInfoList);
    }

    @RequestMapping(value = "/{appId}/screen", method = RequestMethod.POST)
    public ResponseEntity<ScreenInfo> getScreenConfig(@PathVariable String appId, @RequestBody ScreenInfo screenInfo) {
        return ResponseEntity.ok(screenConfigServices.save(appId, screenInfo));
    }

    @RequestMapping(value = "/{appId}/{screenId}/screen/{updateType}/{pageItem}", method = RequestMethod.POST)
    public ResponseEntity<ScreenInfo> updateScreenConfig(@PathVariable String appId, @PathVariable String screenId,
                                                         @PathVariable String updateType, @PathVariable String pageItem, @RequestBody String itemToUpdate) {

        System.out.println("Updating screenInfo, please wait");
        return ResponseEntity.ok(screenConfigServices.save(appId, screenId, pageItem, updateType, itemToUpdate));
    }

    @RequestMapping(value = "/{appId}/screen/", method = RequestMethod.DELETE)
    public ResponseEntity<Map<String, String>> deleteScreenConfig(@PathVariable String appId, @RequestBody ScreenInfo screenInfo) {
        screenConfigServices.deleteScreen(appId, screenInfo);
        Map<String, String> response = new HashMap<>();
        response.put("status", "deleted");
        return ResponseEntity.ok(response);
    }

}
