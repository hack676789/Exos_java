package ray.sn.domain.model;

import ray.sn.domain.model.Enum.Status;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Task {

    private String id;
    private String title;
    private String description;

    @Builder.Default
    private Status accomplished = Status.PENDING;

   
}









