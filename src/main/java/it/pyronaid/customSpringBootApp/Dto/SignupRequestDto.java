package it.pyronaid.customSpringBootApp.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class SignupRequestDto {
    String usernameProvided;
    String passwordProvided;
    String mailProvided;
}
