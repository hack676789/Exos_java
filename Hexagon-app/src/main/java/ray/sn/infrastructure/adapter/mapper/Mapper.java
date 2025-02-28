package ray.sn.infrastructure.adapter.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import ray.sn.domain.model.Task;
import ray.sn.infrastructure.adapter.out.mongo.MongoEntity;
@Component
@RequiredArgsConstructor
public class Mapper {

    private final ModelMapper modelMapper;


    public Task toModelFromMongo(MongoEntity entity){
        return modelMapper.map(entity, Task.class);
    }

    public MongoEntity toMongoEntity(Task task){
        return modelMapper.map(task, MongoEntity.class);
    }
 
}






