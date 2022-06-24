package in.appinit.appinitpages.controller.layouts;

import com.google.gson.Gson;
import in.appinit.appinitpages.services.LayoutServices;
import in.appinit.appinitpages.widgets.widgettree.Layout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class LayoutController {

    @Autowired
    LayoutServices layoutServices;

    @Autowired
    Gson gson;

    @RequestMapping(value = "/{appId}/layout", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Layout>> saveWidget(@PathVariable String appId, @RequestBody String layout) {
        System.out.println("saving layout: " + layout);
        return ResponseEntity.ok(layoutServices.saveLayout(appId, layout));
    }

    @RequestMapping(value = "/{appId}/layouts", method = RequestMethod.GET)
    public ResponseEntity<Map<String, List<Layout>>> getLayout(@PathVariable String appId) {
        return ResponseEntity.ok(layoutServices.getLayouts(appId));
    }

    @RequestMapping(value = "/{appId}/layout/recent", method = RequestMethod.GET)
    public ResponseEntity<Layout> getRecentLayout(@PathVariable String appId) {
        return ResponseEntity.ok(layoutServices.findTopByAppId(appId));
    }

    @RequestMapping(value = "/{appId}/layout/init/{screenName}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> initLayout(@PathVariable String appId, @PathVariable String screenName) {
        return ResponseEntity.ok(gson.toJson(layoutServices.initLayout(appId, screenName)));
    }

    @RequestMapping(value = "/{appId}/layout/{layoutId}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> getLayout(@PathVariable String appId, @PathVariable String layoutId) {
        return ResponseEntity.ok(gson.toJson(layoutServices.getLayout(appId, layoutId)));
    }

  /*  @RequestMapping(method = RequestMethod.GET, value = "/widget/{widgetName}", produces = {"application/json"})
    public ResponseEntity<String> getWidget(@PathVariable String widgetName) {
        return ResponseEntity.ok(layoutServices.getWidget(widgetName));
    }*/


}
