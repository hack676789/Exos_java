package ray.sn.infrastructure.adapter.out.mongo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import ray.sn.domain.model.Enum.Status;


@Document(collection = "tasks") 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MongoEntity {

    @Id 
    private String id; 

    @Field(name = "title") 
    private String title;

    @Field(name = "description")
    private String description;

    @Builder.Default
    @Field(name = "accomplished")
    private Status accomplished = Status.PENDING;

}









