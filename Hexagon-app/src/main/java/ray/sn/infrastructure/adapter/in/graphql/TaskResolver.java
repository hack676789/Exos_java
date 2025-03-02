package ray.sn.infrastructure.adapter.in.graphql;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ray.sn.application.input.TaskUseCase;
import ray.sn.application.out.TaskPersistence;
import ray.sn.domain.model.Task;

import java.util.List;


@Component
public class TaskResolver {

    private final TaskUseCase taskUseCase;

    public TaskResolver(TaskUseCase taskUseCase) {
        this.taskUseCase = taskUseCase;
    }

    
    public List<Task> getAllTasks() {
        return taskUseCase.list();
    }

    public Task getTaskById(String id) {
        return taskUseCase.getOne(id);
    }

    public Task createTask(String title, String description) {
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        return taskUseCase.create(task);
    }

    public Task updateTask(String id, String title, String description) {
        Task task = taskUseCase.getOne(id);
        if (title != null) task.setTitle(title);
        if (description != null) task.setDescription(description);
        return taskUseCase.update(task);
    }

    public Boolean deleteTask(String id) {
        taskUseCase.delete(id);
        return true;
    }
}




