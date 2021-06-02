package it.academy.controller;

import it.academy.entity.Document;
import it.academy.entity.User;
import it.academy.service.SecurityService;
import it.academy.service.UserDetailsServiceImpl;
import it.academy.user.UserRoleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @GetMapping("/login")
    public String start(Model model, String error, String logout){
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @PostMapping("/login")
    public String login(
            @ModelAttribute User user){

        if("".equals(userDetailsServiceImpl.getRole(user))){
            return "login";
        }
        UserRoleUtil.setRole(userDetailsServiceImpl.getRole(user));

        return "redirect:/document";
    }

    @GetMapping("/account")
    public String accountPage(
            @RequestParam(value = "pageNumber", defaultValue = "1") String pageNumber,
            Model model
    ) {

        final int countInPage = 5;

        List<User> allDocument = userDetailsServiceImpl.getAllAccount(pageNumber, countInPage);

        model.addAttribute("accountsList", allDocument);

        model.addAttribute("pageCount", userDetailsServiceImpl.getNumberOfPage(countInPage));

        return "account-view";
    }
}
