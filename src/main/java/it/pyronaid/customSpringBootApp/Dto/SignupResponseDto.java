package it.pyronaid.customSpringBootApp.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class SignupResponseDto {
    String errorMsgUsername;
    String errorMsgPassword;
    String errorMsgMail;
    String responseCode;
    String responseMsg;
    UserDto userObj;
}
