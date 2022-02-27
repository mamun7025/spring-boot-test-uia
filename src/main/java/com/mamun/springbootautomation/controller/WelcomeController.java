package com.mamun.springbootautomation.controller;

import com.mamun.springbootautomation.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

//    /welcome?name=Jon

    private WelcomeService welcomeService;

    WelcomeController(WelcomeService welcomeService){
        this.welcomeService = welcomeService;
    }


    @RequestMapping("/welcome")
    public String welcome( @RequestParam(defaultValue = "Xyz") String name ){
        return welcomeService.getWelcomeMessage(name);
//        return "Welcome " + name +"!";
    }



}
