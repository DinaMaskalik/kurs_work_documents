package it.academy.controller;

import it.academy.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @GetMapping("/admin")
    public String userList(Model model) {
        model.addAttribute("allUsers", userDetailsServiceImpl.allUsers());
        return "admin";
    }

    @PostMapping("/admin")
    public String  deleteUser(@RequestParam(required = true, defaultValue = "" ) String userId,
                              @RequestParam(required = true, defaultValue = "" ) String action,
                              Model model) {
        if (action.equals("delete")){
            userDetailsServiceImpl.deleteUser(userId);
        }
        return "redirect:/admin";
    }

//    @GetMapping("/admin/gt/{userId}")
//    public String  gtUser(@PathVariable("userId") Long userId, Model model) {
////        model.addAttribute("allUsers", userService.usergtList(userId));
//        return "admin";
//    }
}
