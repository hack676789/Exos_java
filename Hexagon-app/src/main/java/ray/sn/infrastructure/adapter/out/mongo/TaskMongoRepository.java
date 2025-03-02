package ray.sn.infrastructure.adapter.out.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskMongoRepository extends MongoRepository<MongoEntity, String> {

}
