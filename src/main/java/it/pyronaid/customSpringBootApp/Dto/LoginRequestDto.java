package it.pyronaid.customSpringBootApp.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class LoginRequestDto {
    String usernameProvided;
    String passwordProvided;
}
