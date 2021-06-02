package it.academy.controller;

import it.academy.entity.User;
import it.academy.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @GetMapping("/registration")
    public String registration(Model model) {

        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(
            @ModelAttribute User userForm
    ) {

        final boolean b = userDetailsServiceImpl.saveUser(userForm);
        if (!b){
//            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registration";
        }

        return "redirect:/document";
    }
}
