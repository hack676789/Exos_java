package ray.sn.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.http.HttpStatus;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;
import java.util.Optional;

import ray.sn.entites.Task;
import ray.sn.repository.TaskRepository;
import ray.sn.services.TaskService;

@RestController
@RequestMapping("task")
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/all")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Optional<Task> getTaskBy(@PathVariable int id){
        return taskService.getTaskById(id);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Task addTask(@RequestBody Task task){
        return taskService.addTask(task);
    }

    @PutMapping("/{id}")
    public Task updTask(@PathVariable int id, @RequestBody Task task ) {
        return taskService.updateTask(id, task);
    }

    @PatchMapping("/{id}")
    public Task upTask(@PathVariable int id, @RequestBody Task task){
        return taskService.upTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable int id){
        taskService.deleteTask(id);
    }

   
  
   
}
