package in.appinit.appinitpages.controller.tasks;


import in.appinit.appinitpages.model.task.CrUpTask;
import in.appinit.appinitpages.model.task.SimpleTask;
import in.appinit.appinitpages.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;

    @RequestMapping(value = "/{appId}/task", method = RequestMethod.POST)
    ResponseEntity<SimpleTask> saveTask(@PathVariable String appId, @RequestBody String simpleTask) {

        return ResponseEntity.ok(taskService.saveTask(appId, simpleTask));
    }
/*
    @RequestMapping(value = "/{appId}/tasks", method = RequestMethod.POST)
    ResponseEntity<Map<String, List<CrUpTask>>> saveAllTasks(@PathVariable String appId, @RequestBody Map<String, CrUpTask> tasksMap) {
        return ResponseEntity.ok(taskService.saveAll(appId, new ArrayList<>(tasksMap.values())));
    }*/

    @RequestMapping(value = "/{appId}/task/{id}", method = RequestMethod.GET)
    ResponseEntity<SimpleTask> getTask(@PathVariable String appId, @PathVariable String id) {
        return ResponseEntity.ok(taskService.getTask(id));
    }


    @RequestMapping(value = "/{appId}/task/{id}", method = RequestMethod.DELETE)
    ResponseEntity<Map<String, Boolean>> deleteTask(@PathVariable String id) {
        return ResponseEntity.ok(taskService.deleteTaskById(id));
    }

    @RequestMapping(value = "/{appId}/tasks", method = RequestMethod.GET)
    ResponseEntity<Map<String, List<SimpleTask>>> getAllTasks(@PathVariable String appId) {
        return ResponseEntity.ok(taskService.getAllTasks(appId));
    }

 /*   @RequestMapping(value = "/{appId}/tasks", method = RequestMethod.DELETE)
    ResponseEntity<String> deleteTasks(@PathVariable String appId) {
        taskService.deleteTasks(appId);
        return ResponseEntity.ok("Deleted all tasks");
    }*/

  /*  @RequestMapping(value = "/{appId}/tasks", method = RequestMethod.DELETE)
    ResponseEntity<String> deleteAllTasks() {
        taskService.deleteAllTasks();
        return ResponseEntity.ok("Deleted all tasks");
    }
*/

  /*@RequestMapping(value = "/{appId}/tasks/search", method = RequestMethod.GET)
    public ResponseEntity<List<Task>> allProperties(@PathVariable String appId, @RequestBody Map<String, List<String>> requestBody) {
        return ResponseEntity.ok(taskService.propertyStartingWith(requestBody.get("startsWith").get(0), requestBody.get("ids")));
    }*/
}
