package ray.sn.application.input;

import ray.sn.domain.model.Task;
import java.util.List;

public interface TaskUseCase {

    List<Task> list();
    Task create(Task task);
    Task getOne(String id);
    Task update(Task task);
    void delete(String id);
}



