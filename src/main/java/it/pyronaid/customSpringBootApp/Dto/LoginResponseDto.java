package it.pyronaid.customSpringBootApp.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class LoginResponseDto {
    String errorMsgUsername;
    String errorMsgPassword;
    String responseCode;
    String responseMsg;
    UserDto userObj;
}
