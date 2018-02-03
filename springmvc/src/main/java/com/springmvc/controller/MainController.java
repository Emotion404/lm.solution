package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String indexPage(){
        return "index";
    }

    @RequestMapping("/main")
    public String mainPage(){
        return "main";
    }

    @RequestMapping("/upload")
    public String uploadPage(){
        return "FileUpload/upload";
    }

    @RequestMapping("/ImageValidateCodeLogin")
    public String login(){
        return "Login/imageValidateCodeLogin";
    }

}
