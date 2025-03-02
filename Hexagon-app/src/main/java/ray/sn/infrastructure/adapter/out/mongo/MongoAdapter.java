package ray.sn.infrastructure.adapter.out.mongo;

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
public class MongoAdapter implements TaskPersistence {

    private final TaskMongoRepository taskMongoRepository; 
    private final Mapper mapper;

    @Override
    public Task save(Task task) {
        MongoEntity document = mapper.toMongoEntity(task); 
        MongoEntity savedDocument = taskMongoRepository.save(document);
        return mapper.toModelFromMongo(savedDocument); 
    }

    @Override
    public Optional<Task> findById(String id) {
        return taskMongoRepository.findById(id)
                .map(mapper::toModelFromMongo);
    }

    @Override
    public List<Task> findAll() {
        return taskMongoRepository.findAll().stream()
                .map(mapper::toModelFromMongo)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(String id) {
        taskMongoRepository.deleteById(id);
    }
  
}














   
    







