package in.appinit.appconfig.controller;

import in.appinit.appconfig.model.AppConfig;
import in.appinit.appconfig.services.AppConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AppConfigController {

    @Autowired
    AppConfigService appConfigService;

    @RequestMapping(path = "/init", method = RequestMethod.POST)
    public ResponseEntity<AppConfig> initApp(@RequestParam("name") String name, @RequestParam("icon") MultipartFile multipartFile) {
        return ResponseEntity.ok().body(appConfigService.initApp(name, multipartFile));
    }

    @RequestMapping(path = "/init/data", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> initDummyData(@RequestParam("data") MultipartFile data) {

        appConfigService.initAppData(data);
        System.out.println("Saving data");
        Map<String, String> response = new HashMap<>();
        response.put("result", "Saved");

        return ResponseEntity.ok(response);
    }

    @RequestMapping(path = "/deleteAll", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAll() {
        appConfigService.deleteAll();
        return ResponseEntity.ok().body("Deleted all apps");
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<Map<String, List<AppConfig>>> allApps() {
        System.out.println("Fetching all apps");
        Map<String, List<AppConfig>> response = new HashMap<>();
        response.put("appsList", appConfigService.allApps());
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(value = "/update/app-name/{appId}/{appName}", method = RequestMethod.GET)
    public ResponseEntity<AppConfig> updateNameAndLogo(@PathVariable String appId, @PathVariable String appName) {
        System.out.println("AppId: " + appId);
        return ResponseEntity.ok(appConfigService.updateAppName(appId, appName));
    }

    @RequestMapping("/update/app-logo/{appId}")
    public ResponseEntity<AppConfig> updateNameAndLogo(@PathVariable String appId, @RequestParam("icon") MultipartFile multipartFile) {
        return ResponseEntity.ok(appConfigService.updateAppIcon(appId, multipartFile));
    }
}
