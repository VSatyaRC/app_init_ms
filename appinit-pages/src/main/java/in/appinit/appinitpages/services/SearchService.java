package in.appinit.appinitpages.services;


import in.appinit.appinitpages.Utils;
import in.appinit.appinitpages.model.Query;
import in.appinit.appinitpages.model.variable.Variable;
import in.appinit.appinitpages.repositories.QueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SearchService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    QueryRepository queryRepository;


    public Object searchData(Map<String, String> payload, String appId) {
        String searchType = payload.get("searchType");
        String searchFor = payload.get("searchFor");

        switch (searchType) {
            case "Variable":
                return searchVariable(searchFor);
            case "Query":
                return searchQuery(appId, searchFor);
        }
        return new HashMap<>();
    }

    public Map<String, List<Variable>> searchVariable(String searchFor) {
        Utils.getAppVariables().values().forEach(variable -> System.out.println(variable.toString()));
        Map<String, List<Variable>> searchResults = new HashMap<>();
        searchResults.put("results", Utils.getAppVariables().values().stream().filter(i -> i.getName().toLowerCase().contains(searchFor.toLowerCase())).collect(Collectors.toList()));
        return searchResults;
    }

    public Map<String, List<Query>> searchQuery(String appId, String queryName) {

        List<Query> queries = queryRepository.findAllByAppIdAndNameStartsWithIgnoreCase(appId, queryName);
        Map<String, List<Query>> result = new HashMap<>();
        result.put("results", queries);
        return result;

/*        List<String> models = (queries.stream().map(Query::getModelToQuery).collect(Collectors.toList())).stream().map(Model::getName).collect(Collectors.toList());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<List<String>> requestEntity
                = new HttpEntity<>(models, headers);

        String url = "http://appinit-models/models/" + appId + "/search/properties";

        System.out.println("URL: " + url);
        System.out.println(models);
        return restTemplate.postForEntity(url, requestEntity, Map.class).getBody();*/
    }
}
