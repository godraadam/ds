package dev.godraadam.dsassingment.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@Controller
public class LandingPage {
    
    @GetMapping("/")
    public String hello() {
        return "Energy App Server is running";
    }
}
