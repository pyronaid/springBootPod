package it.pyronaid.customSpringBootApp.Dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Document("User")
public class UserDto {

    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private String id;

    private Long userId;
    private String username;
    private String password;
    private String email;
    private LocalDateTime firstSubscriptionDate;
}
