package com.example.part_2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @RequestMapping("/home")
    public String home(Model page, @RequestParam(required = false) String color, @RequestParam(required = false) String name) {
        page.addAttribute("username", name);
        page.addAttribute("color", color);
        return "home.html";
    }

    @RequestMapping("/ex4/{color}")
    public  String ex4(Model page, @PathVariable String color) {
        page.addAttribute("username", "Lorry");
        page.addAttribute("color", color);
        return "home.html";
    }
}
