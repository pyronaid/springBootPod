package it.pyronaid.customSpringBootApp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {


    @RequestMapping("/healthCheck")
    public String healthCheck(){
        return "OK";
    }
}
