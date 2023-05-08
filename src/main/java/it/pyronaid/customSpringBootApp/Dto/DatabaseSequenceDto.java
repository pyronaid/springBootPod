package it.pyronaid.customSpringBootApp.Dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Document("DatabaseSequence")
public class DatabaseSequenceDto {
    @Id
    private String id;
    private int seq;
}
