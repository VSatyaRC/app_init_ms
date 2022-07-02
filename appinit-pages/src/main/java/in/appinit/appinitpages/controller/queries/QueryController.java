package in.appinit.appinitpages.controller.queries;


import com.google.gson.Gson;
import in.appinit.appinitpages.model.Query;
import in.appinit.appinitpages.services.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class QueryController {
    @Autowired
    QueryService queryService;

    @Autowired
    Gson gson;

    @RequestMapping(value = "/queries", method = RequestMethod.POST)
    ResponseEntity<Map<String, List<Query>>> saveAllQueries(@PathVariable String appId, @RequestBody Map<String, Query> queriesMap) {
        return ResponseEntity.ok(queryService.saveAll(appId, new ArrayList<>(queriesMap.values())));
    }

    @RequestMapping(value = "/{appId}/{screenId}/query", method = RequestMethod.POST)
    ResponseEntity<Query> saveQuery(@PathVariable String appId, @RequestBody Query query, @PathVariable String screenId) {
        System.out.println("screenId: " + screenId);
        System.out.println(gson.toJson(query));
        return ResponseEntity.ok(queryService.saveQuery(appId, screenId, query));
    }

    @RequestMapping(value = "/query/{id}", method = RequestMethod.GET)
    ResponseEntity<Query> getQuery(@PathVariable String appId, @PathVariable String id) {
        return ResponseEntity.ok(queryService.getQuery(id));
    }

    @RequestMapping(value = "/{appId}/queries", method = RequestMethod.GET)
    ResponseEntity<Map<String, List<Query>>> getAllQueries(@PathVariable String appId) {
        return ResponseEntity.ok(queryService.getAllQueries(appId));
    }

    @RequestMapping(value = "/{appId}/{screenId}/queries", method = RequestMethod.POST)
    ResponseEntity<Map<String, List<Query>>> getPageQueries(@PathVariable String appId, @PathVariable String screenId, @RequestBody Map<String, List<String>> queries) {
        return ResponseEntity.ok(queryService.getPageQueries(appId, queries));
    }

    @RequestMapping(value = "/{appId}/queries", method = RequestMethod.DELETE)
    ResponseEntity<String> deleteQueries(@PathVariable String appId) {
        queryService.deleteQueries(appId);
        return ResponseEntity.ok("Deleted all queries");
    }

    @RequestMapping(value = "/{appId}/query/{queryId}", method = RequestMethod.DELETE)
    ResponseEntity<String> deleteQueries(@PathVariable String appId, @PathVariable String queryId) {
        queryService.deleteQuery(appId, queryId);
        return ResponseEntity.ok("Deleted Query");
    }

    @RequestMapping(value = "/queries/all", method = RequestMethod.DELETE)
    ResponseEntity<String> deleteAllQueries() {
        queryService.deleteAllQueries();
        return ResponseEntity.ok("Deleted all queries");
    }


}
