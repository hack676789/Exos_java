package ray.sn.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import ray.sn.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

import ray.sn.entites.Task;


@Service
public class TaskService {

    
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(int id){
        return taskRepository.findById(id);
    }

    public Task addTask(Task task){
       return  this.taskRepository.save(task);
    }

    public Task updateTask(int id, Task updateTask){
        return taskRepository.findById(id).map(task -> {
            task.setTitle(updateTask.getTitle());
            task.setDescription(updateTask.getDescription());
            task.setAccomplished(updateTask.getAccomplished());
            return taskRepository.save(task);
        }).orElseThrow(() -> new RuntimeException("tache non trouvee"));
    }

    public Task upTask(int id, Task upTask) {
    return taskRepository.findById(id).map(task -> {
        // Met à jour uniquement les champs non nulls de updateTask
        if (upTask.getTitle() != null) {
            task.setTitle(upTask.getTitle());
        }
        return taskRepository.save(task);
    }).orElseThrow(() -> new RuntimeException("Tâche non trouvée"));
}
 

    public void deleteTask(int id){
        taskRepository.deleteById(id);
    }
}
