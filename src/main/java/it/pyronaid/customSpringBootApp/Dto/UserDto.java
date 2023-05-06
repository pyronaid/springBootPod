package it.pyronaid.customSpringBootApp.Dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "Users")
public class UserDto {
    @Id
    Long id;

    String username;
    String password;
    String email;
    LocalDateTime firstSubscriptionDate;
}
