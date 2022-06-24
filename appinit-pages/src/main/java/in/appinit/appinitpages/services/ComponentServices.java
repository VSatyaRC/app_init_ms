package in.appinit.appinitpages.services;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import in.appinit.appinitpages.WidgetMapperUtil;
import in.appinit.appinitpages.repositories.ComponentRepository;
import in.appinit.appinitpages.widgets.widgettree.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static in.appinit.appinitpages.WidgetUtils.createKey;

@Service
public class ComponentServices {

    @Autowired
    Gson gson;

    @Autowired
    ComponentRepository componentRepository;

    public Map<String, Component> saveComponent(String requestBody) {
        System.out.println("Saving layout: " + requestBody);
        JsonObject componentJson = gson.fromJson(requestBody, JsonObject.class);
        Component component = new Component();

        try {
            component.setId(componentJson.get("id").getAsString());
        } catch (Exception e) {
            System.out.println("No Id");
        }
        component.setComponentName(componentJson.get("componentName").getAsString());
        component.setRootKey(componentJson.get("rootKey").getAsString());
        componentJson.get("widgetsList").getAsJsonArray().forEach(item -> {
            component.getWidgetsList().add(WidgetMapperUtil.mapWidget(item.getAsJsonObject()));
        });

        Map<String, Component> response = new HashMap<>();
        response.put("layout", componentRepository.save(component));
        return response;
    }

    public String getComponentCopy(String requestBody) {

        JsonObject componentTreeJson = gson.fromJson(requestBody, JsonObject.class);
        List<String> keys = new ArrayList<>();
        componentTreeJson.get("widgetsList").getAsJsonArray().forEach(item -> {
            keys.add(item.getAsJsonObject().get("key").getAsString());
        });

        Map<String, String> keyMap = new HashMap<>();
        for (String k : keys) {
            String newKey = createKey();
            while (keyMap.containsValue(newKey)) {
                newKey = createKey();
            }
            keyMap.put(k, newKey);
        }

        componentTreeJson.get("widgetsList").getAsJsonArray().forEach(item -> {
            item.getAsJsonObject().addProperty("key", keyMap.get(item.getAsJsonObject().get("key").getAsString()));
            item.getAsJsonObject().addProperty("parentKey", keyMap.getOrDefault(item.getAsJsonObject().get("parentKey").getAsString(), ""));

            if (item.getAsJsonObject().has("child")) {
                item.getAsJsonObject().addProperty("child", keyMap.get(item.getAsJsonObject().get("child").getAsString()));
            }

            if (item.getAsJsonObject().has("children")) {
                JsonArray jsonArray = new JsonArray();
                item.getAsJsonObject().get("children").getAsJsonArray().forEach(i -> {
                    jsonArray.add(keyMap.get(i.getAsString()));
                });
                item.getAsJsonObject().add("children", jsonArray);
            }
        });

        componentTreeJson.addProperty("rootKey", keyMap.get(componentTreeJson.get("rootKey").getAsString()));
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("layout", componentTreeJson);
        return gson.toJson(jsonObject);
    }

    public Map<String, List<Component>> getComponents() {
        Map<String, List<Component>> response = new HashMap<>();
        response.put("layoutList", componentRepository.findAll());
        return response;
    }

    public Map<String, Component> findById(String id) {
        Map<String, Component> response = new HashMap<>();
        response.put("layout", componentRepository.findById(id).orElseGet(Component::new));
        return response;
    }
}