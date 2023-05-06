package it.pyronaid.customSpringBootApp.Dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Document("User")
public class UserDto {
    @Id
    String id;

    String username;
    String password;
    String email;
    LocalDateTime firstSubscriptionDate;
}
