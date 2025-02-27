package ray.sn.infrastructure.adapter.out.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ray.sn.application.out.TaskPersistence;
import ray.sn.domain.model.Task;
import ray.sn.infrastructure.adapter.mapper.Mapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
@RequiredArgsConstructor
public class JpaAdapter implements TaskPersistence{

    private final TaskJpaRepository TaskjpaRepository;
    private final Mapper mapper;

    @Override
    public Task save(Task task) {
        JpaEntity entity = mapper.toJpaEntity(task);
        JpaEntity savedEntity = TaskjpaRepository.save(entity);
        return mapper.toModelFromJpa(savedEntity);
    }

    @Override
    public Optional<Task> findById(String id) {
        return TaskjpaRepository.findById(Long.parseLong(id))
                .map(mapper::toModelFromJpa);
    }

    @Override
    public List<Task> findAll() {
        return TaskjpaRepository.findAll().stream()
                .map(mapper::toModelFromJpa)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(String id) {
        TaskjpaRepository.deleteById(Long.parseLong(id));
    }

    
}






