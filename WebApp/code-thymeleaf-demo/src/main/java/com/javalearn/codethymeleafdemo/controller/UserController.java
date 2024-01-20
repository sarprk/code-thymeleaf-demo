package com.javalearn.codethymeleafdemo.controller;

import com.javalearn.codethymeleafdemo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/variable-expression")
    public String getVariableExpression(Model model)
    {
        User userDto = new User("Rajesh","rajesh.kk@gn.com","TL", "Male");
        model.addAttribute("user", userDto);
        return "variable-expression";
    }

    @GetMapping("/selection-expression")
    public String getVSelectionExpression(Model model)
    {
        User userDto = new User("Rajesh","rajesh.kk@gn.com","TL", "Male");
        model.addAttribute("user", userDto);
        return "selection-expression";
    }
}
