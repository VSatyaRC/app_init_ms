package in.appinit.appinitpages.services;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import in.appinit.appinitpages.repositories.LayoutRepository;
import in.appinit.appinitpages.repositories.SimpleWidgetRepository;
import in.appinit.appinitpages.widget_config.data.TxDataConfig;
import in.appinit.appinitpages.widget_config.event.TxEventConfig;
import in.appinit.appinitpages.widgets.*;
import in.appinit.appinitpages.widgets.widgettree.Layout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static in.appinit.appinitpages.WidgetMapperUtil.mapWidget;
import static in.appinit.appinitpages.WidgetUtils.createKey;

@Service
public class LayoutServices {

    @Autowired
    Gson gson;

    @Autowired
    LayoutRepository layoutRepository;

    @Autowired
    SimpleWidgetRepository simpleWidgetRepository;

    @Autowired
    WidgetServices widgetServices;

    /*  requestBody['id'] = layout.id;
  requestBody['rootKey'] = layout.rootKey;
  requestBody['layoutName'] = layout.layoutName;
  requestBody['componentName'] = layout.componentName;
  requestBody['widgetsList'] = widgets;
  requestBody['txDataConfig'] = txData;
*/

    public Map<String, Layout> saveLayout(String appId, String requestBody) {
        JsonObject layoutJson = gson.fromJson(requestBody, JsonObject.class);
//        Layout layout = gson.fromJson(requestBody, Layout.class);
        Layout layout = new Layout();

        layout.setAppId(appId);
        try {
            layout.setId(layoutJson.get("id").getAsString());
            System.out.println("Layout Id: " + layoutJson.get("id").getAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            layout.setRootKey(layoutJson.get("rootKey").getAsString());
            System.out.println("rootKey: " + layoutJson.get("rootKey").getAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            layout.setLayoutName(layoutJson.get("layoutName").getAsString());
            System.out.println("layoutName: " + layoutJson.get("layoutName").getAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            layout.setComponentName(layoutJson.get("componentName").getAsString());
            System.out.println("componentName: " + layoutJson.get("componentName").getAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
//        layout.setRootKey(layoutJson.get("rootKey").getAsString());
        layoutJson.get("widgetsList").getAsJsonArray().forEach(item -> {
            layout.getWidgetsList().add(mapWidget(item.getAsJsonObject()));
        });

        layoutJson.get("txDataConfig").getAsJsonArray().forEach(item -> {
            layout.getTxDataConfig().add(gson.fromJson(item.getAsJsonObject(), TxDataConfig.class));
            System.out.println("tc: " + item.getAsJsonObject().toString());
        });

        layoutJson.get("txEventConfig").getAsJsonArray().forEach(item -> {
            layout.getTxEventConfig().add(gson.fromJson(item.getAsJsonObject(), TxEventConfig.class));
            System.out.println("te: " + item.getAsJsonObject().toString());
        });
        Map<String, Layout> response = new HashMap<>();
        response.put("layout", layoutRepository.save(layout));
        return response;
    }

    public Map<String, List<Layout>> getLayouts(String appId) {
        List<Layout> layoutList = layoutRepository.findAllByAppId(appId);
        Map<String, List<Layout>> response = new HashMap<>();
        response.put("layoutList", layoutList);
        return response;
    }

    public Map<String, Layout> getLayout(String appId, String layoutId) {
        Layout layout = layoutRepository.findById(layoutId).orElse(new Layout());
        Map<String, Layout> response = new HashMap<>();
        response.put("layout", layout);
        return response;
    }

    public Layout findTopByAppId(String appId) {
        return layoutRepository.findTopByAppId(appId);
    }

    public Map<String, Layout> initLayout(String appId, String screenName) {

        System.out.println("Initializing layout");
        widgetServices.getWidget("AppBar");
        Layout layout = getLayoutWithAppBar();
        layout.setLayoutName(screenName);
        layout.setAppId(appId);

        Map<String, Layout> response = new HashMap<>();
        response.put("layout", layoutRepository.save(layout));

        System.out.println(gson.toJson(response.get("layout"), Layout.class));
        return response;
    }

    public Layout getLayoutWithAppBar() {
        List<SimpleWidget> widgetsList = new ArrayList<>();
        List<String> usedKeys = new ArrayList<>();

        Layout layout = new Layout();
        String appBarKey = "appBar";

        RootWidget rootWidget = (RootWidget) widgetServices.getWidgetOfType("Root");
        rootWidget.getChildren().add(appBarKey);

        AppBarWidget appBarContainer = (AppBarWidget) widgetServices.getWidgetOfType("AppBar");
        appBarContainer.setKey(appBarKey);
        appBarContainer.setParentKey(rootWidget.getKey());
        usedKeys.add(appBarKey);

        ImageWidget leadingIcon = (ImageWidget) widgetServices.getWidgetOfType("Image");
        System.out.println("Icon: " + gson.toJson(leadingIcon, ImageWidget.class));
        leadingIcon.setParentKey(appBarKey);
        leadingIcon.setKey(createKey(usedKeys));
        usedKeys.add(leadingIcon.getKey());

        TextWidget title = (TextWidget) widgetServices.getWidgetOfType("Text");

        title.getStyleConfig().appendConfig("text", "Page Title");
        title.getStyleConfig().appendConfig("color", "#FFFFFF");
        title.getStyleConfig().appendConfig("fontWeight", 5);
        title.getStyleConfig().appendConfig("fontSize", 18.0);
        title.setParentKey(appBarKey);
        title.setKey(createKey(usedKeys));

        appBarContainer.getChildren().add(leadingIcon.getKey());
        appBarContainer.getChildren().add(title.getKey());

        widgetsList.add(title);
        widgetsList.add(leadingIcon);
        widgetsList.add(appBarContainer);

        layout.setWidgetsList(widgetsList);
        layout.setRootKey(rootWidget.getKey());

        widgetsList.add(rootWidget);
        return layout;

    }


    public String getWidget(String simpleName) {
        Map<String, SimpleWidget> widget = new HashMap<>();
        widget.put(simpleName, simpleWidgetRepository.findBySimpleNameIgnoreCase(simpleName).get());
        return gson.toJson(widget);
    }

    public SimpleWidget getWidgetOfType(String name) {
        return (SimpleWidget) simpleWidgetRepository.findBySimpleNameIgnoreCase(name).get();
    }
}
