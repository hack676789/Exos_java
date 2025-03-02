package ray.sn.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ray.sn.application.input.TaskUseCase;
import ray.sn.application.out.TaskPersistence;
import ray.sn.domain.exception.TaskNotFoundException;
import ray.sn.domain.model.Task;

import java.util.List;

@Service
public class TaskService implements TaskUseCase {

    private final TaskPersistence taskPersistence;
    public TaskService(TaskPersistence taskPersistence) {
        this.taskPersistence = taskPersistence;
    }

    @Override
    public List<Task> list() {
        return taskPersistence.findAll();
    }

    @Override
    public Task getOne(String id) {
        
        return taskPersistence.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Tâche non trouvée"));
    }

    @Override
    public Task create(Task task) {
        return taskPersistence.save(task);
    }

    @Override
    public Task update(Task task) {
        if (taskPersistence.findById(task.getId()).isEmpty()) {
            throw new TaskNotFoundException("Tâche non trouvée");
        }
        return taskPersistence.save(task);
    }

    @Override
    public void delete(String id) {
        if (taskPersistence.findById(id).isEmpty()) {
            throw new TaskNotFoundException("Tâche non trouvée");
        }
        taskPersistence.deleteById(id);
    }
}
