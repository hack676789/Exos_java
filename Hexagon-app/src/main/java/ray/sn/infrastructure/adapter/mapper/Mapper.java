package ray.sn.infrastructure.adapter.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import ray.sn.domain.model.Task;
import ray.sn.infrastructure.adapter.out.jpa.JpaEntity;

@Component
@RequiredArgsConstructor
public class Mapper {

    private final ModelMapper modelMapper;

    public Task toModelFromJpa(JpaEntity entity) {
        return modelMapper.map(entity, Task.class);
    }

    public JpaEntity toJpaEntity(Task task) {
        return modelMapper.map(task, JpaEntity.class);
    }

 
}






