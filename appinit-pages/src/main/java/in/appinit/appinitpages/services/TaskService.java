package in.appinit.appinitpages.services;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import in.appinit.appinitpages.model.task.CrUpTask;
import in.appinit.appinitpages.model.task.PageTransitionTask;
import in.appinit.appinitpages.model.task.SimpleTask;
import in.appinit.appinitpages.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository<CrUpTask> crUpTaskTaskRepository;

    @Autowired
    TaskRepository<PageTransitionTask> pageTransitionTaskTaskRepository;

    @Autowired
    TaskRepository<SimpleTask> taskRepository;

    @Autowired
    Gson gson;

    public SimpleTask saveTask(String appId, String simpleTask) {
/*

        if (null == simpleTask.getType()) {
            return taskRepository.save(simpleTask);
        } else if (simpleTask.getType().matches("Page")) {
            return pageTransitionTaskTaskRepository.save((PageTransitionTask) simpleTask);
        } else {
            return crUpTaskTaskRepository.save((CrUpTask) simpleTask);
        }


*/
        SimpleTask task;
        if (gson.fromJson(simpleTask, JsonObject.class).get("type").isJsonNull()) {
            task = gson.fromJson(simpleTask, SimpleTask.class);
        } else if (gson.fromJson(simpleTask, JsonObject.class).get("type").getAsString().matches("Page")) {
            task = gson.fromJson(simpleTask, PageTransitionTask.class);
        } else {
            task = gson.fromJson(simpleTask, CrUpTask.class);
        }
        task.setAppId(appId);
        return taskRepository.save(task);

    }

    public SimpleTask getTask(String id) {
        Optional<CrUpTask> optionalTask = crUpTaskTaskRepository.findById(id);
        if (optionalTask.isPresent()) {
            return optionalTask.get();
        } else {
            if (pageTransitionTaskTaskRepository.findById(id).isPresent())
                return pageTransitionTaskTaskRepository.findById(id).get();
            return new SimpleTask();
        }
    }

    public Map<String, List<SimpleTask>> getAllTasks(String appId) {
        Map<String, List<SimpleTask>> response = new HashMap<>();

//        Collections.sort(crUpTasks);
        response.put("tasks", taskRepository.findAll());
        return response;
    }

/*    public Map<String, List<CrUpTask>> saveAll(String appId, List<CrUpTask> crUpTasks) {
        Map<String, List<CrUpTask>> response = new HashMap<>();
        response.put("tasks", taskRepository.saveAll(crUpTasks));
        return response;
    }*/

/*
    public void deleteAllTasks() {
        taskRepository.deleteAll();
    }
*/

    public Map<String, Boolean> deleteTaskById(String id) {
        Map<String, Boolean> result = new HashMap<>();
        boolean status;
        try {
            crUpTaskTaskRepository.deleteById(id);
            pageTransitionTaskTaskRepository.deleteById(id);
            status = true;
        } catch (Exception e) {
            status = false;
        }
        result.put("status", status);
        return result;
    }

    public Map<String, List<SimpleTask>> searchByName(String startsWith, String appId) {
        Map<String, List<SimpleTask>> results = new HashMap<>();
        results.put("tasks", taskRepository.findAllByNameStartsWithIgnoreCaseAndAppId(startsWith, appId));
        return results;
    }

    public Map<String, List<SimpleTask>> getPageTasks(String screenId, String appId, Map<String, List<String>> tasks) {
        Map<String, List<SimpleTask>> results = new HashMap<>();
        results.put("tasks", taskRepository.findAllByIdIn(tasks.get("tasks")));
        return results;
    }

/*
    public void deleteTasks(String appId) {
        taskRepository.deleteAllByAppId(appId);
    }
*/

}
