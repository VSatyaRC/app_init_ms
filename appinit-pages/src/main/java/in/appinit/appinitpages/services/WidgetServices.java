package in.appinit.appinitpages.services;


import com.google.gson.Gson;
import in.appinit.appinitpages.WidgetMapperUtil;
import in.appinit.appinitpages.repositories.SimpleWidgetRepository;
import in.appinit.appinitpages.repositories.StyleConfigRepository;
import in.appinit.appinitpages.widgets.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class WidgetServices {

    @Autowired
    Gson gson;

    @Autowired
    SimpleWidgetRepository simpleWidgetRepository;

    @Autowired
    StyleConfigRepository styleConfigRepository;

    public String getWidget(String simpleName) {
        System.out.println("Initializing " + simpleName + " Widget");
        Map<String, Object> widget = new HashMap<>();
        widget.put(simpleName, simpleWidgetRepository.findBySimpleNameIgnoreCase(simpleName).get());
        return gson.toJson(widget);
    }

    public SimpleWidget getWidgetOfType(String name) {
        return (SimpleWidget) simpleWidgetRepository.findBySimpleNameIgnoreCase(name).get();
    }

    public String saveInitConfig() {
        simpleWidgetRepository.save(new RootWidget());
        simpleWidgetRepository.save(new AppBarWidget());
        simpleWidgetRepository.save(new RowWidget());
        simpleWidgetRepository.save(new CardWidget());
        simpleWidgetRepository.save(new ClickWidget());
        simpleWidgetRepository.save(new ColumnWidget());
        simpleWidgetRepository.save(new SwitcherWidget());
        simpleWidgetRepository.save(new ContainerWidget());
        simpleWidgetRepository.save(new ExpandedWidget());
        simpleWidgetRepository.save(new PaddingWidget());
        simpleWidgetRepository.save(new ImageWidget());
        simpleWidgetRepository.save(new TextWidget());
        simpleWidgetRepository.save(new TextFieldWidget());
        simpleWidgetRepository.save(new ListWidget());
        return "Done";
//        return saveInitStyleConfig();
    }

    public String saveInitStyleConfig() {
        styleConfigRepository.save(WidgetMapperUtil.widgetWithInitConfig("Root").instanceWithConfig());
        styleConfigRepository.save(WidgetMapperUtil.widgetWithInitConfig("AppBar").instanceWithConfig());
        styleConfigRepository.save(WidgetMapperUtil.widgetWithInitConfig("Row").instanceWithConfig());
        styleConfigRepository.save(WidgetMapperUtil.widgetWithInitConfig("Card").instanceWithConfig());
        styleConfigRepository.save(WidgetMapperUtil.widgetWithInitConfig("Click").instanceWithConfig());
        styleConfigRepository.save(WidgetMapperUtil.widgetWithInitConfig("Column").instanceWithConfig());
        styleConfigRepository.save(WidgetMapperUtil.widgetWithInitConfig("Switcher").instanceWithConfig());
        styleConfigRepository.save(WidgetMapperUtil.widgetWithInitConfig("Container").instanceWithConfig());
        styleConfigRepository.save(WidgetMapperUtil.widgetWithInitConfig("Expanded").instanceWithConfig());
        styleConfigRepository.save(WidgetMapperUtil.widgetWithInitConfig("Padding").instanceWithConfig());
        styleConfigRepository.save(WidgetMapperUtil.widgetWithInitConfig("Image").instanceWithConfig());
        styleConfigRepository.save(WidgetMapperUtil.widgetWithInitConfig("Text").instanceWithConfig());
        styleConfigRepository.save(WidgetMapperUtil.widgetWithInitConfig("TextField").instanceWithConfig());
        styleConfigRepository.save(WidgetMapperUtil.widgetWithInitConfig("List").instanceWithConfig());
        return "Done";
    }

    public SimpleWidget saveWidgetInitConfig(SimpleWidget widget) {
        Optional<SimpleWidget> savedWidget = simpleWidgetRepository.findBySimpleNameIgnoreCase(((SimpleWidget) widget).getSimpleName());
        if (savedWidget.isPresent()) {
            String id = (savedWidget.get()).getId();
            ((SimpleWidget) widget).setId(id);
        }
        return simpleWidgetRepository.save((SimpleWidget) widget);
    }

    public SimpleWidget updateInitConfig(String widgetName) {
        return saveWidgetInitConfig(WidgetMapperUtil.widgetWithInitConfig(widgetName));
    }
}
