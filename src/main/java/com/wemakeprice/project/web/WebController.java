package com.wemakeprice.project.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
	
    @GetMapping("/")
    public String parse(Model model) {
        return "urlConversion";
    }
}
