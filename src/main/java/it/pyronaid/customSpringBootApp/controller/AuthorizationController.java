package it.pyronaid.customSpringBootApp.controller;

import it.pyronaid.customSpringBootApp.Dto.*;
import it.pyronaid.customSpringBootApp.Jpa.UserRepository;
import it.pyronaid.customSpringBootApp.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class AuthorizationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @PostMapping("/authentication/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto){
        UserDto userDto;
        String errorMsgUsername = null;
        String errorMsgPassword = null;
        if(loginRequestDto != null) {
            userDto = userRepository.findByUsername(loginRequestDto.getUsernameProvided());
            if (userDto == null) {
                errorMsgUsername = "No account found for user " + loginRequestDto.getUsernameProvided();
            } else if(!userDto.getPassword().equals(loginRequestDto.getPasswordProvided())){
                errorMsgPassword = "The password provided is not correct";
                userDto = null;
            }
            return new LoginResponseDto(errorMsgUsername, errorMsgPassword, null, null, userDto);
        } else {
            return null;
        }
    }


    @PostMapping("/authentication/register")
    public SignupResponseDto register(@RequestBody SignupRequestDto signupRequestDto){
        UserDto userDto;
        String errorMsgUsername = null;
        String errorMsgPassword = null;
        String errorMsgMail = null;
        boolean flag = true;
        if(signupRequestDto != null) {
            userDto = userRepository.findByUsername(signupRequestDto.getUsernameProvided());
            if(userDto != null){
                errorMsgUsername = "An account with the username " + signupRequestDto.getUsernameProvided() + " is already registered";
                flag = false;
                userDto = null;
            }
            userDto = userRepository.findByMail(signupRequestDto.getMailProvided());
            if(userDto != null){
                errorMsgMail = "An account with the email " + signupRequestDto.getMailProvided() + " is already registered";
                flag = false;
                userDto = null;
            }

            if(flag) {
                userDto = new UserDto();
                userDto.setUserId(sequenceGeneratorService.generateSequence("users_sequence"));
                userDto.setUsername(signupRequestDto.getUsernameProvided());
                userDto.setPassword(signupRequestDto.getPasswordProvided());
                userDto.setEmail(signupRequestDto.getMailProvided());
                userDto.setFirstSubscriptionDate(LocalDateTime.now());
                userDto = userRepository.save(userDto);
            }
            return new SignupResponseDto( errorMsgUsername, errorMsgPassword, errorMsgMail, null, null, userDto);
        } else {
            return null;
        }
    }


}
