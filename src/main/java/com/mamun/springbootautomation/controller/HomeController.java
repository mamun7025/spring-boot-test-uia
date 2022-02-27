package com.mamun.springbootautomation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping({"/", "/home"})
    public String homePage(){
        return "home";
    }

    @RequestMapping("/about")
    public String aboutPage(){
        return "about";
    }

}
