package ray.sn.application.out;

import ray.sn.domain.model.Task;
import java.util.List;
import java.util.Optional;

public interface TaskPersistence {

    Task save(Task task);
    Optional<Task> findById(String id);
    List<Task> findAll();
    void deleteById(String id);
}
