package in.appinit.appconfig.controller;

import in.appinit.appconfig.model.AppConfig;
import in.appinit.appconfig.services.AppConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class AppConfigController {

    @Autowired
    AppConfigService appConfigService;

    Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(path = "/init", method = RequestMethod.POST)
    public ResponseEntity<AppConfig> initApp(@RequestParam("name") String name, @RequestParam("icon") MultipartFile multipartFile) {
        return ok().body(appConfigService.initApp(name, multipartFile));
    }

    @RequestMapping(path = "/init/data", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> initDummyData(@RequestParam("data") MultipartFile data) {

        appConfigService.initAppData(data);
        System.out.println("Saving data");
        Map<String, String> response = new HashMap<>();
        response.put("result", "Saved");

        return ok(response);
    }

    @RequestMapping(path = "/deleteAll", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAll() {
        appConfigService.deleteAll();
        return ok().body("Deleted all apps");
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<Map<String, List<AppConfig>>> allApps() {
        System.out.println("Fetching all apps");
        Map<String, List<AppConfig>> response = new HashMap<>();
        response.put("appsList", appConfigService.allApps());
        return ok().body(response);
    }

    @RequestMapping(value = "/update/app-name/{appId}/{appName}", method = RequestMethod.GET)
    public ResponseEntity<AppConfig> updateNameAndLogo(@PathVariable String appId, @PathVariable String appName) {
        System.out.println("AppId: " + appId);
        return ok(appConfigService.updateAppName(appId, appName));
    }

    @RequestMapping("/update/app-logo/{appId}")
    public ResponseEntity<AppConfig> updateNameAndLogo(@PathVariable String appId, @RequestParam("icon") MultipartFile multipartFile) {
        return ok(appConfigService.updateAppIcon(appId, multipartFile));
    }

    @RequestMapping(value = "/{appId}/export/app-config", produces = "application/json")
    public ResponseEntity<String> exportAppConfig(@PathVariable String appId) {
        System.out.println("Exporting app Config");
        return ResponseEntity.ok().body(appConfigService.exportAppConfig(appId));
    }

    @RequestMapping(value = "/{appId}/import/queries", produces = "application/json")
    public ResponseEntity<String> importQueries(@PathVariable String appId) {
        System.out.println("Preparing to fetch app queries");
        return ResponseEntity.ok(appConfigService.importQueries(appId));
    }

}
