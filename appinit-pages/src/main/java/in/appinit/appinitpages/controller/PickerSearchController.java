package in.appinit.appinitpages.controller;


import in.appinit.appinitpages.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class PickerSearchController {

    @Autowired
    SearchService searchService;

    @RequestMapping(value = "/{appId}/data-picker/search", method = RequestMethod.POST)
    public ResponseEntity<Object> searchData(@PathVariable String appId, @RequestBody Map<String, String> payload) {
        System.out.println(payload.toString());
        return ResponseEntity.ok(searchService.searchData(payload, appId));
    }
}
