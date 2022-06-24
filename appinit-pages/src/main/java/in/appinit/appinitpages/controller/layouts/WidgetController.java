package in.appinit.appinitpages.controller.layouts;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import in.appinit.appinitpages.WidgetMapperUtil;
import in.appinit.appinitpages.services.WidgetServices;
import in.appinit.appinitpages.widgets.SimpleWidget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WidgetController {

    @Autowired
    WidgetServices widgetServices;

    @Autowired
    Gson gson;

    @RequestMapping(method = RequestMethod.GET, value = "/widget/{widgetName}", produces = {"application/json"})
    public ResponseEntity<String> getWidget(@PathVariable String widgetName) {
        return ResponseEntity.ok(widgetServices.getWidget(widgetName));
    }

    @RequestMapping(value = "/init/config", produces = {"application/json"}, method = RequestMethod.POST, consumes = {"application/json"})
    public ResponseEntity<String> saveWidget(@RequestBody String widget) {
        JsonObject payload = gson.fromJson(widget, JsonObject.class);
        System.out.println("***********************************************************");
        System.out.println(widget);
        return ResponseEntity.ok(gson.toJson(widgetServices.saveWidgetInitConfig(WidgetMapperUtil.mapWidget(payload))));
    }

    /*This is a one time operation. Usually required when databases containing initial widgetConfigs  are cleared.*/

    @GetMapping("/init/widgetConfig")
    public String saveInitialWidgetConfig() {
        return widgetServices.saveInitConfig();
    }

    //todo delete this
    @GetMapping("/init/update/widgetConfig/{widgetName}")
    public ResponseEntity<SimpleWidget> saveInitialWidgetConfig(@PathVariable String widgetName) {
        return ResponseEntity.ok(widgetServices.updateInitConfig(widgetName));
    }


}
