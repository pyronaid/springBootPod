package it.pyronaid.customSpringBootApp.controller;

import it.pyronaid.customSpringBootApp.Dto.LoginRequestDto;
import it.pyronaid.customSpringBootApp.Dto.LoginResponseDto;
import it.pyronaid.customSpringBootApp.Dto.UserDto;
import it.pyronaid.customSpringBootApp.Jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorizationController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/authentication/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto){
        if(loginRequestDto != null) {
            UserDto userDto = userRepository.findByUsername(loginRequestDto.getUsernameProvided());
            String errorMsgUsername = null;
            String errorMsgPassword = null;
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
}
