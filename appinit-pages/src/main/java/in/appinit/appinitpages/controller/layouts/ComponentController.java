package in.appinit.appinitpages.controller.layouts;


import in.appinit.appinitpages.services.ComponentServices;
import in.appinit.appinitpages.widgets.widgettree.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ComponentController {

    @Autowired
    ComponentServices componentServices;

    @RequestMapping(value = "/component", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Component>> saveComponent(@RequestBody String widgetTree) {
        return ResponseEntity.ok(componentServices.saveComponent(widgetTree));
    }

    @RequestMapping(value = "/copy/component", method = RequestMethod.POST)
    public ResponseEntity<String> copyComponent(@RequestBody String layout) {
        return ResponseEntity.ok(componentServices.getComponentCopy(layout));
    }

    @RequestMapping(value = "/component/{id}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Component>> getComponent(@PathVariable String id) {
        return ResponseEntity.ok(componentServices.findById(id));
    }

    @RequestMapping(value = "/components", method = RequestMethod.GET)
    public ResponseEntity<Map<String, List<Component>>> getComponents() {
        return ResponseEntity.ok(componentServices.getComponents());
    }

}
