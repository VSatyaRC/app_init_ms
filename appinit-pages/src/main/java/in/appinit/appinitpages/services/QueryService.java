package in.appinit.appinitpages.services;


import com.google.gson.Gson;
import in.appinit.appinitpages.model.Query;
import in.appinit.appinitpages.repositories.QueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class QueryService {

    @Autowired
    QueryRepository queryRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Gson gson;

    public Query saveQuery(String appId, String screenId, Query query) {
        query.setAppId(appId);
       /* String serverUrl = "http://app-config/app/" + appId + "/" + screenId + "/screen/updateItem";

        Query query1 = new Query();
        query1.setId(query.getId());
        query1.setName(query.getName());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity
                = new HttpEntity<>(gson.toJson(query1), headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(serverUrl, requestEntity, Map.class);
        System.out.println(response.getBody());*/
        return queryRepository.save(query);
    }

    public Query getQuery(String id) {
        Optional<Query> optionalQuery = queryRepository.findById(id);
        return optionalQuery.orElseGet(Query::new);
    }

    public Map<String, List<Query>> getAllQueries(String appId) {
        Map<String, List<Query>> response = new HashMap<>();
        response.put("queries", queryRepository.findAllByAppId(appId));
        return response;
    }

    public Map<String, List<Query>> saveAll(String appId, List<Query> queries) {
        Map<String, List<Query>> response = new HashMap<>();
        response.put("queries", queryRepository.saveAll(queries));
        return response;
    }

    public void deleteAllQueries() {
        queryRepository.deleteAll();
    }

    public void deleteQueries(String appId) {
        queryRepository.deleteAllByAppId(appId);
    }

    public void deleteQuery(String appId, String queryId) {
        queryRepository.deleteByIdAndAppId(queryId, appId);
    }


    public Map<String, List<Query>> getPageQueries(String appId, Map<String, List<String>> queries) {
        List<Query> result = queryRepository.findAllByIdIn(queries.get("queries"));
        Map<String, List<Query>> response = new HashMap<>();
        response.put("queries", result);
        return response;
    }
}
